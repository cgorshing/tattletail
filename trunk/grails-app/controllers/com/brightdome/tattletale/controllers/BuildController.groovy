package com.brightdome.tattletale.controllers

import com.brightdome.tattletale.domain.Build;

class BuildController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        params.order = "asc"
		
		def builds = Build.listOrderBySequence( params )

		def columns = 1
		
		switch ( builds.size() )
		{
			case ( 0..4 ):
				columns = 1 
				break
			case ( 5..10 ):
				columns = 2
				break
			case ( 11..21 ):
				columns = 3
				break
			case ( 21..100):
			 	columns = 4
			 	break
		}
		
		def rows = Math.ceil( builds.size() / columns )

		[ builds: builds, rows: rows, columns: columns ]
    }

    def show = {
        def buildInstance = Build.get( params.id )

        if(!buildInstance) {
            flash.message = "Build not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ buildInstance : buildInstance ] }
    }

    def delete = {
        def buildInstance = Build.get( params.id )
        if(buildInstance) {
            buildInstance.delete()
            flash.message = "Build ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Build not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def buildInstance = Build.get( params.id )

        if(!buildInstance) {
            flash.message = "Build not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ buildInstance : buildInstance ]
        }
    }

    def update = {
        def buildInstance = Build.get( params.id )
        if(buildInstance) {
            buildInstance.properties = params
            if(!buildInstance.hasErrors() && buildInstance.save()) {
                flash.message = "Build ${params.id} updated"
                redirect(action:show,id:buildInstance.id)
            }
            else {
                render(view:'edit',model:[buildInstance:buildInstance])
            }
        }
        else {
            flash.message = "Build not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def buildInstance = new Build()
        buildInstance.properties = params
        return ['buildInstance':buildInstance]
    }

    def save = {
        def buildInstance = new Build(params)
        if(!buildInstance.hasErrors() && buildInstance.save()) {
            flash.message = "Build ${buildInstance.id} created"
            redirect(action:show,id:buildInstance.id)
        }
        else {
            render(view:'create',model:[buildInstance:buildInstance])
        }
    }
}