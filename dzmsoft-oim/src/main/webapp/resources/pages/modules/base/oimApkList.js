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
var statusArray = new DataDictionary(DICTIONARY_FIELD.APK_STATUS);
var apkProductArray = new DataDictionary(DICTIONARY_FIELD.APK_PRODUCT);
/**
 * 初始化绑定事件
 */
function initActions(){
	$('#searchFrom_find').on('click',function(){find();});
	$('#searchFrom_reset').on('click',function(){reset();});
	$('.add').linkbutton({'onClick':function(){add();}});
	$('.edit').linkbutton({'onClick':function(){edit();}});
	$('.remove').linkbutton({'onClick':function(){remove();}});
	$('.online').linkbutton({'onClick':function(){online();}});
	$('.offline').linkbutton({'onClick':function(){offline();}});
	statusArray.getFields();
	apkProductArray.getFields();
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
	find();
}
/*
 * 创建表格
 */
function createDg(){
	dgList=$('#dg').datagrid({    
	method: "post",url:ctx+'/oimApk/find', idField : 'id',singleSelect:true,
    fit : true,fitColumns : true,border : false,striped:true,
	pagination:true,rownumbers:true,pageNumber:1,pageSize : 20,pageList : [ 20, 30, 50 ],
    columns:[[    
    	    	    		    			{field:'id',title:'ID',hidden:true}
    	    	    		    				,{field:'apkType',title:'应用类型',sortable:true,width:100,align:'left',halign:'center',formatter:fmtApkType }
    		    	    		    			,{field:'name',title:'应用名称',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'packageName',title:'包名',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'apkName',title:'APK名称',sortable:true,width:100,align:'left',halign:'center',formatter:fmtDownload }
    		    	    		    			,{field:'version',title:'应用版本',sortable:true,width:100,align:'left',halign:'center' }
    		    	    		    			,{field:'status',title:'状态',sortable:true,width:100,align:'left',halign:'center',formatter:fmtStatus }
    		    	    		    			
    		    	    		    			,{field:'description',title:'应用描述',sortable:true,width:100,align:'left',halign:'center' }
    		    	    ]],
    sortName:'name',sortOrder:'asc',
    enableHeaderClickMenu: false,
    enableHeaderContextMenu: false,
    toolbar:'#tb',
    onClickRow:function(index,row){
		switch(row.status){
    	case PARTNER_STATUS.JOIN: 
    		$('.online').linkbutton('disable');
    		$('.offline').linkbutton('enable');
    		$('.remove').linkbutton('disable');
    		break;
    	case PARTNER_STATUS.RELEASE:
    		$('.online').linkbutton('enable');
    		$('.offline').linkbutton('disable');
    		$('.remove').linkbutton('enable');
    		break;
		default:
			$('.online').linkbutton('disable');
			$('.offline').linkbutton('disable');
			$('.remove').linkbutton('disable');
			break;
		}
    }
	});
}
function fmtStatus(val){
	return statusArray.showDisplay(val);
}
function fmtApkType(val){
	return apkProductArray.showDisplay(val);
}
function fmtDownload(val, record){
	if ($.isEmptyObject(val)){
		return '';
	}
	return '<a href="javascript:void(0);" onclick="DzmFrame.Uploader.download(\''+val + '\',\'' + record.apkFile+'\');">' + val + '</a>';
}
/**
 * 新增
 */
function add(){
	dForm=$('#dlg').dialog({title:'新增',width: 380, height: 380,modal:true
		,href:ctx+'/oimApk/add',
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
	dForm=$('#dlg').dialog({title:'编辑',width: 380, height: 380,modal:true
		,href:ctx+'/oimApk/edit/'+row.id,
		buttons:[
			{text:'提交',handler:function(){submit();}}
			,{text:'返回',handler:function(){dForm.panel('close');}}
		]
	});
}
/**
 * 删除用户
 */
function remove(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '删除后无法恢复您确定要删除？', function(data){
		if (data){
			$.ajax({
				type:'get',
				url:ctx+"/oimApk/remove/"+row.id,
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
 * 上线
 */
function online(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '您确定要上线此应用吗？', function(data){
		if (data){
			$.ajax({
				type:'put',
				url:ctx+"/oimApk/online/"+row.id+'/'+row.packageName,
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
 * 下线
 */
function offline(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '您确定要下线此应用吗？', function(data){
		if (data){
			$.ajax({
				type:'put',
				url:ctx+"/oimApk/offline/"+row.id,
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
				var contentFileInput = $('#apkFileInput').val();
				var file = $.parseJSON(contentFileInput);
				if (!$.array.isNullOrEmpty(file.fileList)){
					var fileData = file.fileList[0];
					$('#apkFile').val(fileData.filePath);
					$('#apkName').val(fileData.name);
				}
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
