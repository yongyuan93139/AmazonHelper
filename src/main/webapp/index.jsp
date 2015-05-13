<%@page contentType="text/html; charset=utf-8"%>
<html>
<head>
<%@include file="/WEB-INF/jsps/header.jsp"%>
</head>
<script type="text/javascript">
	$(function() {
		$("#menus").selectmenu({
			change : function(event, data) {
				switch (data.item.value) {
				case "sku_manage":
					openSrc('/skuManage.do');
					break;
				case "template_manage":
					openSrc('/extTemplate.do');
					break;
				default:
					break;
				}
			}
		});
	});
	
	function openSrc(url) {
		var thisFrame = $("#mainFrame");
		thisFrame=thisFrame[0];
		thisFrame.src="abount:blank";
		try {
			thisFrame.contentWindow.document.write("");
			thisFrame.contentWindow.document.clear();
			thisFrame.contentWindow.close();
		} catch (e) {
			
		}
		thisFrame.src=basePath+url;
		thisFrame =null;
	}
	
</script>
<style>
select {
	width: 200px;
}
</style>
<body style="width:100%;height: 100%;">
	<div>
		<select name="menus" id="menus">
			<option value=""></option>
			<option value="sku_manage">库存管理</option>
			<option value="template_manage">模板配置</option>
		</select>
	</div>
	<div style="margin-top: 5px; border: none; width: 100%;">
		<iframe id="mainFrame" name="mainFrame" src="" style="width:100%; height:100%; margin: 0px; padding: 0px;" frameborder="0"></iframe>
	</div>
</body>
</html>
