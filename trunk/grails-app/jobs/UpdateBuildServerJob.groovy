import com.brightdome.tattletale.domain.BuildServer

class UpdateBuildServerJob 
{
    def timeout = 15000l 
    def startDelay = 30000l
    def group = "default"
    
    def buildServerService

    def execute() 
    {
    	buildServerService.update(BuildServer.list())
    }
}
