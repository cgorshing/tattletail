package com.brightdome.tattletale.domain;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString

import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamImplicit

@XStreamAlias("Projects")
public class Projects
{
    @XStreamImplicit(itemFieldName="Project")
    List<Project> projects = new ArrayList<Project>()

    public List<Project> getProjects()
    {
        return projects
    }

    public void setProjects(List<Project> projects)
    {
        this.projects = projects
    }

    @Override
    public String toString()
    {
        return reflectionToString(this)
    }

    @Override
    public boolean equals(Object obj)
    {
        return reflectionEquals(this, obj)
    }
	
	@Override
    public int hashCode()
    {
        return reflectionHashCode(this)
    }
}