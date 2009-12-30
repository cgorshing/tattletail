package com.brightdome.tattletale.service

import com.brightdome.tattletale.domain.Build
import com.brightdome.tattletale.domain.BuildServer

import grails.test.GrailsUnitTestCase

class BuildServerServiceTests extends GrailsUnitTestCase {

	void testEmptyProjectList() {

		mockDomain(Build)
		mockDomain(BuildServer, [])

		def testService = new BuildServerService()

		assertNotNull testService.update()
	}

	void testSingleProject() {
			
		mockDomain(Build)
		def result = new Expando()
		result.name = 'cleanup-artifacts-B'
		mockDomain(BuildServer, [new BuildServer(url:"http://somewhere.com", builds:[result])])

		Expando mockedXmlParser= new Expando()
		def projects = new Node(null, 'Projects')
		def childAttributes = [
			name:"cleanup-artifacts-B",
			activity:"Sleeping",
			lastBuildStatus:"Success",
			lastBuildLabel:"build.189",
			lastBuildTime:"2009-12-12T07:49:23",
			webUrl:"http://build.eclipse.org:7777/dashboard/tab/build/detail/cleanup-artifacts-B"
		]
		projects.appendNode('Project', childAttributes)
		mockedXmlParser.parse = { projects }

		def testService = new BuildServerService(xmlParser:mockedXmlParser)

		assertEquals 1, testService.update().size()
	}
}
