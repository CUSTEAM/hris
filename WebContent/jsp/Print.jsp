<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事報表列印</title>
</head>
<body>

<div class="bs-callout bs-callout-warning" id="callout-helper-pull-navbar">
<button type="button" class="close" data-dismiss="alert">&times;</button>
<strong>報表列印</strong> 
</div>

<form action="/hris/Print" class="form-horizontal">

<table class="table">
	<tr>
		
		<td width="100%">
		<div class="btn-group">
			<button class="btn btn-default" name="method:StayTimePrint">課後輔導時間</button>
			<button class="btn btn-default" name="method:StayTimePrintLife">生活輔導時間</button>
			<button class="btn btn-default" name="method:RetirePrint">退撫資料</button>
			<button class="btn btn-default" name="method:BirthPrint">當月生日</button>
		</div>
		</td>
	</tr>
</table>




</form>

</body>
</html>