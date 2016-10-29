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
			<table class="formTable" width="100%" border="0" cellspacing="0" cellpadding="5" >
												<tr>
				<td>
					<input type="hidden" name="id" value="${oimCard.id}"/>
				</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">名称：</td>
				<td width="75%">
											<input id="name" name="name" style="width:90%" value="${oimCard.name}"
																																										class="easyui-textbox"
												data-options="required:true,validType:'length[1,40]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">面值：</td>
				<td width="75%">
											<input id="faceValue" name="faceValue" style="width:90%" value="${oimCard.faceValue}"
																																										class="easyui-numberbox"
												data-options="required:true,validType:'',precision:2,groupSeparator:','" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">生效日期：</td>
				<td width="75%">
											<input id="effectiveDate" name="effectiveDate" style="width:90%" value="${oimCard.effectiveDate}"
																																										class="easyui-datebox"
												data-options="required:false,validType:'',parser: DzmFrame.EasyUI.parseDate" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">失效日期：</td>
				<td width="75%">
											<input id="expierationDate" name="expierationDate" style="width:90%" value="${oimCard.expierationDate}"
																																										class="easyui-datebox"
												data-options="required:false,validType:'',parser: DzmFrame.EasyUI.parseDate" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">状态：</td>
				<td width="75%">
											<input id="status" name="status" style="width:90%" value="${oimCard.status}"
																																										class="easyui-textbox"
												data-options="required:false,validType:'length[2,2]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">创建时间：</td>
				<td width="75%">
											<input id="createTime" name="createTime" style="width:90%" value="${oimCard.createTime}"
																																										class="easyui-datetimebox"
												data-options="required:true,validType:'',formatter:DzmFrame.EasyUI.fmtDatetime,parser: DzmFrame.EasyUI.parseDate" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">创建者：</td>
				<td width="75%">
											<input id="creator" name="creator" style="width:90%" value="${oimCard.creator}"
																																										class="easyui-textbox"
												data-options="required:true,validType:'length[32,32]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">描述：</td>
				<td width="75%">
											<textarea id="description" name="description" style="width:90%;height:100px;">${oimCard.description}</textarea>
									</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">供应商：</td>
				<td width="75%">
											<input id="supplier" name="supplier" style="width:90%" value="${oimCard.supplier}"
																																										class="easyui-textbox"
												data-options="required:false,validType:'length[9,9]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">背景图片：</td>
				<td width="75%">
											<div class="updateimg">
							<a href="javascript:void(0);">
							<c:choose>
																<c:when test="${action == 'edit' && not empty oimCard.backgroundPic}">
																		<img src="${ctx }/upload/${oimCard.backgroundPic}" />
								</c:when>
								<c:otherwise>
									<img src="../resources/images/add_img.jpg" />
								</c:otherwise>
							</c:choose>
							</a>
														<input class="file" type="file" id="backgroundPicId" name="backgroundPicName" accept="image/*"> 
						</div>
									</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">详情：</td>
				<td width="75%">
											<input id="content" name="content" type="hidden" value="${oimCard.content}"/>
						<script id="contentId" type="text/plain" style="width:100%;height:200px;" class="">
						</script>
									</td>
			</tr>
								</table>
				<div style="text-align:center;padding:5px">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
		</div>
			</form>
	<script type="text/javascript">
	$(function(){
		initActions();
					initUeditor();
					});
		function initActions(){
																																																																																				$('#backgroundPicId').on('change',function(){DzmFrame.File.previewImage($("#backgroundPicId")[0]);});
																	}
			function initUeditor(){
			var action = $('#action').val();
																																																																																									UE.getEditor('contentId');
										if (action == 'edit'){
																																																																																																																		UE.getEditor('contentId').addListener("ready", function () {
					        UE.getEditor('contentId').setContent($('#content').val());
						});
												}
		}
		function submitForm(){
			var action = $('#action').val();
			var url = ctx + '/oimCard/' + action;
			$('#mainform').form('submit',{
				url:url,
				onSubmit:function(){
					var isValid = $(this).form('enableValidation').form('validate');
					if (isValid){
						$.messager.progress(); 
																																																																																																																																																																				$('#content').val(UE.getEditor('contentId').getContent());
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