<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/eis/inc/css/jquery-ui.css" rel="stylesheet"/>
<link href="/eis/inc/js/plugin/jquery-ui-timepicker-addon/jquery-ui-timepicker-addon.min.css" rel="stylesheet"/>
<script src="/eis/inc/js/plugin/bootstrap-typeahead.js"></script>
<script src="/eis/inc/js/plugin/jquery.inputevent.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui-timepicker-addon/jquery-ui-timepicker-addon.min.js"></script>
<title>收件管理</title>
<script>  

$(document).ready(function() {
	$("#add_unit").change(function(){
		$("#add_username").val("");
	})
	$("#add_username").click(function(){
		$("#add_unit").val("");
	})	
	
	
	
	$(".username").typeahead({
		//remote:"#student_no",
		source : [],
		items : 10,
		updateSource:function(inputVal, callback){
			if(inputVal.length>1)
			$.ajax({
				type:"POST",
				url:"/eis/autoCompleteSchoolUser",
				dataType:"json",
				data:{nameno:inputVal},
				success:function(d){
					callback(d.list);
				}
			});
		}		
	});		
	
});



</script>
</head>
<body>
<div class="bs-callout bs-callout-info" id="callout-helper-pull-navbar">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>收件管理</strong>    
</div>
<form action="ReceiverManager" class="form"method="post">
<div class="row">
  <div class="col-xs-4">  
  	<div class="panel panel-primary">
	  	<div class="panel-heading">新郵件</div>	  
		<table class="table">
			<tr>
				<td id="addMail">
				<div class="input-group">
					<span class="input-group-addon">收件日期</span>
					<input class="form-control timepick" type="text" name="add_recDate" placeholder="預設為現在時間"/>
				</div>
				</td>
			</tr>
		
		
		
			<tr>
				<td id="addMail">
				<div class="input-group">
					<span class="input-group-addon">種類編號</span>
					<input name="add_no" onKeyUp="add();" type="text" class="form-control" autocomplete="off" >
				</div>
				</td>
			</tr>
			<tr>
				<td nowrap>
				<div class="input-group" style="float:left;width:50%;">
					<span class="input-group-addon">收件人★</span>
					<input class="form-control username" autocomplete="off"  id="add_username"
					type="text" value="${add_username}" name="add_username" data-provide="typeahead" placeholder="姓名或身分證" autocomplete="off"/>
				</div>
				<div class="input-group" style="padding-left:5px;width:50%;">
					<span class="input-group-addon">或</span>					
					<select class="form-control" name="add_unit" id="add_unit">
					<option value="">單位</option>
					<c:forEach items="${CODE_UNIT}" var="m">
					  	<option <c:if test="${m.id eq  add_unit}">selected</c:if> value="${m.id}">${m.name}</option>
					</c:forEach>
					</select>
				</div>
				</td>
			</tr>
			
			<tr>
				<td>
				<div class="input-group">
					<span class="input-group-addon">寄件人☆</span>
					<input name="add_from" value="${add_from}" type="text" class="form-control" autocomplete="off" />
				</div>
				
				</td>
			</tr>
			<tr>
				<td>
				<div class="input-group">
					<span class="input-group-addon">存放位置</span>
					<select class="form-control" name="add_stor">
					<c:forEach items="${CODE_MAIL_STOR}" var="m">
					  	<option <c:if test="${m.id eq  add_stor}">selected</c:if> value="${m.id}">${m.name}</option>
					</c:forEach>
					</select>
				</div>
				
				</td>
			</tr>
			<tr>
				<td nowrap>
				<div class="input-group">
					<span class="input-group-addon">備註事項</span>
					<input class="form-control" autocomplete="off" 
					type="text" value="${add_note}" name="add_note" data-provide="typeahead" autocomplete="off"/>
				</div>
				</td>
			</tr>
			<tr>
				<td>
				<button style="width:100%" class="btn btn-danger" name="method:add">新增</button>
				</td>
			</tr>
		</table>
	</div>
  
  </div>
  
  <div class="col-xs-4">
  <div class="panel panel-primary">
		<div class="panel-heading">郵件查詢</div>		  
		<table class="table">
			<tr>
				<td id="addMail" nowrap>
				<div class="input-group" style="width:50%; float:left;">
					<span class="input-group-addon">查詢範圍</span>
					<input class="form-control timepick" type="text" name="que_begin" placeholder="預設為現在時間"/>
				</div>
				<div class="input-group" style="width:50%; padding-left:5px;">
					<span class="input-group-addon">至</span>
					<input class="form-control timepick" type="text" name="que_end" placeholder="預設為現在時間"/>
				</div>
				</td>
			</tr>
			<tr>
				<td id="addMail">
				<div class="input-group">
					<span class="input-group-addon">種類編號</span>
					<input value="${que_no}" name="que_no" onKeyUp="add();" type="text" class="form-control" autocomplete="off" >
				</div>
				</td>
			</tr>
			<tr>
				<td nowrap>
				<div class="input-group" style="float:left;width:50%;">
					<span class="input-group-addon">收件人★</span>
					<input class="form-control username" autocomplete="off" 
					type="text" value="${que_username}" name="que_username" data-provide="typeahead" placeholder="姓名或身分證" autocomplete="off"/>
				</div>
				<div class="input-group" style="padding-left:5px;width:50%;">
					<span class="input-group-addon">或</span>
					<select class="form-control" name="que_unit">
					<option value="">單位</option>
					<c:forEach items="${CODE_UNIT}" var="m">
					  	<option <c:if test="${m.id eq  que_unit}">selected</c:if> value="${m.id}">${m.name}</option>
					</c:forEach>
					</select>
				</div>
				</td>
			</tr>
			
			<tr>
				<td>
				<div class="input-group">
					<span class="input-group-addon">寄件人☆</span>
					<input name="que_from" value="${que_from}" type="text" class="form-control" autocomplete="off" />
				</div>
				</td>
			</tr>
			<tr>
				<td>
				<div class="input-group">
					<span class="input-group-addon">存放位置</span>
					<select class="form-control" name="que_stor">
						<option <c:if test="${m.id eq ''}">selected</c:if> value="">全部</option>
					<c:forEach items="${CODE_MAIL_STOR}" var="m">
					  	<option <c:if test="${m.id eq  que_stor}">selected</c:if> value="${m.id}">${m.name}</option>
					</c:forEach>
					</select>
				</div>
				</td>
			</tr>
			<tr>
				<td nowrap>
				<div class="input-group">
					<span class="input-group-addon">備註事項</span>
					<input class="form-control" autocomplete="off" 
					type="text" value="${que_note}" name="que_note" data-provide="typeahead" autocomplete="off"/>
				</div>
				</td>
			</tr>
			<tr>
				<td nowrap>
				<button style="width:50%" class="btn btn-danger" name="method:search">收件查詢</button>
				<button style="width:50%" class="btn btn-default" name="method:searchb">退件查詢</button>
				</td>
			</tr>
		</table>
		</div>
  
  </div>
  
  
  <div class="col-xs-4">
  
  	<div class="panel panel-primary">
	  	<div class="panel-heading">待領郵件</div>	  
		<table class="table">
			<tr>
				<td></td>
				<td>編號</td>
				<td>收件人</td>
				<td>簽收人</td>
				<td>位置</td>				
			</tr>
			<c:forEach items="${ques}" var="q">
			<tr>
				<td><input type="checkbox" /></td>
				<td nowrap>${q.no}</td>
				<td nowrap>${q.recName}</td>
				<td nowrap>${q.sigName}</td>
				<td nowrap>${q.storName}</td>				
			</tr>
			</c:forEach>
		</table>
	</div>
  
  
  </div>
  
