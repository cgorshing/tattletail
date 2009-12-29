package com.brightdome.tattletale.service

import com.brightdome.tattletale.domain.Build
import com.brightdome.tattletale.domain.BuildServer

public class BuildServerService
{
	public List update()
	{
		def projects = []
		
		BuildServer.list().each { projects += updateBuildStatus( it ) }
		projects
	}
	
	private List updateBuildStatus( BuildServer buildServer )
	{
		def projects = new XmlParser().parse( buildServer.url )
		def moniteredProjects = []
		
		buildServer.builds.each { build -> 
			def project = projects.find { p -> p.'@name' ==~ build.name }
			
			if ( project != null )
			{
				build.status = project.'@lastBuildStatus'.toLowerCase()
				build.activity = project.'@activity'
				build.label = project.'@lastBuildLabel'
				build.url = project.'@webUrl'
				build.time = new Date().parse( "yyyy-MM-dd'T'HH:mm:ss",  project.'@lastBuildTime'.replace( "Z", "") )
				moniteredProjects += build
			}
		}
		
		moniteredProjects.sort { it.sequence }
	}
}