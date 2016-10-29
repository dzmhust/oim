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
var statusArray = new DataDictionary(DICTIONARY_FIELD.STATUS);
/**
 * 初始化绑定事件
 */
function initActions(){
	$('#searchFrom_find').on('click',function(){find();});
	$('#searchFrom_reset').on('click',function(){reset();});
	$('.add').linkbutton({'onClick':function(){add();}});
	$('.edit').linkbutton({'onClick':function(){edit();}});
	$('.remove').linkbutton({'onClick':function(){remove();}});
	$('.deploy').linkbutton({'onClick':function(){deploy();}});
	$('.disable').linkbutton({'onClick':function(){disable();}});
	statusArray.getFields();
	DateRange.initDateBox($('#deployTime_start'), $('#deployTime_end'));
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
	DateRange.resetDateBox($('#deployTime_start'), $('#deployTime_end'));
	find();
}
/*
 * 创建表格
 */
function createDg(){
	dgList=$('#dg').datagrid({    
	method: "post",url:ctx+'/oimAdArticle/find', idField : 'id',singleSelect:true,
    fit : true,fitColumns : true,border : false,striped:true,
	pagination:true,rownumbers:true,pageNumber:1,pageSize : 20,pageList : [ 20, 30, 50 ],
    columns:[[    
    	    	    		    			{field:'id',title:'ID',hidden:true}
    		    	    		    			,{field:'position',title:'栏目',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'shortTitle',title:'短标题',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'longTitle',title:'长标题',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'summary',title:'摘要',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'status',title:'状态',sortable:true,width:100,align:'left',halign:'center',formatter:fmtStatus }
    		    	    		    			,{field:'deployTime',title:'发布时间',sortable:true,width:100,align:'left',halign:'center' ,formatter:DzmFrame.EasyUI.fmtDatetime}
    		    	    ]],
    sortName:'position',sortOrder:'asc',
    enableHeaderClickMenu: false,
    enableHeaderContextMenu: false,
    toolbar:'#tb',
    onClickRow:function(index,row){
		switch(row.status){
    	case DATA_STATUS.ENABLE: 
    		$('.deploy').linkbutton('disable');
    		$('.disable').linkbutton('enable');
    		$('.remove').linkbutton('disable');
    		break;
    	case DATA_STATUS.DISABLED:
    		$('.deploy').linkbutton('enable');
    		$('.disable').linkbutton('disable');
    		$('.remove').linkbutton('enable');
    		break;
		default:
			$('.deploy').linkbutton('disable');
			$('.disable').linkbutton('disable');
			$('.remove').linkbutton('disable');
			break;
		}
    }
	});
}
function fmtStatus(val){
	return statusArray.showDisplay(val);
}
/**
 * 新增
 */
function add(){
	var url = ctx+'/oimAdArticle/add';
	window.top.addTab('新增广告',url);
}
/**
 * 编辑
 */
function edit(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	var url = ctx+'/oimAdArticle/edit/'+row.id;
	window.top.addTab('编辑广告',url);
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
				url:ctx+"/oimAdArticle/remove/"+row.id,
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
 * 发布
 */
function deploy(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '您确定发布此广告吗？', function(data){
		if (data){
			$.ajax({
				type:'put',
				url:ctx+"/oimAdArticle/deploy/"+row.id,
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
 * 禁用
 */
function disable(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '您确定禁用此广告吗？', function(data){
		if (data){
			$.ajax({
				type:'put',
				url:ctx+"/oimAdArticle/disable/"+row.id,
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
	$('#context').val(UE.getEditor('contextId').getContent());
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
