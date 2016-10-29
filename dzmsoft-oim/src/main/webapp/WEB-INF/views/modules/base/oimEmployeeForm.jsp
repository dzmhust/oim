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
	<form id="mainform" method="post" action="${ctx}/oimEmployee/${action}" enctype="multipart/form-data">
		<table class="formTable" width="100%" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td><input type="hidden" name="id" value="${oimEmployee.id}" />
				</td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">姓名：</td>
				<td width="25%"><input id="name" name="name" style="width: 100%"
					class=" easyui-textbox "
					data-options="required:true ,validType:'length[1,20]'"
					value="${oimEmployee.name}"></td>
				<td width="15%" style="text-align: right">性别 ：</td>
				<td width="25%"><input id="sex" name="sex" style="width: 100%"
					data-options="required:true"
					value="${oimEmployee.sex}"></td>
				<td width="20%" rowspan="4">
					<div class="updateimg">
						<a href="javascript:void(0);"> <c:choose>
								<c:when
									test="${action == 'edit' && not empty oimEmployee.headPortrailPic}">
									<img src="${ctx }/upload/${oimEmployee.headPortrailPic}" />
								</c:when>
								<c:otherwise>
									<img src="../resources/images/add_img.jpg" />
								</c:otherwise>
							</c:choose>
						</a> <input class="file" type="file" id="headPortrailPicId"
							name="headPortrailPicName" accept="image/*">
					</div>
				</td>
			</tr>
			<tr>
				<td style="text-align: right">出生日期：</td>
				<td><input id="birthday" name="birthday"
					style="width: 100%" class="easyui-datebox"
					data-options="required:true " value="${oimEmployee.birthday}">
				</td>
				<td style="text-align: right">用户类型：</td>
				<td ><input id="userType" name="userType"
					style="width: 100%" data-options="required:true"
					value="${oimEmployee.userType}"></td>
			</tr>
			<tr>
				<td style="text-align: right">手机号：</td>
				<td colspan="3"><input id="mobile" name="mobile"
					style="width: 100%" class=" easyui-textbox "
					data-options="required:true ,validType:'mobile'"
					value="${oimEmployee.mobile}"></td>
			</tr>
			<tr>
				<td style="text-align: right">身份证号：</td>
				<td colspan="3"><input id="idCard" name="idCard"
					style="width: 100%" class=" easyui-textbox "
					data-options="required:true ,validType:'idCard'"
					value="${oimEmployee.idCard}"></td>
			</tr>
			<tr>
				<td style="text-align: right">员工简介：</td>
				<td colspan="4">
					<textarea id="description" name="description" style="width:90%;height:100px;">${oimEmployee.description}</textarea>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(function() {
			initActions();
		});
		function initActions() {
			$('#headPortrailPicId').on('change', function() {
				changePic();
			});
			getSex();
			getUserType();
		}
		function getSex(){
			var sexArray = new DataDictionary(DICTIONARY_FIELD.SEX);
			sexArray.getFields();
			sexArray.initCombobox($('#sex'));
		}
		function getUserType(){
			var userTypeArray = new DataDictionary(DICTIONARY_FIELD.PLATFORM_ROLE);
			userTypeArray.getFields();
			userTypeArray.initCombobox($('#userType'));
		}
		function changePic() {
			DzmFrame.File.previewImage($("#headPortrailPicId")[0]);
		}
	</script>
</body>
</html>
