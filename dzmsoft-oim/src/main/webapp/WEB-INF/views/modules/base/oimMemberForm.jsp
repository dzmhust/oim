<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/meta.jsp"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body >
	<div class="easyui-layout" style="width:730px; height:520px;">
	<div data-options="region:'north',border:false" style="height:200px;">
	<form id="mainform" action="${ctx}/oimMember/${action}"
		method="post">
		
		<table class="formTable" width="100%" border="0" cellspacing="0"
			cellpadding="5">
									<tr>
				<td>
					<input type="hidden" name="id" value="${oimMember.id}"/>
					<input type="hidden" id="action" value="${action}" />
											<input type="hidden" id="datasOimMemberAddress" name="datasOimMemberAddress" value="${datasOimMemberAddress}" />
									</td>
			</tr>
													<tr>
				<td width="25%" style="text-align:right">姓名：</td>
				<td width="75%">
									<textarea id="name" name="name" style="width:90%;height:100px;" <c:if test="${action=='view' }">disabled</c:if> >${oimMember.name}</textarea>
									</td>
				</tr>
													<tr>
				<td width="25%" style="text-align:right">性别：</td>
				<td width="75%">
									<input id="sex" name="sex" style="width:90%" <c:if test="${action=='view' }">disabled</c:if> class=" easyui-textbox " data-options="" value="${oimMember.sex}">
									</td>
				</tr>
													<tr>
				<td width="25%" style="text-align:right">手机号：</td>
				<td width="75%">
									<input id="mobile" name="mobile" style="width:90%" <c:if test="${action=='view' }">disabled</c:if> class=" easyui-textbox " data-options="" value="${oimMember.mobile}">
									</td>
				</tr>
													<tr>
				<td width="25%" style="text-align:right">用户ID：</td>
				<td width="75%">
									<input id="ucsId" name="ucsId" style="width:90%" <c:if test="${action=='view' }">disabled</c:if> class=" easyui-textbox " data-options="" value="${oimMember.ucsId}">
									</td>
				</tr>
													<tr>
				<td width="25%" style="text-align:right">创建时间：</td>
				<td width="75%">
									<input id="createTime" name="createTime" style="width:90%" <c:if test="${action=='view' }">disabled</c:if> class="easyui-datetimebox" data-options="" value="${oimMember.createTime}">
									</td>
				</tr>
													<tr>
				<td width="25%" style="text-align:right">：</td>
				<td width="75%">
									<input id="city" name="city" style="width:90%" <c:if test="${action=='view' }">disabled</c:if> class=" easyui-textbox " data-options="" value="${oimMember.city}">
									</td>
				</tr>
													<tr>
				<td width="25%" style="text-align:right">省：</td>
				<td width="75%">
									<input id="province" name="province" style="width:90%" <c:if test="${action=='view' }">disabled</c:if> class=" easyui-textbox " data-options="" value="${oimMember.province}">
									</td>
				</tr>
													<tr>
				<td width="25%" style="text-align:right">区县：</td>
				<td width="75%">
									<input id="division" name="division" style="width:90%" <c:if test="${action=='view' }">disabled</c:if> class=" easyui-textbox " data-options="" value="${oimMember.division}">
									</td>
				</tr>
								</table>
	</form>
	</div>
	<div data-options="region:'center',border:false">
		<div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
						<div title="标题" style="padding:5px;">
								<div id="OimMemberAddress_tb" style="padding:5px;height:auto">
					<table cellpadding="0" cellspacing="0">
					<shiro:hasPermission name="OimMemberAddress:add">
						<td>
						<a href="javascript:void(0)" class="easyui-linkbutton addOimMemberAddress" iconCls="icon-add" plain="true">新增</a>
						</td>
						<td>
			 			<span class="toolbar-item dialog-tool-separator"></span>
			 			</td>
			 		</shiro:hasPermission>
			 		<shiro:hasPermission name="OimMemberAddress:remove">
						<td>
						<a href="javascript:void(0)" class="easyui-linkbutton removeOimMemberAddress" iconCls="icon-remove" plain="true">删除</a>
						</td>
						<td>
			 			<span class="toolbar-item dialog-tool-separator"></span>
			 			</td>
			 		</shiro:hasPermission>
			 		</table>
				</div>
								<table id="OimMemberAddressGrid" ></table>
			</div>
			 		</div>
 	</div>
 	
	<script src="${ctxResources}/pages/modules/base/oimMemberForm.js"></script>
</body>
</html>
