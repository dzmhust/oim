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

	<form id="mainform" action="${ctx}/oimSupplier/${action}" method="post"
		enctype="multipart/form-data">
		<table class="formTable" width="100%" border="0" cellspacing="0"
			cellpadding="5">
			<tr>
				<td><input type="hidden" name="id" value="${oimSupplier.id}" />
				</td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">供应商名称：</td>
				<td width="25%"><input id="name" name="name"class=" easyui-textbox "
					data-options="required:true ,validType:'length[1,100]'"
						style="width: 100%; " value="${oimSupplier.name}"></input>
				</td>
				<td width="15%" style="text-align: right">加盟日期：</td>
				<td width="25%"><input id="joinDate" name="joinDate"
					style="width: 100%" class="easyui-datebox"
					data-options="required:true " value="${oimSupplier.joinDate}">
				</td>
				<td width="20%" rowspan="4">
					<div class="updateimg">
						<a href="javascript:void(0);"> <c:choose>
								<c:when
									test="${action == 'edit' && not empty oimSupplier.logoPic}">
									<img src="${ctx }/upload/${oimSupplier.logoPic}" />
								</c:when>
								<c:otherwise>
									<img src="../resources/images/add_img.jpg" />
								</c:otherwise>
							</c:choose>
						</a> <input class="file" type="file" id="logoPicId" name="logoPicName"
							accept="image/*">
					</div>
				</td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">简称：</td>
				<td width="25%"><input id="shortName" name="shortName"
					style="width: 100%" class=" easyui-textbox "
					data-options="required:true ,validType:'length[1,6]'"
					value="${oimSupplier.shortName}"></td>
				<td width="15%" style="text-align: right">供应商类型：</td>
				<td width="25%"><input id="supplierType" name="supplierType"
					style="width: 100%" 
					data-options="required:true "
					value="${oimSupplier.supplierType}"></td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">负责人：</td>
				<td width="25%"><input id="chief" name="chief"
					style="width: 100%" class=" easyui-textbox " data-options="required:true"
					value="${oimSupplier.chief}"></td>
				<td width="15%" style="text-align: right">负责人电话：</td>
				<td width="25%"><input id="chiefPhone" name="chiefPhone"
					style="width: 100%" class=" easyui-textbox "
					data-options="required:true ,validType:'mobile'"
					value="${oimSupplier.chiefPhone}"></td>
			</tr>
			<tr>
				<td width="15%" style="text-align:right">注册区域：</td>
				<td width="85%" colspan="3">
					<input id="regProvince" name="regProvince" class="easyui-combobox" style="width:120px;"  data-options="required:true, editable:false,prompt: '请选择省份',missingMessage:'请选择省份'"  value="${oimSupplier.regProvince}" />
					<input id="regCity" name="regCity" class="easyui-combobox" style="width:120px;"  data-options="required:true, editable:false,prompt: '请选择城市',missingMessage:'请选择城市'"  value="${oimSupplier.regCity}" />
					<input id="regDistrict" name="regDistrict" class="easyui-combobox" style="width:120px;"  data-options="required:true, editable:false,prompt: '请选择区县',missingMessage:'请选择区县'"  value="${oimSupplier.regDistrict}" />
				</td>
			</tr>
			<tr>
				<td width="15%" style="text-align: right">简介：</td>
				<td width="85%" colspan="4"><textarea id="description" name="description"
						style="width: 90%; height: 100px;">${oimSupplier.description}</textarea>
				</td>
			</tr>

		</table>
	</form>
	<script type="text/javascript">
		$(function() {
			initActions();
			initProvince();
			initCity('${oimSupplier.regProvince}');
			initDistrict('${oimSupplier.regCity}');
			getSupplierType();
		});
		function getSupplierType(){
			var supplierTypeArray = new DataDictionary(DICTIONARY_FIELD.SUPPLIER_TYPE);
			supplierTypeArray.getFields();
			supplierTypeArray.initCombobox($('#supplierType'));
		}
		function initProvince(){
			$('#regProvince').combobox({
				method:'get',
				url:ccs_ctx+'ccs04/' + DICTIONARY_FIELD.ADMIN_REGION,
				valueField:'id',
				textField:'name',
				onSelect:function(record){
					initCity(record.id);
					$('#regCity').combobox('clear');
					$('#regCity').combobox('setValue','');
					$('#regDistrict').combobox('clear');
					$('#regDistrict').combobox('setValue','');
					$('#regDistrict').combobox('loadData',[]);
				}
			});
		}
		function initCity(pid){
			if ($.string.isNullOrEmpty(pid)){
				pid = -1;
			}
			$('#regCity').combobox({
				method:'get',
				url:ccs_ctx+'ccs04/' + DICTIONARY_FIELD.ADMIN_REGION +'?pid='+pid,
				valueField:'id',
				textField:'name',
				onSelect:function(record){
					initDistrict(record.id);
					$('#regDistrict').combobox('clear');
					$('#regDistrict').combobox('setValue','');
				}
			});
		}
		function initDistrict(pid){
			if ($.string.isNullOrEmpty(pid)){
				pid = -1;
			}
			$('#regDistrict').combobox({
				method:'get',
				url:ccs_ctx+'ccs04/' + DICTIONARY_FIELD.ADMIN_REGION +'?pid='+pid,
				valueField:'id',
				textField:'name',
			});
		}
		function initActions() {
			$('#logoPicId').on('change', function() {
				changePic();
			});
		}
		function changePic() {
			DzmFrame.File.previewImage($("#logoPicId")[0]);
		}
	</script>
</body>
</html>
