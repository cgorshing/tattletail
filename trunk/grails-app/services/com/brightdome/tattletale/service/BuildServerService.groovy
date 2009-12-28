package com.brightdome.tattletale.service

import com.brightdome.tattletale.domain.Build
import com.brightdome.tattletale.domain.BuildServer

public class BuildServerService
{
	public List update()
	{
		def projects = []
		
		for ( BuildServer buildServer : BuildServer.list() )
		{
			projects = update( buildServer )
		}
		
		return projects
	}
	
	private List update(BuildServer buildServer)
	{
		def projects = new XmlParser().parse( buildServer.url )
		def moniteredProjects = []
		
		for (Build build: buildServer.builds)
        {
			  def project = projects.find { it.'@name' ==~ build.name }
			  if ( project != null )
			  {
				  build.status = project.'@lastBuildStatus'
				  build.activity = project.'@activity'
				  build.label = project.'@lastBuildLabel'
				  build.url = project.'@webUrl'
				  build.time = new Date().parse( "yyyy-MM-dd'T'HH:mm:ss", project.'@lastBuildTime' )
				  moniteredProjects.add( build )
			  }
        }
		
		return moniteredProjects.sort { it.sequence }
	}
}