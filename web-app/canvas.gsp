<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>

<title>JQuery background canvas demos</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="en">

<g:javascript library="jquery"/>	
<jq:plugin name="corners"/>
<jq:plugin name="newExcanvas"/>

<script>
	$(document).ready(function() {
	//$('#main').corners({ borderSize: 6, borderColor: '#FF0000' });
	$('#main, #use, #doc, #examples').corners();
	
	//Examples
	$('#example_1').corners();
	$('#example_2').corners({ inColor: '#8FC7FF' });
	$('#example_3').corners({ inColor: '#FEFF8F', outColor: '#000' });
	$('#example_4').corners({ radio: 30, borderSize: 2 });
	$('#example_5').corners({ radio: 40, inColor: '#FFCC66', outColor: '#D2FBAE', borderSize: 2, borderColor: '#0000FF' });
	
	});
</script>



<link rel="stylesheet" type="text/css" href="BackgroundCanvasDemo_files/Body.css">
<link rel="stylesheet" type="text/css" href="BackgroundCanvasDemo_files/Content.css">
<link rel="stylesheet" type="text/css" href="BackgroundCanvasDemo_files/BackgroundCanvasDemo.css">

</head>
	<body>
		<div id="example_3" class="example">
			<span>DIV #example_3asdasdkjalksdasd
			aasdjlaksjdaldsjalsdjasld
			<p/>
			<p/></span>
		</div>
	</body>
</html>