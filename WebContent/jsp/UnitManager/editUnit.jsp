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
	
	$("input[id='idiot']").typeahead({
		remote:"#leader",
		source : [],
		items : 10,
		updateSource:function(inputVal, callback){			
			
			
			$.ajax({
				url:"/eis/autoCompleteEmpl",
			    dataType: 'jsonp',
			    jsonp:'back',          //jsonp请求方法
			    data:{nameno:inputVal},
			    cache:false,
			    type:'POST',
			    success: function(d) {
			    	
			    	callback(d.list);
			    }
			});
			
		}		
	});	
	
	$("#ass").typeahead({
		remote:"#assistant",
		source : [],
		items : 10,
		updateSource:function(inputVal, callback){			
			$.ajax({
				url:"/eis/autoCompleteEmpl",
			    dataType: 'jsonp',
			    jsonp:'back',          //jsonp请求方法
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

<form action="UnitManager" class="form-inline" method="post">		
<table class="table">
	<tr>
		<td>名稱</td>
		<td>
		<select class="selectpicker" onMouseup="checkUnit();" name="campus">
			<option value="">--</option>			
			<c:forEach items="${allUnit}" var="c">
			<option <c:if test="${c.id eq unit.campus}">selected</c:if> value="${c.id}">${c.name}</option>
			</c:forEach>
		</select>
		
		<select class="selectpicker" id="parent_unit" name="pid" onMouseup="checkUnit();" name="parent_unit">
			<option value="">--</option>
			<c:forEach items="${allUnit}" var="c">
				<c:forEach items="${c.unit}" var="u">
				<option <c:if test="${u.id eq unit.pid}">selected</c:if> value="${u.id}" class="${c.id}">${u.name}</option>
				</c:forEach>
			</c:forEach>
		</select>
				
		<input type="text" class="form-control" name="name" value="${unit.name}"/>
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
		<td>英文名稱</td>
		<td><input class="form-control" type="text" name="ename" value="${unit.ename}"/></td>
	</tr>
	
	<tr>
		<td>地點</td>
		<td><input class="form-control" type="text" name="location" value="${unit.location}"/></td>
	</tr>
	
	<tr>
		<td>電話</td>
		<td><input class="form-control" type="text" name="phone" value="${unit.phone}"/></td>
	</tr>
	
	<tr>
		<td>傳真</td>
		<td><input class="form-control" type="text" name="fax" value="${unit.fax}"/></td>
	</tr>
	
	<tr>
		<td>電子郵件</td>
		<td><input class="form-control" type="text" name="email" value="${unit.email}"/></td>
	</tr>
	
	<tr>
		<td>網站</td>
		<td><input class="form-control" type="text" name="website" value="${unit.website}"/></td>
	</tr>
	
	<tr>
		<td>單位主管</td>
		<td>
		<input class="form-control" onClick="$('#idiot').val(''), $('#leader').val('');" autocomplete="off" 
		type="text" id="idiot" value="${nameno}" name="nameno" data-provide="typeahead" placeholder="姓名或身分證" />
		<input type="hidden" id="leader" value="${unit.leader}" name="leader"/>
		</td>
	</tr>
	
	<tr>
		<td>單位助理</td>
		<td>
		<input class="form-control" onClick="$('#ass').val(''), $('#assistant').val('');" autocomplete="off" 
		type="text" id="ass" value="${ass}" name="ass" data-provide="typeahead" placeholder="姓名或身分證" />
		<input type="hidden" id="assistant" value="${unit.assistant}" name="assistant"/>
		</td>
	</tr>
	
	<tr>
		<td></td>
		<td>
		<button class="btn btn-danger" name="method:saveUnit" type="submit">儲存</button>
		<a href="UnitManager" class="btn btn-default">離開</a>
		</td>
	</tr>
	
</table>



</form>

</body>
</html>