</div>


<table class="table">
	<tr>
		<c:if test="${!empty mails}">
		<td>
		<div class="panel panel-primary">
		  	<div class="panel-heading">郵件列表</div>  
			<table class="table">
				
				<tr>
					<td></td>
					<td>日期</td>
					<td>編號</td>
					<td>位置</td>
					<td>寄件人</td>
					<td>收件人</td>
					<td>單位</td>
					<td>簽收人</td>
					<td>簽收日</td>
					<td>退回日</td>
				</tr>
				<c:forEach items="${mails}" var="m">
				<tr>
					<td><input type="checkbox" name="Oid" value="${m.Oid}" /></td>
					<td><small><fmt:formatDate pattern="MM-dd" value="${m.recDate}" /></small></td>
					<td>${m.no}</td>
					<td>${m.storName}</td>
					<td>${m.fromr}</td>
					<td>${m.cname}</td>
					<td>${m.deptName},${m.unitName}</td>
					<td>${m.signer}</td>
					<td><small>${m.signdate}</small></td>
					<td><small>${m.rejectd}</small></td>
				</tr>
				
				</c:forEach>
			</table>
			<div class="panel-body" style="white-space: nowrap;">
			<button style="width:50%" class="btn btn-success" name="method:sign">選取簽收</button>
			<button style="width:50%" class="btn btn-default" name="method:search">選取刪除</button>
			</div>
		</div>
		</td>
		</c:if>
		<c:if test="${!empty unitMails}">
		<td>	
		<div class="panel panel-primary">
		  	<div class="panel-heading">郵件列表</div>  
			<table class="table">
				
				<tr>
					<td>日期</td>
					<td>編號</td>
					<td>位置</td>
					<td>寄件人</td>
					<td>收件人</td>
					<td>單位</td>
					<td>簽收人</td>
					<td>簽收日</td>
					<td>退回日</td>
				</tr>
				<c:forEach items="${unitMails}" var="m">
				<tr>
					<td><small><fmt:formatDate pattern="MM/dd" value="${m.recDate}" /></small></td>
					<td>${m.no}</td>
					<td>${m.storName}</td>
					<td>${m.fromr}</td>
					<td>${m.cname}</td>
					<td>${m.deptName},${m.unitName}</td>
					<td>${m.signer}</td>
					<td><small>${m.signdate}</small></td>
					<td><small>${m.rejectd}</small></td>
				</tr>
				
				</c:forEach>
			</table>
		</div>
	
	
		</td>
		</c:if>
	</tr>
</table>










</form>
<script>
function add(){
	
}


$( "#addMail" ).keypress(function( event ) {
	if ( event.which == 13 ) {
		event.preventDefault();
		var d = new Date();
		$("#addMail").append("<div class='input-group' style='padding:5px 0px 5px 0px;'><span class='input-group-addon'>種類編號</span><input name='add_no' id='"+d.getTime()+"' type='text' class='form-control'></div>");
		
		document.getElementById(d.getTime()).focus();
	}
	  
});

$('.timepick').datetimepicker({
	/*controlType: 'select',
	//addSliderAccess: true,
	sliderAccessArgs: { touchonly: false },
	stepHour: 1,
	stepMinute: 30,
	hourMin: 7,
	hourMax: 23*/
});
</script>
</body>
</html>