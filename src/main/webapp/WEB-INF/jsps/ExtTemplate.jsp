<%@page contentType="text/html; charset=utf-8"%>
<html>
<head>
<%@include file="header.jsp"%>
</head>
<script type="text/javascript">
	$(function() {
		$('#extAttrList').w2grid({
			name : "extAttrList",
			header : '扩展属性列表',
			multiSelect : false,
			show : {
				buttons : true,
				header : true,
				toolbar : true,
				toolbarSearch   : false,
				toolbarColumns  : false,
				footer : true
			},
			url : basePath + '/extTemplate_query.do',
			columns : [ {
				field : 'oid',
				caption : '主键',
				size : '50%'
			}, {
				field : 'columnId',
				caption : '列标识',
				size : '50%'
			} , {
				field : 'groupId',
				caption : '组标识',
				size : '50%'
			}, {
				field : 'labelName',
				caption : '显示名',
				size : '50%'
			}],
		});
	});
</script>
<body style="height: 100%; width: 100%;">
	<div id="extAttrList" style="height: 50%; width: 100%;"></div>
</body>
</html>
