package com.brightdome.tattletale.service

import org.ho.yaml.Yaml
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ApplicationContext

public class BuildService implements ApplicationContextAware
{
    ApplicationContext applicationContext

	def xmlParser

	public List retrieveBuilds()
	{
            def buildServers = Yaml.loadStream( applicationContext.getResource( "classpath:config.yml" ).getFile() )
            def projects = []
            buildServers.each { projects += retrieveMoniteredBuilds( it ) }
            projects
	}
	
	private List retrieveMoniteredBuilds( buildServer )
	{
            def projects = []
            try
            {
                projects = xmlParser.parse( buildServer.url )
            }
            catch ( all )
            {
                all.printStackTrace()
            }

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