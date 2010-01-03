package com.brightdome.tattletale.controllers

class BuildController {
    
	def buildService
	
	def index = { redirect(action:list, params:params) }
	
	// the delete, save and update actions only accept POST requests
	static def allowedMethods = []

	def list = {
		def builds = buildService.retrieveBuilds()

		def columns = 1
		if ( builds.size() > 4 ) columns = 2
		if ( builds.size() > 10 ) columns = 3
		if ( builds.size() > 21 ) columns = 4
		
		def rows = Math.ceil( builds.size() / columns )

		[ builds: builds, rows: rows, columns: columns ]
	}
}