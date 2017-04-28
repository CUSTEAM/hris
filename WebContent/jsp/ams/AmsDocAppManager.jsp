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
<link href="/eis/inc/css/jquery-ui.css" rel="stylesheet"/>
</head>
<body>
<div class="bs-callout bs-callout-info" id="callout-helper-pull-navbar">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>假單管理</strong>    
</div>

<form action="AmsDocAppManager" class="form-inline" method="post">
<c:if test="${empty doc}">
<%@ include file="DocManager/search.jsp"%>
</c:if>		


<c:if test="${!empty doc}">
<script>
$("#mainmenu").hide( "slow" );
</script>
<%@ include file="DocManager/edit.jsp"%>
</c:if>

<c:if test="${!empty docs}">
<div class = "panel panel-primary">
   <div class = "panel-heading"><h3 class = "panel-title">查詢結果</h3></div>
	<display:table pagesize="10" export="false" name="${docs}" id="row" class="table table-condensed" sort="list"  requestURI="AmsDocAppManager?method=search">
	  	<display:column style="white-space: nowrap">
	  		<button type="button" onClick="try{winid1.close()}catch(e){};winid1=window.open('AmsDocAppManager?method=snSearch&method:snSearch=&sn='+this.id,'_blank', 'directories=no,titlebar=no,toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=800, height=800,top=0,left=0');" id="${row.sn}" class="btn btn-default btn-sm edit">修改</button>
			<button name="method:del" id="${row.sn}" class="btn btn-danger btn-sm del">刪除</button>
		</display:column>
	  	<display:column style="white-space:nowrap" title="編號" property="sn" sortable="true" />
	  	<display:column style="width:5%; white-space:nowrap" title="假別" property="typeName" sortable="true"/>
	  	<display:column style="white-space:nowrap" title="姓名" property="cname" sortable="true"/>
	  	<display:column style="white-space:nowrap" title="開始日期" sortable="true">
	  	<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${row.startDate}" />
	  	</display:column>
	  	<display:column style="white-space:nowrap" title="結束日期" sortable="true">
	  	<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${row.endDate}" />
	  	</display:column>
	  	<display:column style="white-space: nowrap" title="日" property="totalDay" sortable="true"/>
	  	<display:column style="white-space: nowrap" title="時" property="totalHour" sortable="true"/>
	  	<display:column style="white-space: nowrap" title="分" property="totalMinute" sortable="true"/>
	  	<display:column style="width:100%; white-space:nowrap;" title="狀態" property="statusName" sortable="true"/>	
	  </display:table>
</div>
</c:if>
</form>
<script src="/eis/inc/js/plugin/bootstrap-tooltip.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui.js"></script>
<script src="/eis/inc/js/plugin/jquery-ui-timepicker-addon.js"></script>
<script src="http://192.192.230.167/CIS/inc/js/plugin/ckeditor/ckeditor.js"></script>
<script>
//$(document).ready(function(){
	
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
	
	
//})
	
	

$(".dtpick").datetimepicker({
	changeMonth: true,
	changeYear: true,
	//minDate: '@minDate'
	yearRange: "-100:+0",
	//showButtonPanel: false,
	//dateFormat: 'yyyy-MM-dd HH:mm',
	onSelect: function(selectedDate) {
    // custom callback logic here
    <c:if test="${empty doc}">$("#endDate").val(this.value);</c:if>
  }
});

$( ".del" ).click(function() {
	  $("#sn").val(this.id);
	  return(confirm("請確認刪除"+this.id));
});




CKEDITOR.replaceAll( function( textarea, config ){	//uiColor: '#14B8C4',
	config.toolbar= [
		[ 'Bold', 'Italic', '-', 'NumberedList', 'BulletedList'],
		//[ 'Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink' ],
		//[ 'FontSize', 'TextColor', 'BGColor']
	];
	//config.width = '100%';
	config.height = '150';
}
);	
//$("input[name='beginDate'], input[name='endDate']" ).datepicker();





</script>
</body>



</html>