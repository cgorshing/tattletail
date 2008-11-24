package com.brightdome.tattletale.service

import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.HttpException
import org.apache.commons.httpclient.methods.GetMethod

import com.brightdome.tattletale.domain.Projects
import com.brightdome.tattletale.domain.Project
import com.brightdome.tattletale.domain.Build
import com.brightdome.tattletale.domain.BuildServer
import com.brightdome.tattletale.service.parsers.CruiseControlDotNetStatusReportParser

public class BuildServerService
{
	public void update(List<BuildServer> buildServers)
	{
		for (BuildServer buildServer : buildServers)
		{
			update(buildServer)
		}
	}
	
	private void update(BuildServer buildServer)
	{
		try
		{
			String xml = retrieveStatus(buildServer.url)
			CruiseControlDotNetStatusReportParser parser = new CruiseControlDotNetStatusReportParser()
	        Projects projects = parser.parse(xml)
	        for (Build build: buildServer.builds)
	        {
	        	  for (Project project : projects.projects)
	              {
	              	if (project.name == build.name)
	              	{
	              		build.status = project.lastBuildStatus
	              		build.activity = project.activity
	              		build.save()
	              	}
	              }
	        }
		}
		catch (Exception e)
		{
			println("An exception was encountered retrieving status for " + buildServer.url)
		}
	}

	private String retrieveStatus(String url) throws Exception
	{
		HttpClient httpClient = new HttpClient()
		String xml = ""
        
        GetMethod getMethod = new GetMethod(url)
        httpClient.executeMethod(getMethod)
        xml = getMethod.getResponseBodyAsString()
        
        return xml
	}
}