<%@page contentType="text/html; charset=utf-8"%>
<html>
<head>
<%@include file="header.jsp"%>
</head>
<script type="text/javascript">
	$(function() {
		$('#templateList').jtable({
			title : '库存列表',
			paging : true, //Enable paging
			pageSize : 10, //Set page size (default: 10)
			messages : {
				pagingInfo : '显示 {0}-{1}条   总共{2}条',
				gotoPageLabel : '跳转到',
				pageSizeChangeLabel : '每页显示',
				loadingMessage : '数据加载中...',
				editRecord : '详细',
				noDataAvailable : '没有数据！'
			},
			actions : {
				listAction : basePath + '/extTemplate_query.do'
			},
			fields: {  
				oid: {
	                title:'主键',  
	                width:'50%' 
				},
				sku: {
	                title:'库存编号',  
	                width:'50%' 
				}
			}
		});
		$('#templateList').jtable('load');
	});
</script>
<body style="height: 100%; width: 100%;">
	<div id="templateList" style="height: 100%; width: 100%;"></div>
</body>
</html>
