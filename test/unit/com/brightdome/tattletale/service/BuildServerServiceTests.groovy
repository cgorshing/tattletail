package com.brightdome.tattletale.service

import com.brightdome.tattletale.domain.Build
import com.brightdome.tattletale.domain.BuildServer

import grails.test.GrailsUnitTestCase

class BuildServerServiceTests extends GrailsUnitTestCase {

  def input = '''
---
url: http://localhost:8080/tattletale/cctray.xml
builds:
    - name: cleanup-artifacts-B
        alias: ONE
        sequence: 1
    - name: cleanup-artifacts-B
        alias: TWO
        sequence: 2
    - name: cleanup-artifacts-B
        alias: THREE
        sequence: 3
---
url: http://localhost:8080/tattletale/cctray.xml
builds:
    - name: cleanup-artifacts-B
        alias: FOUR
        sequence: 4
    - name: cleanup-artifacts-B
        alias: FIVE
        sequence: 5
    - name: cleanup-artifacts-B
        alias: SIX
        sequence: 6
'''

	void testEmptyProjectList() {
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

		assertNotNull testService.update()
	}

	void testSingleProject() {
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