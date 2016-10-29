<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/meta.jsp"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
<%@ include file="/WEB-INF/views/include/ueditor.jsp"%>
</head>
<body>

	<input type="hidden" id="action" value="${action}" />
	<form id="mainform" method="post" enctype="multipart/form-data">
		<table class="formTable" width="100%" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td><input type="hidden" name="id"
					value="${oimNewhomePriceRule.id}" /></td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">名称：</td>
				<td width="75%"><input id="name" name="name" style="width: 90%"
					value="${oimNewhomePriceRule.name}" class="easyui-textbox"
					data-options="required:true,validType:'length[1,40]'"></td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">描述：</td>
				<td width="75%"><textarea id="description" name="description"
						style="width: 90%; height: 100px;">${oimNewhomePriceRule.description}</textarea>
				</td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">每平米单价：</td>
				<td width="75%"><input id="price" name="price"
					style="width: 90%" value="${oimNewhomePriceRule.price}"
					class="easyui-numberbox"
					data-options="required:true,validType:'',precision:2,groupSeparator:','">
				</td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">详情：</td>
				<td width="75%"><input id="detail" name="detail" type="hidden"
					value="${oimNewhomePriceRule.detail}" /> <script id="detailId"
						type="text/plain" style="width: 100%; height: 200px;" class="">
						</script></td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">生效日期：</td>
				<td width="75%"><input id="effectiveDate" name="effectiveDate"
					style="width: 90%" value="${oimNewhomePriceRule.effectiveDate}"
					class="easyui-datebox"
					data-options="required:true,validType:'',parser: DzmFrame.EasyUI.parseDate">
				</td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">失效日期：</td>
				<td width="75%"><input id="expirationDate"
					name="expirationDate" style="width: 90%"
					value="${oimNewhomePriceRule.expirationDate}"
					class="easyui-datebox"
					data-options="required:true,validType:'',parser: DzmFrame.EasyUI.parseDate">
				</td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">运营区域：</td>
				<td width="75%"><textarea id="operateRegion"
						name="operateRegion" style="width: 90%; height: 100px;">${oimNewhomePriceRule.operateRegion}</textarea>
				</td>
			</tr>
		</table>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">提交</a>
		</div>
	</form>
	<script type="text/javascript">
		$(function() {
			initActions();
			initUeditor();
		});
		function initActions() {
		}
		function initUeditor() {
			var action = $('#action').val();
			UE.getEditor('detailId');
			if (action == 'edit') {
				UE.getEditor('detailId').addListener("ready", function() {
					UE.getEditor('detailId').setContent($('#detail').val());
				});
			}
		}
		function submitForm() {
			var action = $('#action').val();
			var url = ctx + '/oimNewhomePriceRule/' + action;
			$('#mainform').form(
					'submit',
					{
						url : url,
						onSubmit : function() {
							var isValid = $(this).form('enableValidation')
									.form('validate');
							if (isValid) {
								$.messager.progress();
								$('#detail').val(
										UE.getEditor('detailId').getContent());
							}
							return isValid; // 返回false终止表单提交
						},
						success : function(result) {
							$.messager.progress('close');
							var data = $.parseJSON(result);
							if (data.success) {
								$('#action').val(data.data);
								$.messager.alert('系统提示', data.msg, 'info');
							} else {
								$.messager.alert('系统提示', data.msg, 'error');
							}
						}
					});
		}
	</script>
</body>
</html>
