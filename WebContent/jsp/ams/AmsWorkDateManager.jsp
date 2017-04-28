<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>差勤記錄管理</title>

<link href="/eis/inc/css/jquery-ui.css" rel="stylesheet"/>
</head>
<body>
<div class="bs-callout bs-callout-info" id="callout-helper-pull-navbar">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>差勤記錄管理</strong>    
</div>

<form action="AmsWorkDateManager" class="form-inline"method="post">

<div class="panel panel-primary">
	<div class="panel-heading">新增或查詢</div>
  	<div class="panel-body">
	    <input class="dtpick form-control" type="text" id="${c.name}" placeholder="點一下輸入日期" name="cdate" value="${c.date}"/>
		
	</div>
</div>
		




</form>
<script src="/eis/inc/js/plugin/bootstrap-tooltip.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui-timepicker-addon.js"></script>
<script>

$(".dtpick").datepicker({
	changeMonth: true,
	changeYear: true,
	//minDate: '@minDate'
	yearRange: "-100:+0"
	//showButtonPanel: true,
	//dateFormat: 'yy-MM-dd'
});

//$("input[name='beginDate'], input[name='endDate']" ).datepicker();



</script>
</body>



</html>