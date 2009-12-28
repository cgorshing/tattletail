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
}