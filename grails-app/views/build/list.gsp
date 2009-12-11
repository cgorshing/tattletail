<%@ page import="com.brightdome.tattletale.domain.Build" %>
<html>
    <head>
        <meta http-equiv="refresh" content="10"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'styles.css')}" />
		<g:javascript library="prototype" />
		<g:javascript library="date" />
		
		<script type="text/javascript">
      		document.observe("dom:loaded", function() 
      		{
        		$$("span.build_time").each(function(element) 
        		{
        			var dateString = element.innerHTML.replace("T", "").replaceAll("-", ",");
          			var ts = new Date(dateString);
          			element.innerHTML = ts.relativeTimeInWords(new Date());
        		});
      		});
    	</script>
    	
    	<style type="text/css">
      		.status {
       			width: ${ (int)(100 / columns) }%;
       			height: ${ 100 / rows }%;
      		}
      		h1 {
        		margin-top: ${ 50 / rows }px;
        		font-size: ${ 100 / rows * 1.5 }px;
      		}
    </style>
		        
    </head>
    <body>
        <g:each in="${builds}" status="i" var="build">
        	<div class="status ${build.status}">
	        	<div class="border">
	          		<h1 class="${build.activity}"><a href="${build.url}">${build.alias}</a></h1>
	          		<p>Build <strong>${build.label}</strong> was a <strong>${build.status}</strong> <span class="build_time" title="${build.time}">${build.time}</span></p>
	          	</div>
	        </div>
        </g:each>
    </body>
</html>
