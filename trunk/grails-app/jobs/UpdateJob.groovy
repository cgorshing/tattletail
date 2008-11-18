import com.brightdome.tattletale.domain.Server

class UpdateJob 
{
    def timeout = 15000l 
    def startDelay = 30000l
    def group = "default"
    
    def serverService

    def execute() 
    {
    	serverService.update(Server.list())
    }
}