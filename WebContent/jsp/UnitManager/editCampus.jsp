<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>校區資料管理</title>
<script src="/eis/inc/js/plugin/bootstrap-typeahead.js"></script>
<script src="/eis/inc/js/plugin/json2.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui.js"></script>

<script src="/eis/inc/js/plugin/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script>  
$(document).ready(function() {
	
	$(".eoid").typeahead({
		//remote:"#agent",
		source : [],
		items : 10,
		updateSource:function(inputVal, callback){			
			$.ajax({
				url:"/eis/autoCompleteEmplOid",
			    dataType: 'jsonp',
			    jsonp:'back',          //jsonp請求方法
			    data:{nameno:inputVal},
			    cache:false,
			    type:'POST',
			    success: function(d) {
			    	
			    	callback(d.list);
			    }
			});
		}		
	});
	
});



</script>


</head>
<body>







<div class="bs-callout bs-callout-warning" id="callout-helper-pull-navbar">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>校區資料管理</strong>
</div>

<form action="UnitManager" class="form" method="post">
<div class="panel panel-primary">
<div class="panel-heading">${unit.name}</div>	
<table class="table">
	<tr>
		<td>
		
		
		
		<input type="hidden" name="id" value="${unit.id}"/>
		
		<p>
		<div class="input-group">
		<span class="input-group-addon">校區名稱</span>
		<input type="text" name="name" class="form-control" value="${unit.name}"/>
		</div>
		</p>
		
		<p>
		<div class="input-group">
		<span class="input-group-addon">校區地址</span>
		<input class="form-control" type="text" name="ename" value="${unit.address}"/>
		</div>
		</p>
		
		<p>
		<div class="input-group">
		<span class="input-group-addon">校區主管</span>
		<input type="text" autocomplete="off" class="form-control eoid" id="leader" <c:if test="${!empty unit.leaderOid}">value="${unit.leaderOid},${unit.leaderName}"</c:if> name="leader" onClick="$(this).val('')"/>
		</div>
		</p>
		
		<p>
		<div class="input-group">
		<span class="input-group-addon">主管助理</span>
		<input type="text" autocomplete="off"  class="form-control eoid" id="assistant" <c:if test="${!empty unit.assOid}">value="${unit.assOid},${unit.assName}"</c:if> name="assistant" onClick="$(this).val('')"/>
		</div>
		</p>
		
		
		</td>
	</tr>
	
	
	
	<tr>
		<td>
		<button class="btn btn-danger" name="method:saveCampus" type="submit">儲存</button>
		<a href="UnitManager" class="btn btn-default">離開</a>
		</td>
	</tr>
	
</table>
</div>


</form>

</body>
</html>