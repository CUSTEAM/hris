<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Insert title here</title>
<script src="/eis/inc/js/plugin/bootstrap-typeahead.js"></script>
<script src="/eis/inc/js/plugin/json2.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui.js"></script>
<script src="/eis/inc/js/plugin/bootstrap-tooltip.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script>  
$(document).ready(function() {
	
	$("#idiot").typeahead({
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
	
	$("#mil").typeahead({
		remote:"#military",
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
	
});



</script>


</head>
<body>







<div class="alert">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>校區資料管理?</strong>
</div>

<form action="UnitManager" class="form" method="post">




		
<table class="table">
	<tr>
		<td nowrap>名稱</td>
		<td width="100%">
		<input type="hidden" name="id" readonly class="span1" value="${unit.id}"/>
		<input class="form-control" type="text" name="name" value="${unit.name}"/>
		</td>
	</tr>
	
	<tr>
		<td>英文名稱</td>
		<td>
		<input type="text" class="form-control" name="ename" value="${unit.ename}"/>
		</td>
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
		<td>系主任</td>
		<td>
		<input class="form-control" onClick="$('#idiot').val(''), $('#leader').val('');" autocomplete="off" 
		type="text" id="idiot" value="${nameno}" name="nameno" data-provide="typeahead" placeholder="姓名或身分證" />
		<input type="hidden" id="leader" value="${unit.director}" name="leader"/>
		</td>
	</tr>
	
	<tr>
		<td>系助理</td>
		<td>
		<input class="form-control" onClick="$('#ass').val(''), $('#assistant').val('');" autocomplete="off" 
		type="text" id="ass" value="${ass}" name="ass" data-provide="typeahead" placeholder="姓名或身分證" />
		<input type="hidden" id="assistant" value="${unit.assistant}" name="assistant"/>
		</td>
	</tr>
	
	<tr>
		<td>系教官</td>
		<td>
		<input class="form-control" onClick="$('#mil').val(''), $('#military').val('');" autocomplete="off" 
		type="text" id="mil" value="${mil}" name="mil" data-provide="typeahead" placeholder="姓名或身分證" />
		<input type="hidden" id="military" value="${unit.military}" name="military"/>
		</td>
	</tr>
	
	
	
	
	
	
	<tr>
		<td></td>
		<td>
		<button class="btn btn-danger" name="method:saveDept" type="submit">儲存</button>
		<a href="UnitManager" class="btn">離開</a>
		</td>
	</tr>
	
</table>



</form>

</body>
</html>