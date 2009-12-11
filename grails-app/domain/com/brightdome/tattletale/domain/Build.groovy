package com.brightdome.tattletale.domain

public class Build
{
	static belongsTo = [buildServer:BuildServer]
	
	String name
	String alias
	String status
	String activity
	String url
	String time
	String label
	int sequence
}