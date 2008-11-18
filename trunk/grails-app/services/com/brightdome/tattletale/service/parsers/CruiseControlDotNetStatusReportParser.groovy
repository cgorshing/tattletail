package com.brightdome.tattletale.service.parsers

import com.brightdome.tattletale.domain.Projects;
import com.thoughtworks.xstream.XStream;

public class CruiseControlDotNetStatusReportParser implements StatusReportParser
{
    public Projects parse(String xml)
    {
        XStream xstream = new XStream();
        xstream.processAnnotations(Projects.class);
        Projects projects = (Projects)xstream.fromXML(xml);
        return projects;
    }
}