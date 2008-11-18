package com.brightdome.tattletale.service

import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.HttpException
import org.apache.commons.httpclient.methods.GetMethod

import com.brightdome.tattletale.domain.ProjectStatusReport
import com.brightdome.tattletale.domain.Projects
import com.brightdome.tattletale.domain.Server
import com.brightdome.tattletale.service.parsers.CruiseControlDotNetStatusReportParser

public class ServerService
{
	
	public void update(List<Server> servers)
	{
		for (Server server : servers)
		{
			update(server)
		}
	}

	private String update(Server server)
	{
		String xml = retrieveStatus(server.url)
        CruiseControlDotNetStatusReportParser parser = new CruiseControlDotNetStatusReportParser()
        Projects projects = parser.parse(xml)
        for (ProjectStatusReport report : projects.projects)
        {
        	if (report.name == server.name)
        	{
        		server.status = report.lastBuildStatus
        		server.activity = report.activity
        		server.save()
        	}
        }
	}
	
	private String retrieveStatus(String url)
	{
		HttpClient httpClient = new HttpClient()
		String xml = ""
        try
        {
            GetMethod getMethod = new GetMethod(url)
            httpClient.executeMethod(getMethod)
            xml = getMethod.getResponseBodyAsString()
        }
        catch (HttpException e)
        {
            e.printStackTrace()
        }
        catch (IOException e)
        {
            e.printStackTrace()
        }
        return xml
	}
}