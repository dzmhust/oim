<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/views/include/meta.jsp"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
</head>
<body class="easyui-layout">
	<div data-options="region:'center'">
	<div id="tb" style="padding:5px;height:auto">
        <div>
        	<form id="searchFrom" action="">
				<input type="text" name="filter_likes_name" class="easyui-textbox" data-options="width:150,prompt: '姓名'"/>
				<input id="createTime_start" class="easyui-textbox" name="filter_ged_createTime" data-options="width:150,prompt: '创建起始时间'"/>
				<input id="createTime_end" class="easyui-textbox" name="filter_led_createTime" data-options="width:150,prompt: '创建截止时间'"/>
				<shiro:hasPermission name="oimMember:find">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" id="searchFrom_find">查询</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" id="searchFrom_reset">重置</a>
				</shiro:hasPermission>
			</form>
			<table cellpadding="0" cellspacing="0">
				<tr>
					<shiro:hasPermission name="oimMember:add">
						<td>
						<a href="javascript:void(0)" class="easyui-linkbutton add" iconCls="icon-add" plain="true">新增</a>
						</td>
						<td>
	       				<span class="toolbar-item dialog-tool-separator"></span>
	       				</td>
	       			</shiro:hasPermission>
	       			<shiro:hasPermission name="oimMember:edit">
	       				<td>
						<a href="javascript:void(0)" class="easyui-linkbutton edit" iconCls="icon-edit" plain="true">编辑</a>
						</td>
						<td>
	       				<span class="toolbar-item dialog-tool-separator"></span>
	       				</td>
	       			</shiro:hasPermission>
	       			<shiro:hasPermission name="oimMember:remove">
	       				<td>
						<a href="javascript:void(0)" class="easyui-linkbutton remove" iconCls="icon-remove" plain="true">删除</a>
						</td>
						<td>
	       				<span class="toolbar-item dialog-tool-separator"></span>
	       				</td>
	       			</shiro:hasPermission>
				</tr>
			</table>
        </div> 
  </div>
	<table id="leftDg"></table> 
</div>
	<div data-options="region:'east',split:true,title:'会员服务地址'" style="width:500px;" id="rightListPanel">
		<div id="right_tb" style="padding:5px;height:auto">
			<table cellpadding="0" cellspacing="0">
			</table>
		</div>
		<table id="rightDg"></table>
	</div>
<div id="dlg"></div>  
<script src="${ctxResources}/pages/modules/base/oimMemberList.js"></script>
</body>
</html>