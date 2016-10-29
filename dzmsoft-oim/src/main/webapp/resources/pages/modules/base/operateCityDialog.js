$(function(){
	initActions();
	createDomainDg();
});
var operateCityDialogList;
/**
 * 初始化绑定事件
 */
function initActions(){
	$('#operateCityDialog_confirm').on('click',function(){confirm();});
	$('#operateCityDialog_cancel').on('click',function(){cancel();});
}
function confirm(){
	var rows = operateCityDialogList.datagrid('getSelections');
	if ($.array.isNullOrEmpty(rows)){
		$.messager.alert('系统提示','请选择至少一条数据','error');
		return ;
	}
	window.closeRegion(rows);
}
function cancel(){
	this.panel('close');
}
/**
 * 创建系统表格
 */
function createDomainDg(){
	operateCityDialogList = $('#operateCityDialogGrid').datagrid({    
	    method: "post",url:ctx+'/oimAdminRegion/getOperateCitys', idField : 'cityCode',singleSelect:false,
	    fit : true,fitColumns : true,border : false,striped:true,
		pagination:true,rownumbers:true,pageNumber:1,pageSize : 20,pageList : [ 20, 30, 50 ],
	    columns:[[    
	    			{field:'cityCode',title:'城市编码',width:30},    
	        {field:'cityName',title:'城市名称',sortable:false,width:100}
	    		    	    ]],
	    sortName:'cityCode',sortOrder:'asc',
	    enableHeaderClickMenu: false,
	    enableHeaderContextMenu: false,
	    toolbar:'#operateCityDialog_dg'
	});
}
