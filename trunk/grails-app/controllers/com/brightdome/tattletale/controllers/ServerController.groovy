package com.brightdome.tattletale.controllers

import com.brightdome.tattletale.domain.Server

class ServerController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        params.order = "asc"
        [ serverList: Server.listOrderBySequence(params) ]
    }

    def show = {
        def server = Server.get( params.id )

        if(!server) {
            flash.message = "Server not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ server : server ] }
    }

    def delete = {
        def server = Server.get( params.id )
        if(server) {
            server.delete()
            flash.message = "Server ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Server not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def server = Server.get( params.id )

        if(!server) {
            flash.message = "Server not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ server : server ]
        }
    }

    def update = {
        def server = Server.get( params.id )
        if(server) {
            server.properties = params
            if(!server.hasErrors() && server.save()) {
                flash.message = "Server ${params.id} updated"
                redirect(action:show,id:server.id)
            }
            else {
                render(view:'edit',model:[server:server])
            }
        }
        else {
            flash.message = "Server not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def server = new Server()
        server.properties = params
        return ['server':server]
    }

    def save = {
        def server = new Server(params)
        if(!server.hasErrors() && server.save()) {
            flash.message = "Server ${server.id} created"
            redirect(action:show,id:server.id)
        }
        else {
            render(view:'create',model:[server:server])
        }
    }
}
