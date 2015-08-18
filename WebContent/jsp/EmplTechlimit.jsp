<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>設定教師各項時數</title>
<script src="/eis/inc/js/plugin/bootstrap-typeahead.js"></script>
<script src="/eis/inc/js/plugin/stupidtable.min.js"></script>
<script src="/eis/inc/js/autoComplete.js"></script>
</head>
<body>
<form action="EmplTechlimit" method="post" class="form-inline">
<div class="alert" style="position: fixed; width:95%; z-index:20;">
教師各項時數輸入完成請先點選 
<button type="submit" class="btn btn-small btn-danger" name="method:save">儲存</button>
</div>
<br><br><br>
	<table class="table">
		<tr>
			<td>
			<div class="input-prepend">
				<span class="add-on">教師姓名</span>
				<input type="text" placeholder="教師完整姓名" class="span3 techid" name="techid" id="techid" value="${techid}" onClick="this.value='';" autocomplete="off" data-provide="typeahead"/>
			</div>
			<div class="input-prepend">
			<span class="add-on">教師職級</span>
			<select name="pcode" id="pcode">					
				<option value="">所有教師</option>
				<c:forEach items="${codes}" var="c">
				<option <c:if test="${c.id eq pcode}">selected</c:if> value="${c.id}">${c.name}</option>
				</c:forEach>
			</select>
			</div>
			
			<div class="btn-group">
			<button name="method:search" class="btn btn-danger" type="submit">尋找教師</button>
			<a href="EmplTechlimit" class="btn">重新查詢</a>
			</div>
			
			
			</td>
		</tr>
	</table>
	
	<c:if test="${!empty empls}">
	<table class="table" id="row">		
		<thead>
		<tr>
			<td colspan="3" align="right"></td>
			<td nowrap>填滿</td>
			<td nowrap>
				<div class="input-append">
				<input type="text" name="set" id="set" style="me-mode:disabled;" class="span1" />
				<button class="btn" onClick="$('.set').val($('#set').val())" type="button"><i class=" icon-arrow-down"></i></button>
				</div>
			</td>
			<td nowrap>
				<div class="input-append">
				<input type="text" name="over_set" id="over_set" style="me-mode:disabled;" class="span1"/>
				<button class="btn" onClick="$('.over_set').val($('#over_set').val())" type="button"><i class=" icon-arrow-down"></i></button>
				</div>
			</td>
			<td nowrap>
				<div class="input-append">
				<input type="text" name="stay" id="stay" style="me-mode:disabled;" class="span1"/>
				<button class="btn" onClick="$('.stay').val($('#stay').val())" type="button"><i class=" icon-arrow-down"></i></button>
				</div>
			</td>
			<td width="35%"></td>
		</tr>
		<tr>
			<th data-sort="string" style="cursor:n-resize;" nowrap>主聘科系 <i class="icon-chevron-down"></i></th>
			<th data-sort="string" style="cursor:n-resize;" nowrap>教師職級 <i class="icon-chevron-down"></i></th>
			<th data-sort="string" style="cursor:n-resize;" nowrap>本校職稱 <i class="icon-chevron-down"></i></td>
			<th data-sort="string" style="cursor:n-resize;" nowrap>教師姓名 <i class="icon-chevron-down"></i></th>
			<th data-sort="string" style="cursor:n-resize;" nowrap>基本鐘點</th>
			<th data-sort="string" style="cursor:n-resize;" nowrap>可超鐘點 </th>
			<th data-sort="string" style="cursor:n-resize;" nowrap>扣除留校時數</th>
			<th>實際授課/留校</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${empls}" var="e">
		<tr>
			<td nowrap>${e.unitname}</td>
			<td nowrap>${e.name}</td>
			<td>${e.sname}</td>
			<td nowrap>${e.cname}</td>
			<td nowrap>
			<input type="hidden" name="idno" value="${e.idno}" />
			<input type="hidden" name="Oid" value="${e.Oid}" />
			<input type="text" name="time" class="span1 set" value="${e.time}" style="me-mode:disabled; font-size:20px;" size="4" />
			</td>
			<td><input type="text" name="time_over" id="time_over" class="span1 over_set" value="${e.time_over}" style="me-mode:disabled;" /></td>
			<td><input type="text" name="time_stay" id="time_stay" class="span1 stay" value="${e.time_stay}"onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" 
                                    onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}" style="me-mode:disabled;" />
			
			</td>
			<td nowrap>
			${e.thour}/${e.stay}
			
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="btn-group">
	<button name="method:save" class="btn btn-large btn-danger">儲存</button>
	<a href="EmplTechlimit" class="btn btn-large">取消</a>
	</div>
	<script>
	$("#row").stupidtable();
	</script>
	</c:if>
</form>
</body>

</html>