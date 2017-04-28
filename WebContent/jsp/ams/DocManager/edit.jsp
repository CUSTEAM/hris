<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="panel panel-primary">
	<div class="panel-heading">${doc.sn}</div>
  	<div class="panel-body">	
	</div>
	<table class="table">
  		<tr>
  			<td>
  			<div class="input-group">
		  		<span class="input-group-addon">條碼</span>
				<input type="text" class="form-control" style="width:500px;" name="sn" id="sn" value="${doc.sn}" readonly/>
			</div>
  			</td>  			
  		</tr>
  		<tr>
  			<td>
  			<div class="input-group">
		  			<span class="input-group-addon">處理狀況</span>
					<select class="form-control" name="status">
						<option value="">未處理</option>						
						<option <c:if test="${doc.status eq'1'}">selected</c:if> value="1" >核准</option>
						<option <c:if test="${doc.status eq'0'}">selected</c:if> value="0" >不核准</option>
					</select>
			</div>
  			<div class="input-group">
		  			<span class="input-group-addon">假別</span>
					<select class="form-control" name="askLeaveType">	
						<option value=""></option>					
						<c:forEach items="${CODE_AMS_TYPE}" var="c">
						<option <c:if test="${c.id eq doc.askLeaveType}">selected</c:if> value="${c.id}">${c.name}</option>
						</c:forEach>
					</select>
			</div>				
  			</td>  			
  		</tr>
  		<tr>
  			<td>
  			<div class="input-group">
		  			<span class="input-group-addon">申請人</span>
					<input type="text" class="form-control" value="${doc.emplOid}, ${doc.cname}" readonly/>
				</div>
				<div class="input-group">
				    <span class="input-group-addon">請假日期</span>
			    	<input class="dtpick form-control" type="text" placeholder="點一下輸入日期" name="startDate" id="startDate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${doc.startDate}" />"/>
				</div>
				<div class="input-group">
				    <span class="input-group-addon">至</span>
				    <input class="dtpick form-control" type="text" placeholder="點一下輸入日期" name="endDate" id="endDate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${doc.endDate}" />"/>
				</div>
  			</td>  			
  		</tr> 	
  		<tr>
  			<td>
  				<div class="input-group">
		  			<span class="input-group-addon">日數</span>
					<input type="text" class="form-control" style="width:60px;" name="totalDay" value="${doc.totalDay}" autocomplete="off"/>				
				</div>
				<div class="input-group">
		  			<span class="input-group-addon">時數</span>
					<input type="text" class="form-control" style="width:60px;" name="totalHour" value="${doc.totalHour}" autocomplete="off"/>				
				</div>
				<div class="input-group">
		  			<span class="input-group-addon">分鐘數</span>
					<input type="text" class="form-control" style="width:60px;" name="totalMinute" value="${doc.totalMinute}" autocomplete="off"/>				
				</div>
				<div class="input-group">
		  			<span class="input-group-addon">鐘點數</span>
					<input type="text" class="form-control" style="width:60px;" name="teachPeriod" value="${doc.teachPeriod}" autocomplete="off"/>				
				</div>
				<div class="input-group">
		  			<span class="input-group-addon">代理人</span>
					<input type="text" class="form-control techid" name="agent" id="agent" 
					<c:if test="${!empty doc.agent}">
					value="${doc.agent}, ${doc.agentName}" 
					</c:if>
					onClick="this.value='';" autocomplete="off" data-provide="typeahead"/>
				</div>
  			</td>  			
  		</tr>
  		<tr>
  			<td>
  				<table width="100%" >
  					<tr>
  						<td>原因</td>
  						<td>備註事項</td>
  					</tr>
  					<tr>
  						<td style="padding:5px;"><textarea name="reason" rows="1">${doc.reason}</textarea></td>
  						<td><textarea name="memo">${doc.memo}</textarea></td>
  					</tr>
  				</table>  				
  			</td>
  		</tr>
  	</table>
	<div class="panel-body">		
		<div class="btn-group" role="group" aria-label="...">
			<button class="btn btn-primary" name="method:save">儲存</button>
			<button class="btn btn-default" type="button" onClick=" window.close();">關閉</button>
			
		</div>
	</div>	
</div>