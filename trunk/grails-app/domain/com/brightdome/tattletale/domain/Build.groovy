package com.brightdome.tattletale.domain

public class Build
{
	static belongsTo = [buildServer:BuildServer]

	static constraints = {
		status(nullable:true)
		activity(nullable:true)
		url(nullable:true)
		time(nullable:true)
		label(nullable:true)
	}
	
	String name
	String alias
	String status
	String activity
	String url
	Date time
	String label
	int sequence
}