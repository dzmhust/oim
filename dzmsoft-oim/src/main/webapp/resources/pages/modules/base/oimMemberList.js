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
var leftDgList; // 左列表
var leftId;
var leftForm;// 对话框
var rightDgList; // 右列表
/**
 * 初始化绑定事件
 */
function initActions(){
	$('#searchFrom_find').on('click',function(){find();});
	$('#searchFrom_reset').on('click',function(){reset();});
	$('.add').linkbutton({'onClick':function(){add();}});
	$('.edit').linkbutton({'onClick':function(){edit();}});
	$('.remove').linkbutton({'onClick':function(){remove();}});
	DateRange.initDateBox($('#createTime_start'), $('#createTime_end'));
}
/**
 * 查询
 */
function find(){
	var obj=$("#searchFrom").serializeObject();
	leftDgList.datagrid('load',obj); 
}
/**
 * 重置
 */
function reset(){
	$('#searchFrom').form('clear');
	DateRange.resetDateBox($('#createTime_start'), $('#createTime_end'));
	find();
}
/*
 * 创建表格
 */
function createDg(){
	leftDgList=$('#leftDg').datagrid({    
	method: "post",url:ctx+'/oimMember/find', idField : 'id',singleSelect:true,
    fit : true,fitColumns : true,border : false,striped:true,
	pagination:true,rownumbers:true,pageNumber:1,pageSize : 20,pageList : [ 20, 30, 50 ],
    columns:[[    
    	    	    		    			{field:'id',title:'ID',hidden:true}
    		    	    		    			,{field:'name',title:'姓名',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'sex',title:'性别',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'mobile',title:'手机号',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'ucsId',title:'用户ID',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'createTime',title:'创建时间',sortable:true,width:100,align:'left',halign:'center' ,formatter:DzmFrame.EasyUI.fmtDatetime}
    		    	    		    			,{field:'city',title:'',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'province',title:'省',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'division',title:'区县',sortable:true,width:100,align:'left',halign:'center' }
    		    	    ]],
    sortName:'name',sortOrder:'asc',
    enableHeaderClickMenu: false,
    enableHeaderContextMenu: false,
    toolbar:'#tb',
    onDblClickRow:function(index,row){
	    	leftId = row.id;
	    	rightDgList.datagrid('reload',{filter_eqs_left:leftId}); 
	    	$('#rightListPanel').panel({title:row.name});
	    },
    onLoadSuccess:function(data){
		if (data && data.total>0){
			// 默认选中第一行
			$('#leftDg').datagrid('selectRow',0);
			var row = $('#leftDg').datagrid('getSelected');
			leftId = row.id;
			createRightDg(leftId);
			$('#rightListPanel').panel({title:row.name});
		} else{
			createRightDg('-1');
		}
    }
	});
	
}
function createRightDg(leftId){
	rightDgList = $('#rightDg').datagrid({    
	method: "post",url:ctx+'/oimMemberAddress/find',queryParams:{filter_eqs_left:leftId}, idField : 'id',singleSelect:true,
    fit : true,fitColumns : true,border : false,striped:true,
	pagination:true,rownumbers:true,pageNumber:1,pageSize : 20,pageList : [ 20, 30, 50 ],
    columns:[[    
    	    	    		    			{field:'id',title:'ID',hidden:true}
    		    	    		    			,{field:'isDefault',title:'默认',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'city',title:'市',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'division',title:'区',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'shortAddress',title:'短地址',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'longAddress',title:'长地址',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'ucsId',title:'会员',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'province',title:'省',sortable:true,width:100,align:'left',halign:'center' }
    		    	    ]],
    sortName:'isDefault',sortOrder:'asc',
    enableHeaderClickMenu: false,
    enableHeaderContextMenu: false,
    toolbar:'#right_tb'
    });
}
/**
 * 新增
 */
function add(){
	leftForm=$('#dlg').dialog({title:'新增',width: 380, height: 380,modal:true
		,href:ctx+'/oimMember/add',
		buttons:[
			{text:'提交',handler:function(){submit();}}
			,{text:'返回',handler:function(){leftForm.panel('close');}}
		]
	});
}
/**
 * 编辑
 */
function edit(){
	var row = leftDgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	leftForm=$('#dlg').dialog({title:'编辑',width: 380, height: 380,modal:true
		,href:ctx+'/oimMember/edit/'+row.id,
		buttons:[
			{text:'提交',handler:function(){submit();}}
			,{text:'返回',handler:function(){leftForm.panel('close');}}
		]
	});
}
/**
 * 删除用户
 */
function remove(){
	var row = leftDgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '删除后无法恢复您确定要删除？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:ctx+"/oimMember/remove/"+row.id,
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
					leftForm.panel('close');
					find();
				});
			} else{
				$.messager.alert('系统提示',data.msg,'error');
			}
		}
	});
}
