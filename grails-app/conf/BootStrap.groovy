import com.brightdome.tattletale.domain.Serverclass BootStrap {

     def init = { servletContext ->
     	new Server(alias:"WTP R3 1-I", name:"wtp-R3.1-I", url:"http://build.eclipse.org:7777/dashboard/cctray.xml", status:"", activity:"", sequence:2).save()     	new Server(alias:"WTP R3 1-I", name:"wtp-R3.1-N", url:"http://build.eclipse.org:7777/dashboard/cctray.xml", status:"", activity:"", sequence:3).save()     	new Server(alias:"Patches R1.5.5-P", name:"patches-R1.5.5-P", url:"http://build.eclipse.org:7777/dashboard/cctray.xml", status:"", activity:"", sequence:1).save()     }
     def destroy = {
     }
} 