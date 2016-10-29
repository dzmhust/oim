/**
 * Copyright (C), dzmsoft Co., Ltd
 */
																											/**
 * 初始加载
 */
$(function(){
	initActions();
	createDg();
});
/**
 * 变量区
 */
var dgList; // 列表
var dForm;// 对话框
var supplierTypeArray = new DataDictionary(DICTIONARY_FIELD.SUPPLIER_TYPE);
var statusArray = new DataDictionary(DICTIONARY_FIELD.PARTNER_STATUS);
/**
 * 初始化绑定事件
 */
function initActions(){
	$('#searchFrom_find').on('click',function(){find();});
	$('#searchFrom_reset').on('click',function(){reset();});
	$('.add').linkbutton({'onClick':function(){add();}});
	$('.edit').linkbutton({'onClick':function(){edit();}});
	$('.remove').linkbutton({'onClick':function(){remove();}});
	$('.join').linkbutton({'onClick':function(){join();}});
	$('.release').linkbutton({'onClick':function(){release();}});
	DateRange.initDateBox($('#joinDate_start'), $('#joinDate_end'));
	supplierTypeArray.getFields();
	statusArray.getFields();
}
/**
 * 查询
 */
function find(){
	var obj=$("#searchFrom").serializeObject();
	dgList.datagrid('load',obj); 
}
/**
 * 重置
 */
function reset(){
	$('#searchFrom').form('clear');
	DateRange.resetDateBox($('#joinDate_start'), $('#joinDate_end'));
	find();
}
/*
 * 创建表格
 */
function createDg(){
	dgList=$('#dg').datagrid({    
	method: "post",url:ctx+'/oimSupplier/find', idField : 'id',singleSelect:true,
    fit : true,fitColumns : true,border : false,striped:true,
	pagination:true,rownumbers:true,pageNumber:1,pageSize : 20,pageList : [ 20, 30, 50 ],
    columns:[[    
    	    	    		    			{field:'id',title:'供应商编号',sortable:true,width:100,align:'left',halign:'center'}
    		    	    		    			,{field:'name',title:'供应商名称',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'chief',title:'负责人',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'chiefPhone',title:'负责人电话',sortable:true,width:100,align:'left',halign:'center',formatter:DzmFrame.EasyUI.fmtMobile }
    		    	    		    			,{field:'joinDate',title:'加盟日期',sortable:true,width:100,align:'left',halign:'center' ,formatter:DzmFrame.EasyUI.fmtYyyyMMdd}
    		    	    		    			,{field:'shortName',title:'简称',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'logoPic',title:'LOGO',sortable:true,width:100,align:'left',halign:'center',formatter:DzmFrame.EasyUI.fmtImage }
    		    	    		    			,{field:'regProvince',title:'注册省份',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'regCity',title:'注册城市',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'supplierType',title:'供应商类型',sortable:true,width:100,align:'left',halign:'center',formatter:fmtUserType }
    		    	    		    			,{field:'status',title:'状态',sortable:true,width:100,align:'left',halign:'center',formatter:fmtStatus }
    		    	    ]],
    sortName:'name',sortOrder:'asc',
    enableHeaderClickMenu: false,
    enableHeaderContextMenu: false,
    toolbar:'#tb',
    onClickRow:function(index,row){
		switch(row.status){
    	case PARTNER_STATUS.JOIN: 
    		$('.join').linkbutton('disable');
    		$('.release').linkbutton('enable');
    		$('.remove').linkbutton('disable');
    		break;
    	case PARTNER_STATUS.RELEASE:
    		$('.join').linkbutton('enable');
    		$('.release').linkbutton('disable');
    		$('.remove').linkbutton('enable');
    		break;
		default:
			$('.join').linkbutton('disable');
			$('.release').linkbutton('disable');
			$('.remove').linkbutton('disable');
			break;
		}
    }
	});
}
function fmtStatus(val){
	return statusArray.showDisplay(val);
}
function fmtUserType(val){
	return supplierTypeArray.showDisplay(val);
}
/**
 * 新增
 */
function add(){
	dForm=$('#dlg').dialog({title:'新增',width: 800, height: 380,modal:true
		,href:ctx+'/oimSupplier/add',
		buttons:[
			{text:'提交',handler:function(){submit();}}
			,{text:'返回',handler:function(){dForm.panel('close');}}
		]
	});
}
/**
 * 编辑
 */
function edit(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	dForm=$('#dlg').dialog({title:'编辑',width: 800, height: 380,modal:true
		,href:ctx+'/oimSupplier/edit/'+row.id,
		buttons:[
			{text:'提交',handler:function(){submit();}}
			,{text:'返回',handler:function(){dForm.panel('close');}}
		]
	});
}
/**
 * 删除
 */
function remove(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '删除后无法恢复您确定要删除？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:ctx+"/oimSupplier/remove/"+row.id,
				success: function(data){
					if (data.success){
						$.messager.alert('系统提示',data.msg,'info',function(){
							find();
						});
					} else{
						$.messager.alert('系统提示',data.msg,'error');
					}
				}
			});
		} 
	});
}
/**
 * 加盟
 */
function join(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '您确定同意加盟此供应商吗？', function(data){
		if (data){
			$.ajax({
				type:'put',
				url:ctx+"/oimSupplier/join/"+row.id,
				success: function(data){
					if (data.success){
						$.messager.alert('系统提示',data.msg,'info',function(){
							find();
						});
					} else{
						$.messager.alert('系统提示',data.msg,'error');
					}
				}
			});
		} 
	});
}
/**
 * 解约
 */
function release(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '您确定解约此供应商吗？', function(data){
		if (data){
			$.ajax({
				type:'put',
				url:ctx+"/oimSupplier/release/"+row.id,
				success: function(data){
					if (data.success){
						$.messager.alert('系统提示',data.msg,'info',function(){
							find();
						});
					} else{
						$.messager.alert('系统提示',data.msg,'error');
					}
				}
			});
		} 
	});
}
/**
 * 提交
 */
function submit(){
	$('#mainform').form('submit',{
		onSubmit:function(){
			var isValid = $(this).form('enableValidation').form('validate');
			if (isValid){
																																																																																																																													$.messager.progress();
			}
			return isValid;	// 返回false终止表单提交
		},
		success:function(result){
			$.messager.progress('close');
			//
			var data = $.parseJSON(result);
			if (data.success){
				$.messager.alert('系统提示',data.msg,'info',function(){
					dForm.panel('close');
					find();
				});
			} else{
				$.messager.alert('系统提示',data.msg,'error');
			}
		}
	});
}
