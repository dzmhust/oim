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
	<div class="easyui-layout" style="width: 730px; height: 520px;">
		<div data-options="region:'north',border:false" style="height: 200px;">
			<form id="mainform" action="${ctx}/oimCleanBag/${action}"
				method="post">

				<table class="formTable" width="100%" border="0" cellspacing="0"
					cellpadding="5">
					<tr>
						<td><input type="hidden" name="id" value="${oimCleanBag.id}" />
							<input type="hidden" id="action" value="${action}" /> <input
							type="hidden" id="datasOimCleanBagLine"
							name="datasOimCleanBagLine" value="${datasOimCleanBagLine}" /></td>
					</tr>
					<tr>
						<td width="25%" style="text-align: right">清洁包名称：</td>
						<td width="75%"><input id="name" name="name"
							style="width: 90%"
							<c:if test="${action=='view' }">disabled</c:if>
							class=" easyui-textbox " data-options=""
							value="${oimCleanBag.name}"></td>
					</tr>
					<tr>
						<td width="25%" style="text-align: right">生效日期：</td>
						<td width="75%"><input id="effectiveDate"
							name="effectiveDate" style="width: 90%"
							<c:if test="${action=='view' }">disabled</c:if>
							class="easyui-datebox" data-options="required:true "
							value="${oimCleanBag.effectiveDate}"></td>
					</tr>
					<tr>
						<td width="25%" style="text-align: right">失效日期：</td>
						<td width="75%"><input id="expirationDate"
							name="expirationDate" style="width: 90%"
							<c:if test="${action=='view' }">disabled</c:if>
							class="easyui-datebox" data-options="required:true "
							value="${oimCleanBag.expirationDate}"></td>
					</tr>
					<tr>
						<td width="25%" style="text-align: right">清洁包描述：</td>
						<td width="75%"><textarea id="description" name="description"
								style="width: 90%; height: 70px;"
								<c:if test="${action=='view' }">disabled</c:if>>${oimCleanBag.description}</textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false">
			<div class="easyui-tabs"
				data-options="fit:true,border:false,plain:true">
				<div title="清洁包明细" style="padding: 5px;">
					<div id="OimCleanBagLine_tb" style="padding: 5px; height: auto">
						<table cellpadding="0" cellspacing="0">
							<shiro:hasPermission name="OimCleanBagLine:add">
								<td><a href="javascript:void(0)"
									class="easyui-linkbutton addOimCleanBagLine" iconCls="icon-add"
									plain="true">新增</a></td>
								<td><span class="toolbar-item dialog-tool-separator"></span>
								</td>
							</shiro:hasPermission>
							<shiro:hasPermission name="OimCleanBagLine:remove">
								<td><a href="javascript:void(0)"
									class="easyui-linkbutton removeOimCleanBagLine"
									iconCls="icon-remove" plain="true">删除</a></td>
								<td><span class="toolbar-item dialog-tool-separator"></span>
								</td>
							</shiro:hasPermission>
						</table>
					</div>
					<table id="OimCleanBagLineGrid"></table>
				</div>
			</div>
		</div>

		<script src="${ctxResources}/pages/modules/base/oimCleanBagForm.js"></script>
</body>
</html>
