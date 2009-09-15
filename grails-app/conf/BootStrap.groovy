import com.brightdome.tattletale.domain.BuildServerclass BootStrap {

     def init = { servletContext ->
     	new BuildServer(url:"http://build.eclipse.org:7777/dashboard/cctray.xml")     		.addToBuilds(alias:"Patches R1.5.5-P", name:"patches-R1.5.5-P", status:"", activity:"", sequence:4)     		.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.1-I", status:"", activity:"", sequence:2)     		.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.1-N", status:"", activity:"", sequence:3)     		.save()          	new BuildServer(url:"http://www.galleonsoftware.com/dashboard/cctray.xml")     		.addToBuilds(alias:"Adam", name:"adam", status:"", activity:"", sequence:1)     		.save()     }
     def destroy = {
     }
} 