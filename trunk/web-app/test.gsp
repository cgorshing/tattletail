<html>
    <head>
        <title>Tattle Tale</title>
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
			}
		</style>
        
		<g:javascript library="jquery"/>	
		<jq:plugin name="flexify"/>
		<script>
			$(function () {
				$('html, body, .row').flex('height', 1);
				$(document).flexify();
			});
		</script>
    </head>
    <body>
        <div class="row" style="background: red;">
        		TAS Return
        </div>
        <br/>
		<div class="row" style="background: yellow">TAS RA</div>
		<br/>
		<div class="row" style="background: green">TAS Credit Auth</div>
		<br/>
		<div class="row" style="background: blue">TAS Rates</div>
    </body>
</html>