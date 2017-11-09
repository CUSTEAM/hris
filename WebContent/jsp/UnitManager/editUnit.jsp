<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>單位資料管理</title>
<script src="/eis/inc/js/plugin/bootstrap-typeahead.js"></script>
<script src="/eis/inc/js/plugin/json2.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui.js"></script>
<script src="/eis/inc/js/plugin/bootstrap-tooltip.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<link href="/eis/inc/css/bootstrap-tree.css" rel="stylesheet"/>

<script src="/eis/inc/js/plugin/jquery.chained.min.js"></script>
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
	
	$("#sub_oid").chained("#parent_oid"); 	
	$("#parent_unit").chained("#campus");	
	
});
</script>
</head>
<body>
<div class="bs-callout bs-callout-warning" id="callout-helper-pull-navbar">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>單位資料管理</strong>
</div>

<form action="UnitManager" method="post">	
<input type="hidden" name="id" value="${unit.id}"/>
<div class="panel panel-primary">
<div class="panel-heading">${unit.name}</div>	
<table class="table">
	<tr>
		
		<td>
		<p><select class="form-control" onMouseup="checkUnit();" name="campus">
			<c:forEach items="${allUnit}" var="c">
			<option <c:if test="${c.id eq unit.campus}">selected</c:if> value="${c.id}">${c.name}</option>
			</c:forEach>
		</select></p>
		
		<p><select class="form-control" id="parent_unit" name="pid" 
		onMouseup="checkUnit();" name="parent_unit" <c:if test="${unit.pid eq'0'}">style="display:none"</c:if>>			
			<option value="0"></option>
			<c:forEach items="${allUnit}" var="c">
				<c:forEach items="${c.unit}" var="u">
				<option <c:if test="${u.id eq unit.pid}">selected</c:if> value="${u.id}" class="${c.id}">${u.name}</option>
				</c:forEach>
			</c:forEach>
		</select></p>
		<div class="form-group has-default">		
		<div class="input-group">
		<span class="input-group-addon">單位名稱</span>
		<input type="text" class="form-control" name="name" value="${unit.name}"/>
		</div>
		</div>
		
		
		<div class="input-group">
		<span class="input-group-addon">英文名稱</span>
		<input class="form-control" type="text" name="ename" value="${unit.ename}"/>
		</div>
		
		</td>
	</tr>

	<!--tr>
		<td nowrap>代碼/簡稱</td>
		<td width="100%">
		<input type="hidden" name="id" readonly class="span1" value="${unit.id}"/>
		<input type="text" class="" name="sname" value=""/>		
		</td>
	</tr-->
	<tr>
		<td>
		
		
					
		<p>
		<div class="input-group">
		<span class="input-group-addon">位置描述</span>
		<input class="form-control" type="text" name="location" value="${unit.location}"/>
		</div>
		</p>
		<p>	
		<div class="input-group">
		<span class="input-group-addon">連絡電話</span>
		<input class="form-control" type="text" name="phone" value="${unit.phone}"/>
		</div>
		</p>
		<p>
		<div class="input-group">
		<span class="input-group-addon">傳真電話</span>
		<input class="form-control" type="text" name="fax" value="${unit.fax}"/>
		</div>
		</p>
		<p>
		<div class="input-group">
		<span class="input-group-addon">電子郵件</span>
		<input class="form-control" type="text" name="email" value="${unit.email}"/>
		</div>
		</p>
		<p>
		<div class="input-group">
		<span class="input-group-addon">單位網址</span>
		<input class="form-control" type="text" name="website" value="${unit.website}"/>
		</div>		
		</p>
		<p>
		<div class="input-group">
		<span class="input-group-addon">單位主管</span>		
		<input type="text" autocomplete="off" class="eoid form-control" id="leader" <c:if test="${!empty unit.leaderOid}">value="${unit.leaderOid},${unit.leaderName}"</c:if> name="leader" onClick="$(this).val('')"/>
		</div>				
		</p>
		<p>
		<div class="input-group">
		<span class="input-group-addon">主管助理</span>		
		<input type="text" autocomplete="off" class="eoid form-control" id="assistant" <c:if test="${!empty unit.assOid}">value="${unit.assOid},${unit.assName}"</c:if> name="assistant" onClick="$(this).val('')"/>
		</div>
		</p>
		</td>
	</tr>
	<tr>
		<td>
		
		
		<button class="btn btn-danger" name="method:saveUnit" type="submit">儲存</button>
		<a href="UnitManager" class="btn btn-default">離開</a>
		</td>
	</tr>
	
</table>


</div>

</form>

</body>
</html>