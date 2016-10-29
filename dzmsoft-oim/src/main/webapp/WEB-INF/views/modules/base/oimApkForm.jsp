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

	<form id="mainform" action="${ctx}/oimApk/${action}" method="post"
		enctype="multipart/form-data">
		<input type="hidden" id="action" value="${action}" />
		<table class="formTable" width="100%" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td><input type="hidden" name="id" value="${oimApk.id}" /></td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">应用类型：</td>
				<td width="75%"><input id="apkType" name="apkType"
					style="width: 90%" data-options="required:true"
					value="${oimApk.apkType}"></td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">应用名称：</td>
				<td width="75%"><input id="name" name="name" style="width: 90%"
					class=" easyui-textbox "
					data-options="required:true ,validType:'length[1,30]'"
					value="${oimApk.name}"></td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">包名：</td>
				<td width="75%"><input id="packageName" name="packageName"
					style="width: 90%" class=" easyui-textbox "
					data-options="required:true ,validType:'length[1,40]'"
					value="${oimApk.packageName}"></td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">应用版本：</td>
				<td width="75%"><input id="version" name="version"
					style="width: 90%" class=" easyui-textbox "
					data-options="required:true ,validType:'length[1,30]'"
					value="${oimApk.version}"></td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">APK文件：</td>
				<td width="75%">
					<div class="uploader-container">
						<div id="apkFileId"></div>
						<input type="hidden" id="apkFileInput" /> <input type="hidden"
							id="apkFile" name="apkFile" value="${oimApk.apkFile}" />
						<input type="hidden"
							id="apkName" name="apkName" value="${oimApk.apkName}" />
					</div>
				</td>
			</tr>
			<tr>
				<td width="25%" style="text-align: right">应用描述：</td>
				<td width="75%"><textarea id="description" name="description"
						style="width: 90%; height: 100px;">${oimApk.description}</textarea>
				</td>
			</tr>
			
			
		</table>
	</form>
	<script type="text/javascript">
		$(function() {
			initActions();
			initFile();
		});
		function initFile() {
			debugger;
			var action = $('#action').val();
			if (action == 'edit') {
				var content = $('#apkFile').val();
				var vmName = $('#apkName').val();
				var record = DzmFrame.Uploader.record(vmName, content);
				$('#apkFileInput').val(record);
			}
			$("#apkFileId").powerWebUpload({
				hiddenInputId : "apkFileInput",
				fileNumLimit : 1,
				fileSizeLimit : 1024 * 1024 * 20,
				PostbackHold : true,
				innerOptions : {
					accept : {
						extensions : 'apk',
						mimeTypes : '.apk'
					}
				}
			});
		}
		function initActions() {
			getApkType();
		}
		function getApkType(){
			var apkProductArray = new DataDictionary(DICTIONARY_FIELD.APK_PRODUCT);
			apkProductArray.getFields();
			apkProductArray.initCombobox($('#apkType'));
		}
	</script>
</body>
</html>
