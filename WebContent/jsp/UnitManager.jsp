<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>單位管理</title>
<script src="/eis/inc/js/plugin/bootstrap-typeahead.js"></script>
<link href="/eis/inc/css/bootstrap-tree.css" rel="stylesheet"/>
<script src="/eis/inc/js/plugin/jquery.chained.min.js"></script>
<script>  
$(document).ready(function() {
	$("input[id='nameno']").typeahead({
		remote:"#student_no",
		source : [],
		items : 10,
		updateSource:function(inputVal, callback){			
			$.ajax({
				type:"POST",
				url:"/eis/autoCompleteStmd",
				dataType:"json",
				data:{length:10, nameno:inputVal},
				success:function(d){
					callback(d.list);
				}
			});
		}		
	});	
});
$(function () {
    $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', '關閉');
    $('.tree li.parent_li > span').on('click', function (e) {
        var children = $(this).parent('li.parent_li').find(' > ul > li');
        if (children.is(":visible")) {
            children.hide('fast');
            $(this).attr('title', '展開').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
        } else {
            children.show('fast');
            $(this).attr('title', 'Collapse this branch').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
        }
        e.stopPropagation();
    });
});
</script>
</head>
<body>
<div class="bs-callout bs-callout-info" id="callout-helper-pull-navbar">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>單位資料管理</strong>    
</div>

<form action="UnitManager" class="form-inline"method="post">

<div class="panel panel-primary">
	<div class="panel-heading">行政單位</div>
  	<div class="panel-body tree">
	    <ul>
	        <c:forEach items="${aunit}" var="c">
	        <li><span><i class="icon-folder-open"></i> ${c.id}, ${c.name} <span class="label label-danger">${c.leader}</span> <span class="label label-default">${c.assistant}</span></span> 
	        <a class="btn btn-default btn-xs" href="UnitManager?cid=${c.id}">管理</a>
	            <ul>                
	                <c:forEach items="${c.unit}" var="s">	
	                <li class="after"><span><i class="icon-plus-sign"></i> ${s.id}, ${s.name} <span class="label label-primary">${s.leader}</span> <span class="label label label-default">${s.assistant}</span></span> <a class="btn btn-xs btn-default" href="UnitManager?uid=${s.id}">管理</a>
	                    <ul>
	                    	<c:forEach items="${s.sub_unit}" var="ss">
	                    	<li><span><i class="icon-minus-sign"></i> ${ss.id},${ss.name} <span class="label label-success">${ss.leader}</span> <span class="label label-default">${ss.assistant}</span></span> <a class="btn btn-xs btn-default" href="UnitManager?uid=${ss.id}">管理</a></li> 
	                    	</c:forEach>
	                       	<li>
	                       		<input type="hidden" name="check" id="check${c.id}${s.id}"/>
		                       	<input type="hidden" name="campus" value="${c.id}" />
		                       	<input type="hidden" name="pid" value="${s.id}" />
		                       	<input type="text" name="name" class="form-control" placeholder="建立二級單位"/>
		                       	<button class="btn btn-danger btn-xs" onClick="$('#check${c.id}${s.id}').val('check')" name="method:addUnit" type="submit">建立</button>		                       	
	                       	</li>
	                    </ul>
	                </li>
	                </c:forEach>     
	                <li>
	                    <input type="hidden" name="check" id="check${c.id}${s.id}"/>
		                <input type="hidden" name="campus" value="${c.id}" />
		                <input type="hidden" name="pid" value="0" />
		                <input type="text" name="name" class="form-control" placeholder="建立一級單位"/>
		                <button class="btn btn-link" onClick="$('#check${c.id}${s.id}').val('check')" name="method:addUnit" type="submit">建立</button>
	               </li>
	            </ul>
	        </li>
	        </c:forEach>
	    </ul>
	</div>
</div>
		
<div class="panel panel-primary">
  <div class="panel-heading">學術單位</div>
  <div class="panel-body tree">
	<ul>
       <c:forEach items="${colls}" var="c">
       <li><span><i class="icon-folder-open"></i> ${c.id}, ${c.name} <span class="label label-danger">${c.leader}</span> <span class="label label-default">${c.assistant}</span></span> <a class="btn btn-warning btn-xs" href="UnitManager?callege=${c.id}">管理</a>
           <ul>                
               <c:forEach items="${c.dept}" var="s">	
               <li class="after"><span><i class="icon-plus-sign"></i> ${s.id}, ${s.name} <span class="label label-primary">${s.leader}</span> <span class="label label-default">${s.assistant}</span></span> <a class="btn btn-default btn-xs" href="UnitManager?dept=${s.id}">管理</a></li>
               </c:forEach>                
           </ul>
       </li>
       </c:forEach>
    </ul>
</div>
</div>




</form>
<script>
$(".tree li:has(ul)").find( "li" ).hide('fast');
</script>
</body>
</html>