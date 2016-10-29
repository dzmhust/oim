<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/meta.jsp"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body>
	<form id="mainform" action="${ctx}/oimAdPosition/${action}"
		method="post">
		<table class="formTable" width="100%" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td style="width: 25%; text-align: right">栏目编号：</td>
				<td><input id="id" name="id" style="width: 90%"
					class=" easyui-textbox "
					data-options="required:true ,validType:'length[6,6]'"
					value="${oimAdPosition.id}"></td>
			</tr>
			<tr>
				<td style="width: 25%; text-align: right">栏目名称：</td>
				<td width="75%"><input id="name" name="name" style="width: 90%"
					class=" easyui-textbox "
					data-options="required:true ,validType:'length[1,20]'"
					value="${oimAdPosition.name}"></td>
			</tr>
			<tr>
				<td style="width: 25%; text-align: right">上级栏目：</td>
				<td width="75%"><input id="pid" name="pid" style="width: 90%"
					value="${oimAdPosition.pid}"></td>
			</tr>
			<tr>
				<td style="width: 25%; text-align: right">描述：</td>
				<td width="75%"><input id="description" name="description"
					style="width: 90%" class=" easyui-textbox "
					data-options=" height:100,multiline:true "
					value="${oimAdPosition.description}"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(function() {
			getParent();
		});
		function getParent() {
			var parentArray = new ComboBoxTreeBean(ctx + '/oimAdPosition/find');
			parentArray.getFields();
			parentArray.initCombobox($('#pid'));
		}
	</script>
</body>
</html>
