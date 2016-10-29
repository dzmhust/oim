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
	$('.enable').linkbutton({'onClick':function(){enable();}});
	$('.disable').linkbutton({'onClick':function(){disable();}});
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
	find();
}
/*
 * 创建表格
 */
function createDg(){
	dgList=$('#dg').datagrid({    
	method: "post",url:ctx+'/oimHouseholdPriceRule/find', idField : 'id',singleSelect:true,
    fit : true,fitColumns : true,border : false,striped:true,
	pagination:true,rownumbers:true,pageNumber:1,pageSize : 20,pageList : [ 20, 30, 50 ],
    columns:[[    
    	    	    		    			{field:'id',title:'ID',hidden:true}
			    			    			    			,{field:'name',title:'名称',sortable:true,width:100,align:"left",halign:'center' }
			    			    			,{field:'status',title:'状态',sortable:true,width:100,align:"left",halign:'center',formatter:function(val){return statusArray.showDisplay(val);} }
			    			    			,{field:'description',title:'描述',sortable:true,width:100,align:"left",halign:'center' }
			    			    			,{field:'price',title:'单价',sortable:true,width:100,align:"right",halign:'center' ,formatter:DzmFrame.EasyUI.fmtMoney}
			    			    			,{field:'effectiveDate',title:'生效日期',sortable:true,width:100,align:"left",halign:'center' ,formatter:DzmFrame.EasyUI.fmtYyyyMMdd}
			    			    			,{field:'expirationDate',title:'失效日期',sortable:true,width:100,align:"left",halign:'center' ,formatter:DzmFrame.EasyUI.fmtYyyyMMdd}
			    			    			,{field:'deployTime',title:'发布时间',sortable:true,width:100,align:"left",halign:'center' ,formatter:DzmFrame.EasyUI.fmtDatetime}
			    			    			,{field:'operateRegion',title:'运营区域',sortable:true,width:100,align:"left",halign:'center' }
    		    	    ]],
    sortName:'name',sortOrder:'asc',
    enableHeaderClickMenu: false,
    enableHeaderContextMenu: false,
    toolbar:'#tb'
	});
}
/**
 * 设置运营区域
 */
function setRegion(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	// 当前选中行
	curRow = row;
	operateCityDailog=$('#dlg').dialog({title:'选择运营区域',width: 380, height: 500, modal:true
		,href:ctx+'/oimHouseholdPriceRule/showRegionDialog'
	});
}
/**
 * 关闭运营区域
 */
function closeRegion(datas){
	operateCityDailog.panel('close');
	var operateCitys = [];
	$.each(datas, function(index,data){
		operateCitys.push({'cityCode':data.cityCode,'cityName':data.cityName});
	})
	$.ajax({
		type:'post',
		url:ctx+"/oimHouseholdPriceRule/setRegions",
		data:{'operateCity':JSON.stringify(datas),'id':curRow.id},
		dataType:'json',
		success: function(result){
			if (result.success){
				find();
			} else{
				$.messager.alert('系统提示',result.msg,'error');
			}
		}
	});
}
/**
 * 新增
 */
function add(){
		var url = ctx+'/oimHouseholdPriceRule/add';
	window.top.addTab('新增',url);
	}
/**
 * 编辑
 */
function edit(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
		var url = ctx+'/oimHouseholdPriceRule/edit/'+row.id;
	window.top.addTab('编辑',url);
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
				url:ctx+"/oimHouseholdPriceRule/remove/"+row.id,
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
 * 启用
 */
function enable(){
	var row = dgList.datagrid('getSelected');
	if(rowIsNull(row)) return;
	parent.$.messager.confirm('提示', '您确定要启用吗？', function(data){
		if (data){
			$.ajax({
				type:'put',
				url:ctx+"/oimHouseholdPriceRule/enable/"+row.id,
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
	parent.$.messager.confirm('提示', '您确定要禁用？', function(data){
		if (data){
			$.ajax({
				type:'put',
				url:ctx+"/oimHouseholdPriceRule/disable/"+row.id,
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
