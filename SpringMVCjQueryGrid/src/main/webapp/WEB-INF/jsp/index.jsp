<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jqGird in Servlet</title>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/ui.jqgrid.css">

<script src="js/jquery-1.10.0.min.js" type="text/javascript"></script>
<script src="js/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.js" type="text/javascript"></script>
<script src="js/grid.formedit.js" type="text/javascript"></script>
<script src="js/jquery-ui.js" type="text/javascript"></script>
<script src="js/getJqGridData.js" type="text/javascript"></script>
</head>
<body>
	<span id="contextPath" style="display: none;"><%=request.getContextPath()%></span>
	<table id="list">
	</table>
	<div id="pager"></div>
	<!-- <table id="list">
		<tr>
			<td />
		</tr>
	</table>
	<div id="pager"></div> -->
</body>
</html>