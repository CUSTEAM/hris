<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="panel panel-primary">
	<div class="panel-heading">新增或查詢</div>
  	<script>


  	$(document).ready(function(){
  	    $('#sn').keypress(function(e){
  	      if(e.keyCode==13){
  	    	$('#sns').click();
  	    	return false;
  	      }
  	      
  	      
  	    });
  	});


  	</script>
	<table class="table">
  			<tr>
  				<td>
  				<div class="input-group">
		  			<span class="input-group-addon">條碼</span>
					<input type="text" class="form-control" style="width:500px;" name="sn" id="sn" value="${sn}" autocomplete="off"/>				
					<span class="input-group-btn">
				    	<button type="button" tabindex="0" id="sns" class="btn btn-default" onClick="try{winid1.close()}catch(e){};winid1=window.open('AmsDocAppManager?method=snSearch&method:snSearch=&sn='+$('#sn').val(),'_blank', 'directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=800, height=800,top=0,left=0');">快速查詢</button>
				    </span>
				</div>
  				</td>  			
  			</tr>
  			<tr>
  				<td>
  				
				<select class="selectpicker" data-width="fit" name="docType">
					<option <c:if test="${docType eq'1'}">selected</c:if> value="1" >請假單</option>
					<option <c:if test="${docType eq'2'}">selected</c:if> value="2" >加班單</option>
				</select>
				
  				<div class="input-group">
		  			<span class="input-group-addon">處理狀況</span>
					<select class="form-control" name="status">
						<option value=""></option>	
						<option <c:if test="${status eq'n'}">selected</c:if> value="n">未處理</option>						
						<option <c:if test="${status eq'1'}">selected</c:if> value="1" >核准</option>
						<option <c:if test="${status eq'0'}">selected</c:if> value="0" >不核准</option>
					</select>
				</div>
  				<div class="input-group">
		  			<span class="input-group-addon">假別</span>
					<select class="form-control" name="askLeaveType">
						<option value=""></option>
						<c:forEach items="${CODE_AMS_TYPE}" var="c">
						<option <c:if test="${c.id eq askLeaveType}">selected</c:if> value="${c.id}" >${c.name}</option>
						</c:forEach>
					</select>
				</div>				
  				</td>  			
  			</tr>
  			<tr>
  				<td>
  				<div class="input-group">
		  			<span class="input-group-addon">申請人</span>
					<input type="text" class="form-control techid" name="idno" id="idno" value="${idno}" onClick="this.value='';" autocomplete="off" data-provide="typeahead"/>
				</div>
				<div class="input-group">
				    <span class="input-group-addon">請假日期</span>
			    	<input class="dtpick form-control" type="text" placeholder="點一下輸入日期" name="startDate" id="startDate" value="${startDate}"/>
				</div>
				<div class="input-group">
				    <span class="input-group-addon">至</span>
				    <input class="dtpick form-control" type="text" placeholder="點一下輸入日期" name="endDate" id="endDate" value="${endDate}"/>
				</div>
  				</td>  			
  			</tr> 	
  			<tr>
  				<td>
  				<div class="input-group">
		  			<span class="input-group-addon">日數</span>
					<input type="text" class="form-control" style="width:60px;" name="totalDay" value="${totalDay}" autocomplete="off"/>				
				</div>
				<div class="input-group">
		  			<span class="input-group-addon">時數</span>
					<input type="text" class="form-control" style="width:60px;" name="totalHour" value="${totalHour}" autocomplete="off"/>				
				</div>
				<div class="input-group">
		  			<span class="input-group-addon">分鐘數</span>
					<input type="text" class="form-control" style="width:60px;" name="totalMinute" value="${totalMinute}" autocomplete="off"/>				
				</div>
				<div class="input-group">
		  			<span class="input-group-addon">鐘點數</span>
					<input type="text" class="form-control" style="width:60px;" name="teachPeriod" value="${teachPeriod}" autocomplete="off"/>				
				</div>
				<div class="input-group">
		  			<span class="input-group-addon">代理人</span>
					<input type="text" class="form-control techid" name="agent" id="agent" value="${agent}" onClick="this.value='';" autocomplete="off" data-provide="typeahead"/>
				</div>
  				</td>  			
  			</tr>
  			
  			
  		
  		</table>
		<div class="panel-body">		
		<div class="btn-group" role="group" aria-label="...">
			<button class="btn btn-default" name="method:search">查詢</button>
			<a href="AmsDocAppManager" class="btn btn-default">重新查詢</a>
			
		</div>
		<button class="btn btn-default" name="method:add">新增</button>
		</div>	
</div>