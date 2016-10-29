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
	<div id="operateCityDialog_tb" style="padding:5px;height:auto">
        <div>
			<form id="operateCityDialog_searchFrom" action="">
				<a href="#" class="easyui-linkbutton" iconCls="icon-ok" plain="true" id="operateCityDialog_confirm">确定</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-no" plain="true" id="operateCityDialog_cancel">取消</a>
			</form>
        </div> 
  	</div>
  	
	<table id="operateCityDialogGrid"></table> 
	<script src="${ctxResources}/pages/modules/base/operateCityDialog.js"></script>
</body>
</html>	