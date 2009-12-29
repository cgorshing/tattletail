package com.brightdome.tattletale.controllers

import com.brightdome.tattletale.domain.Build;

class BuildController {
    
	def buildServerService
	
	def index = { redirect(action:list,params:params) }
	
	// the delete, save and update actions only accept POST requests
    static def allowedMethods = []

    def list = {
        if(!params.max) params.max = 10
        params.order = "asc"
		
		def builds = buildServerService.update() 

		def columns = 1
		if ( builds.size() > 4 ) columns = 2
		if ( builds.size() > 10 ) columns = 3
		if ( builds.size() > 21 ) columns = 4
		
		def rows = Math.ceil( builds.size() / columns )

		[ builds: builds, rows: rows, columns: columns ]
    }
}