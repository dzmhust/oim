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
	<form id="mainform" action="${ctx}/oimMallCategory/${action}"
		method="post" enctype="multipart/form-data">
		<table class="formTable" width="100%" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td style="width: 15%; text-align: right">分类编号：</td>
				<td width="35%"><input id="id" name="id" style="width: 90%" 
					class=" easyui-textbox "
					data-options="required:true ,validType:'length[6,6]' " 
					value="${oimMallCategory.id}"></td>
				<td style="width: 15%; text-align: right">分类名称：</td>
				<td width="35%"><input id="name" name="name" style="width: 90%"
					class=" easyui-textbox "
					data-options="required:true ,validType:'length[1,16]'"
					value="${oimMallCategory.name}"></td>
			</tr>
			<tr>
				<td style="width: 15%; text-align: right">上级分类：</td>
				<td width="35%"><input id="pid" name="pid" style="width: 90%"
					value="${oimMallCategory.pid}"></td>
				<td style="width: 15%; text-align: right">排序：</td>
				<td width="35%"><input id="sort" name="sort" style="width: 90%"
					class="easyui-numberbox" data-options=""
					value="${oimMallCategory.sort}"></td>
			</tr>
			<tr>
				<td style="width: 15%; text-align: right">网页图标文件路径：</td>
				<td width="35%">
					<div class="updateimg">
						<a href="javascript:void(0);"> <c:choose>
								<c:when
									test="${action == 'edit' && not empty oimMallCategory.siteResourcePath}">
									<img src="${ctx }/upload/${oimMallCategory.siteResourcePath}" />
								</c:when>
								<c:otherwise>
									<img src="../resources/images/add_img.jpg" />
								</c:otherwise>
							</c:choose>
						</a> <input class="file" type="file" id="siteResourcePathId" name="siteResourcePathName"
							accept="image/*">
					</div>
				</td>
				<td style="width: 15%; text-align: right">手机端图标路径：</td>
				<td width="35%">
					<div class="updateimg">
						<a href="javascript:void(0);"> <c:choose>
								<c:when
									test="${action == 'edit' && not emptyoimMallCategory.phoneResourcePath}">
									<img src="${ctx }/upload/${oimMallCategory.phoneResourcePath}" />
								</c:when>
								<c:otherwise>
									<img src="../resources/images/add_img.jpg" />
								</c:otherwise>
							</c:choose>
						</a> <input class="file" type="file" id="phoneResourcePathId" name="phoneResourcePathName"
							accept="image/*">
					</div>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(function() {
			getParent();
			$('#siteResourcePathId').on('change', function() {DzmFrame.File.previewImage($("#siteResourcePathId")[0]);});
			$('#phoneResourcePathId').on('change', function() {DzmFrame.File.previewImage($("#phoneResourcePathId")[0]);});
		});
		function getParent() {
			var parentArray = new ComboBoxTreeBean(ctx
					+ '/oimMallCategory/find');
			parentArray.getFields();
			parentArray.initCombobox($('#pid'));
		}
	</script>
</body>
</html>
