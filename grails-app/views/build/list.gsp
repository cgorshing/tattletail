<%@ page import="com.brightdome.tattletale.domain.Build" %>
<html>
    <head>
        <meta http-equiv="refresh" content="10"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <style>
			html, body {
				/* margins can get messy on containers */
				margin: 0;
				padding: 0;
				background-color: black;
			}
			.row {
				text-align: center;
				font-family: sans-serif;
				font-size: 300%;
				padding-top: 6%;
			}
		</style>
        
		<g:javascript library="jquery"/>	
		<jq:plugin name="flexify"/>
		<jq:plugin name="sound"/>
		<script>
			$(function () {
				$('html, body, .row').flex('height', 1);
				$(document).flexify();
			});

<!--			jQuery(document).ready(function() {-->
<!--               	$("#sound_player").sound({swf: "${createLinkTo(dir:'js/jquery', file:'Player.swf')}", file: "http://www.digitalxero.net/music/Pour_Another_Round.mp3"});-->
<!--            });-->
				
		</script>
    </head>
    <body>
        <g:each in="${buildInstanceList}" status="i" var="build">
			<g:if test="${'Building' == build.activity }">
				<div class="row" style="background: yellow">
			</g:if>
			<g:elseif test="${'Success' == build.status }">
				<div class="row" style="background: green">
			</g:elseif>
			<g:elseif test="${'Failure' == build.status }">
				<div class="row" style="background: red">
			</g:elseif>
			<g:else>
				<div class="row" style="background: white">
			</g:else>
	        		${fieldValue(bean:build, field:'alias')}
	        </div>
	        
	        <g:if test="${i < buildInstanceList.size() - 1}">
	        	<br/>
	        </g:if>
	    </g:each>
	    
	    <div id="sound_player"></div>
    </body>
</html>
