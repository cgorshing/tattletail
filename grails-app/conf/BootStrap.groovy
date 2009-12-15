import com.brightdome.tattletale.domain.BuildServerclass BootStrap {

     def init = { servletContext ->
     	new BuildServer(url:"http://localhost:8080/tattletale/cctray.xml")     		.addToBuilds(alias:"Patches R1.5.5-P", name:"dali-R2.2.0-I", sequence:1)     		.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.2.0-I", sequence:2)     		.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.1.2-M", sequence:3)     		.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.1.2-M", sequence:4)     		.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.1.2-M", sequence:5)			.addToBuilds(alias:"Patches R1.5.5-P", name:"dali-R2.2.0-I", sequence:6)			.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.2.0-I", sequence:7)			.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.1.2-M", sequence:8)			.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.1.2-M", sequence:9)			.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.1.2-M", sequence:10)			.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.1.2-M", sequence:11)			.addToBuilds(alias:"WTP R3 1-I", name:"wtp-R3.1.2-M", sequence:11)     		.save()          }
     def destroy = {
     }
} 