/**
 * Copyright (C), dzmsoft Co., Ltd
 */
/**
 * 初始化绑定事件
 */
function initActions(){
		$('.addOimCleanBagLine').linkbutton({'onClick':function(){addOimCleanBagLine();}});		
	$('.removeOimCleanBagLine').linkbutton({'onClick':function(){removeOimCleanBagLine();}});
	initOimCleanBagLine();
	loadOimCleanBagLine();
	DateRange.initDateBox($('#effectiveDate'), $('#expirationDate'));
	}
/**
 * 初始化方案明细
 */
	 /**
	  * 变量区
	  */
	 	 	var OimCleanBagLineGrid;
	 	var editIndexOimCleanBagLine=undefined;
		// 初始化明细
	var initOimCleanBagLine = function(){
				var action = $('#action').val();
		OimCleanBagLineGrid = $('#OimCleanBagLineGrid').datagrid({  
		idField : 'id',singleSelect:true,
	    fit:true, fitColumns : true,border : false,striped:true,
		pagination:true,rownumbers:true,pageNumber:1,pageSize : 20,pageList : [ 20, 30, 50 ],
	    columns:[[    
    			{field:'id',title:'ID',hidden:true}
	    			,{field:'item',title:'物品名称',sortable:true,width:100,align:'left',halign:'center',editor : {type:'textbox',options:{required:true} } }
	    			,{field:'price',title:'价格',sortable:true,width:100,align:'left',halign:'center',formatter : DzmFrame.EasyUI.fmtMoney,editor : {type : 'numberbox',options : {required : true,precision : 2}} }
	    			    		    ]],
	    	    toolbar:'OimCleanBagLine_tb',
	    enableHeaderClickMenu: false,
	    enableHeaderContextMenu: false,
	    autoEditing:(action == 'view')?false:true,
	    extEditing:(action == 'view')?false:true,
	    onClickCell:onClickCellOimCleanBagLine
		});
	};
	// 加载数据
	var loadOimCleanBagLine = function(){
		var action = $('#action').val();
		if (action == 'edit' || action == 'view'){
			var datasOimCleanBagLine = $("#datasOimCleanBagLine").val();
			if (!$.string.isNullOrEmpty(datasOimCleanBagLine)){
				var datasJsonOimCleanBagLine = $.parseJSON(datasOimCleanBagLine);
								OimCleanBagLineGrid.datagrid('loadData',datasJsonOimCleanBagLine);
			}
		}
	}
	/**
	 * 选择单元格
	 * @param index
	 * @param field
	 */
	var onClickCellOimCleanBagLine = function (index, field){
	    if (editIndexOimCleanBagLine != index){
	        if (endEditingOimCleanBagLine()){
	        	OimCleanBagLineGrid
	        	.datagrid('selectRow', index).datagrid('beginEdit', index);
	            var ed = OimCleanBagLineGrid
	            .datagrid('getEditor', {index:index,field:field});
	            if (ed){
	                ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
	            }
	            editIndexOimCleanBagLine = index;
	        } else {
	            setTimeout(function(){
	            	OimCleanBagLineGrid
	            	.datagrid('selectRow', editIndexOimCleanBagLine);
	            },0);
	        }
	    }
	}
	/**
	 * 结束编辑
	 * @returns {Boolean}
	 */
	var endEditingOimCleanBagLine = function(){
		if (editIndexOimCleanBagLine == undefined){return true}
	    if (OimCleanBagLineGrid
	    	.datagrid('validateRow', editIndexOimCleanBagLine)){
	    	OimCleanBagLineGrid
	    	.datagrid('endEdit', editIndexOimCleanBagLine);
	        editIndexOimCleanBagLine = undefined;
	        return true;
	    } else {
	        return false;
	    }
	}
	/**
	 * 新增
	 */
	var addOimCleanBagLine = function(){
		if (endEditingOimCleanBagLine()){
			OimCleanBagLineGrid
			.datagrid('appendRow',{id:Math.guid()});
	        editIndexOimCleanBagLine = OimCleanBagLineGrid
	        .datagrid('getRows').length-1;
	        OimCleanBagLineGrid
	        .datagrid('selectRow', editIndexOimCleanBagLine)
	                .datagrid('beginEdit', editIndexOimCleanBagLine);
		}
		
	}
	/**
	 * 删除
	 */
	var removeOimCleanBagLine = function (){
		if (editIndexOimCleanBagLine == undefined){return}
		OimCleanBagLineGrid
		.datagrid('cancelEdit', editIndexOimCleanBagLine)
	    	.datagrid('deleteRow', editIndexOimCleanBagLine);
		editIndexOimCleanBagLine = undefined;
	}

/**
 * 初始加载
 */
$(function(){
	initActions();
});


