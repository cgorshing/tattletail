package com.brightdome.tattletale.domain

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString

import com.thoughtworks.xstream.annotations.XStreamAlias
import com.thoughtworks.xstream.annotations.XStreamAsAttribute

@XStreamAlias("Project")
public class Project
{
	@XStreamAsAttribute
    String  name

    @XStreamAsAttribute
    String  activity

    @XStreamAsAttribute
    String  lastBuildStatus

    @XStreamAsAttribute
    String  lastBuildLabel

    @XStreamAsAttribute
    String  lastBuildTime

    @XStreamAsAttribute
    String  nextBuildTime

    @XStreamAsAttribute
    String  webUrl	
    
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