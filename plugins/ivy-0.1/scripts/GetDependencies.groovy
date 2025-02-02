
Ant.property(environment:"env")                             
grailsHome = Ant.antProject.properties."env.GRAILS_HOME"

includeTargets << new File ( "${grailsHome}/scripts/Init.groovy" )

task ("default": "Default task") {
    depends( configureProxy )
    dependencies()
}

task ( dependencies: "Downloads dependencies from remote repository" ) {		
	if (new File("${basedir}/ivy.xml").exists() && new File("${basedir}/ivyconf.xml").exists()) {
		ivyDeps()
	}
}

task ( ivyDeps : "Gets dependencies from remote repository") {
	try {
		Ant.taskdef(name:"ivyretrieve", classname:"fr.jayasoft.ivy.ant.IvyRetrieve")
	} catch (Exception e) {
		throw new Exception("Ivy task not installed: Run 'grails install-ivy'")
	}

    event("StatusUpdate", ["Getting Ivy dependencies"])
	Ant.ivyretrieve()
    event("StatusFinal", ["Retrieved Ivy dependencies"])
}

