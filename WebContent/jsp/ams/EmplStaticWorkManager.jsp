<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>假單管理</title>
<script src="/eis/inc/js/plugin/bootstrap-typeahead.js"></script>
<script src="inc/js/autoComplete.js"></script>
</head>
<body>
<div class="bs-callout bs-callout-info" id="callout-helper-pull-navbar">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>人員固定排班管理</strong>    
</div>

<form action="EmplStaticWorkManager" class="form-inline" method="post">
	
<div class="panel panel-primary">
	<div class="panel-heading">新增或查詢</div>
  		
	<table class="table">
  			
  			<tr>
  				<td>
				
				<select class="selectpicker dropup" data-header="下列班別起迄時間均以第一個上班日為參考" name="shift">
					<option <c:if test="${shift eq 'all'}">selected</c:if> value="all">所有班別</option>
					<c:forEach items="${shifts}" var="s">					
					<option <c:if test="${!empty s.in1}">data-subtext="${s.in1}~${s.out1}"</c:if> <c:if test="${s.id eq shift}">selected</c:if> value="${s.id}">${s.name}</option>						
					</c:forEach>
				</select>
				
  				<select class="selectpicker dropup" data-header="請選擇教職員主聘系所/單位" name="unit">
					<option value="">所有單位</option>
					<c:forEach items="${units}" var="u">
					<option data-subtext="${u.name}" <c:if test="${u.id eq unit}">selected</c:if> value="${u.id}">${u.sname}</option>						
					</c:forEach>
				</select>	
				
				<select class="selectpicker dropup" data-header="請選擇教職員行政單位" name="unitModule">
					<option value="">所有單位</option>
					<c:forEach items="${units}" var="u">
					<option data-subtext="${u.name}" <c:if test="${u.id eq unitModule}">selected</c:if> value="${u.id}">${u.sname}</option>						
					</c:forEach>
				</select>			
  				</td>  			
  			</tr>
  			<tr>
  				<td>
  				<div class="input-group">
		  			<span class="input-group-addon">姓名</span>
					<input type="text" class="form-control techid" name="idno" id="idno" value="${idno}" onClick="this.value='';" autocomplete="off" data-provide="typeahead"/>
					<span class="input-group-btn"><button class="btn btn-primary" name="method:search">查詢</button></span>
				</div>
				
  				</td>  			
  			</tr> 	
  			
  			
  			
  		
  		</table>	
</div>


<c:if test="${!empty empls}">
<div class="panel panel-primary">
	<div class="panel-heading">新增或查詢</div>
  		
	<table class="table">
  			
 		<tr>
 			<td>姓名</td>
 			<td>職稱</td>
 			<td>主聘系所/單位</td>
 			<td>行政單位</td>
 			
 			<td width="50%">
 			<select class="selectpicker dropup" title="班別" data-header="下列班別起迄時間均以第一個上班日為參考" id="stemp">
					<option <c:if test="${shift eq 'all'}">selected</c:if> value="all">所有班別</option>
					<c:forEach items="${shifts}" var="s">					
					<option <c:if test="${!empty s.in1}">data-subtext="${s.in1}~${s.out1}"</c:if> <c:if test="${s.id eq shift}">selected</c:if> value="${s.id}">${s.name}</option>						
					</c:forEach>
				</select>
 			<button type="button" onClick="ch()" class="btn btn-success btn-sm">向下填滿</button>
 			</td>
		</tr>
		<c:forEach items="${empls}" var="e">
		<tr>
 			<td nowrap>${e.cname}</td>
 			<td nowrap>${e.sname}</td>
 			<td nowrap>${e.unitName}</td>
 			<td nowrap>${e.unitModule}</td>
 			
 			<td nowrap>
 			<input type="hidden" name="Oid" id="Oid${e.Oid}" value="" />
 			
 			<select class="selectpicker dropup shifter" title="班別" name="wshift" onChange="$('#Oid${e.Oid}').val(${e.Oid})">
				<c:forEach items="${shifts}" var="s">					
				<option <c:if test="${!empty s.in1}">data-subtext="${s.in1}~${s.out1}"</c:if> 
				<c:if test="${e.WorkShift eq s.id}">selected</c:if> 
				value="${s.id}">${s.name}</option>						
				</c:forEach>
			</select>
 			</td>
		</tr>
		</c:forEach>
	</table>
	<div class="panel-body">
    <button class="btn btn-danger" name="method:save">儲存</button>
  </div>
</div>



</c:if>




</form>
<script>
$(".techid").typeahead({
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

function ch(){
	$('.shifter').selectpicker('val', $('#stemp').val())
	//alert($('#stemp').val());
}
</script>
</body>



</html>