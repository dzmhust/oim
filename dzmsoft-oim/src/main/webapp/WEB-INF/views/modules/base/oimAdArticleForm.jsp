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
				<td><input type="hidden" name="id" value="${oimAdArticle.id}" />
				</td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">栏目：</td>
				<td width="35%"><input id="position" name="position"
					style="width: 100%" 
					data-options="required:true"
					value="${oimAdArticle.position}"></td>
				<td width="15%" style="text-align: right">短标题：</td>
				<td width="35%"><input id="shortTitle" name="shortTitle"
					style="width: 100%" class=" easyui-textbox "
					data-options="required:true ,validType:'length[1,30]'"
					value="${oimAdArticle.shortTitle}"></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">长标题：</td>
				<td width="85%" colspan="3">
					<input id="shortTitle" name="shortTitle"
					style="width: 100%" class=" easyui-textbox "
					data-options=""
					value="${oimAdArticle.longTitle}">
				</td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">PC图片标题：</td>
				<td width="35%">
					<div class="updateimg">
						<a href="javascript:void(0);"> <c:choose>
								<c:when
									test="${action == 'edit' && not empty oimAdArticle.pcTitlePic}">
									<img src="${ctx }/upload/${oimAdArticle.pcTitlePic}" />
								</c:when>
								<c:otherwise>
									<img src="../resources/images/add_img.jpg" />
								</c:otherwise>
							</c:choose>
						</a> <input class="file" type="file" id="pcTitlePicId"
							name="pcTitlePicName" accept="image/*">
					</div>
				</td>
				<td width="15%" style="text-align: right">APP图标标题：</td>
				<td width="35%">
					<div class="updateimg">
						<a href="javascript:void(0);"> <c:choose>
								<c:when
									test="${action == 'edit' && not empty oimAdArticle.appTitlePic}">
									<img src="${ctx }/upload/${oimAdArticle.appTitlePic}" />
								</c:when>
								<c:otherwise>
									<img src="../resources/images/add_img.jpg" />
								</c:otherwise>
							</c:choose>
						</a> <input class="file" type="file" id="appTitlePicId"
							name="appTitlePicName" accept="image/*">
					</div>
				</td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">摘要：</td>
				<td width="85%" colspan="3"><textarea id="summary" name="summary"
						style="width: 100%; height: 100px;">${oimAdArticle.summary}</textarea>
				</td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">内容：</td>
				<td width="85%" colspan="3"><input id="context" name="context"
					type="hidden" value="${oimAdArticle.context}" /> <script
						id="contextId" type="text/plain"
						style="width: 100%; height: 200px;" class="">
						</script></td>
			</tr>
		</table>
		<div style="text-align:center;padding:5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
			</div>
	</form>
	<script type="text/javascript">
		$(function() {
			initActions();
			getColumns();
			initUeditor();
		});
		function initActions() {
			$('#pcTitlePicId').on('change', function() {
				DzmFrame.File.previewImage($("#pcTitlePicId")[0]);
			});
			$('#appTitlePicId').on('change', function() {
				DzmFrame.File.previewImage($("#appTitlePicId")[0]);
			});
		}
		function getColumns(){
			var columns = new ComboBoxTreeBean(ctx+'/oimAdPosition/find');
			columns.getFields();
			columns.initCombobox($('#position'));
		}
		function initUeditor() {
			var action = $('#action').val();
			UE.getEditor('contextId');
			if (action == 'edit') {
				UE.getEditor('contextId').addListener("ready", function() {
					UE.getEditor('contextId').setContent($('#context').val());
				});
			}
		}
		function submitForm(){
			var action = $('#action').val();
			var url = ctx + '/oimAdArticle/' + action;
			$('#mainform').form('submit',{
				url:url,
				onSubmit:function(){
					var isValid = $(this).form('enableValidation').form('validate');
					if (isValid){
						$.messager.progress(); 
						$('#context').val(UE.getEditor('contextId').getContent());
					}
					return isValid;	// 返回false终止表单提交
				},
				success:function(result){
					$.messager.progress('close');
					var data = $.parseJSON(result);
					if (data.success){
						$('#action').val(data.data);
						$.messager.alert('系统提示',data.msg,'info');
					} else{
						$.messager.alert('系统提示',data.msg,'error');
					}
				}
			});
		}
	</script>
</body>
</html>
