<%@page contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@include file="header.jsp"%>
<script type="text/javascript">
	var extAttr = '<%=request.getAttribute("extAttr")%>';
	
</script>
</head>
<script type="text/javascript">
	$(function() {
		$('#skuList').w2grid({
			name : "skuList",
			header : '库存列表',
			multiSelect : false,
			show : {
				buttons : true,
				header : true,
				toolbar : true,
				footer : true
			},
			url : basePath + '/skuManage_query.do',
			columns : [ {
				field : 'oid',
				caption : '主键',
				size : '10%'
			}, {
				field : 'sku',
				caption : '库存编号',
				size : '10%'
			}, {
				field : 'fitCountry',
				caption : '适用国家',
				size : '10%'
			}, {
				field : 'weight',
				caption : '重量',
				size : '10%'
			}, {
				field : 'standardPrice',
				caption : '成本价格',
				size : '10%'
			}, {
				field : 'priceUnit',
				caption : '价格单位',
				size : '10%'
			}, {
				field : 'length',
				caption : '长度',
				size : '10%'
			}, {
				field : 'width',
				caption : '宽度',
				size : '10%'
			}, {
				field : 'height',
				caption : '高度',
				size : '10%'
			} , {
				field : 'keyWord',
				caption : '关键字',
				size : '10%'
			}],
			toolbar : {
				items : [ {
					type : 'break'
				}, {
					type : 'button',
					id : 'add',
					caption : '新增'
				}, {
					type : 'button',
					id : 'edit',
					caption : '编辑'
				} ],
				onClick : function(target, data) {
					switch (target) {
					case "add":
						addSku();
						break;
					case "edit":
						editSku();
						break;
					default:
						break;
					}
				}
			},
		});
	});
	function addSku() {
		var template = $.templates("#extAttrTemplate");
		var htmlOutput = template.render(JSON.parse(extAttr));
		$("#addSkuExtTable").html("");
		$("#addSkuExtTable").append(htmlOutput);

		$("#addSkuWindow").dialog({
			width : 600,
			height : 600,
			modal : true,
			buttons : [ {
				text : "保存",
				click : function() {
					$.ajax({
						url : basePath + '/skuManage_saveSku.do',
						type : "POST",
						data :  $("#addSkuForm").serialize() ,
						success : function(msg) {
							alert("保存成功");
							$("#addSkuWindow").dialog("close");
						},
						failure: function(){
							alert("保存失败");
						}
					});
				}
			} ]
		});
	}
	function editSku() {

	}
</script>
<script id="extAttrTemplate" type="text/x-jsrender">
				<tr>
					<th>{{:labelName}}</th>
					<td><input type="text" name="extAttr['{{:columnId}}']" id="{{:columnId}}"></td>
				</tr>
</script>
<body style="height: 100%; width: 100%;">
	<div id="skuList" style="height: 50%; width: 100%;"></div>
	<div id="addSkuWindow" style="display: none;">
		<form id="addSkuForm">
			<table id="addSkuTable">
				<tr>
					<th>SKU编号</th>
					<td><input type="text" name="sku" id="sku"></td>
					<th>适用国家</th>
					<td><input type="text" name="fitCountry" id="fitCountry"></td>
				</tr>
				<tr>
					<th>重量</th>
					<td><input type="text" name="weight" id="weight"></td>
				</tr>
				<tr>
					<th>成本价</th>
					<td><input type="text" name="standardPrice" id="standardPrice"></td>
					<th>成本价单位</th>
					<td><input type="text" name="priceUnit" id="priceUnit"></td>
				</tr>
				<tr>
					<th>长度</th>
					<td><input type="text" name="length" id="length"></td>
					<th>宽度</th>
					<td><input type="text" name="width" id="width"></td>
				</tr>
				<tr>
					<th>高度</th>
					<td><input type="text" name="height" id="height"></td>
				</tr>
			</table>
			<table id="addSkuExtTable">
			</table>
		</form>
	</div>
</body>
</html>
