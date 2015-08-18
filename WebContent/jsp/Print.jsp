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

<div class="alert">
<button type="button" class="close" data-dismiss="alert">&times;</button>
<strong>人事查詢列印</strong> 
<div id="funbtn" rel="popover" title="說明" 
data-content="選擇範圍點選列印，標題、統計等其它細節資料，於報表中的頁首/頁尾，請以預覽列印檢視" data-placement="right" class="btn btn-warning">?</div>
</div>

<form action="/hris/Print" class="form-horizontal">

<table class="table text-info">
	<tr>
		
		<td class="control-group info" width="100%">
		<div class="btn-group">
			<button class="btn" name="method:StayTimePrint">留校時間</button>
			<button class="btn" name="method:RetirePrint">退撫資料</button>
			<button class="btn" name="method:BirthPrint">當月生日</button>
		</div>
		</td>
	</tr>
</table>




</form>

</body>
</html>