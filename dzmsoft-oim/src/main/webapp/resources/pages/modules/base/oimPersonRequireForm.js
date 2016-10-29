/**
 * Copyright (C), dzmsoft Co., Ltd
 */
/**
 * 初始化绑定事件
 */
function initActions(){
		$('.addOimPersonRequireLine').linkbutton({'onClick':function(){addOimPersonRequireLine();}});		
	$('.removeOimPersonRequireLine').linkbutton({'onClick':function(){removeOimPersonRequireLine();}});
	initOimPersonRequireLine();
	loadOimPersonRequireLine();
	DateRange.initDateBox($('#effectiveDate'), $('#expirationDate'));
	}
/**
 * 初始化方案明细
 */
	 /**
	  * 变量区
	  */
	 	 	var OimPersonRequireLineGrid;
	 	var editIndexOimPersonRequireLine=undefined;
		// 初始化明细
	var initOimPersonRequireLine = function(){
				var action = $('#action').val();
		OimPersonRequireLineGrid = $('#OimPersonRequireLineGrid').datagrid({  
		idField : 'id',singleSelect:true,
	    fit:true, fitColumns : true,border : false,striped:true,
		pagination:true,rownumbers:true,pageNumber:1,pageSize : 20,pageList : [ 20, 30, 50 ],
	    columns:[[    
				    		    			    			{field:'id',title:'ID',hidden:true}
	    			    		    			    			,{field:'requirement',title:'个性需求',sortable:true,width:100,align:'left',halign:'center',editor : {type:'textbox',options:{required:true}} }
	    			    		    			    			,{field:'requireId',title:'需求版本',hidden:true }
	    			    		    ]],
	    	    toolbar:'OimPersonRequireLine_tb',
	    enableHeaderClickMenu: false,
	    enableHeaderContextMenu: false,
	    autoEditing:(action == 'view')?false:true,
	    extEditing:(action == 'view')?false:true,
	    onClickCell:onClickCellOimPersonRequireLine
		});
	};
	// 加载数据
	var loadOimPersonRequireLine = function(){
		var action = $('#action').val();
		if (action == 'edit' || action == 'view'){
			var datasOimPersonRequireLine = $("#datasOimPersonRequireLine").val();
			if (!$.string.isNullOrEmpty(datasOimPersonRequireLine)){
				var datasJsonOimPersonRequireLine = $.parseJSON(datasOimPersonRequireLine);
								OimPersonRequireLineGrid.datagrid('loadData',datasJsonOimPersonRequireLine);
			}
		}
	}
	/**
	 * 选择单元格
	 * @param index
	 * @param field
	 */
	var onClickCellOimPersonRequireLine = function (index, field){
	    if (editIndexOimPersonRequireLine != index){
	        if (endEditingOimPersonRequireLine()){
	        	OimPersonRequireLineGrid
	        	.datagrid('selectRow', index).datagrid('beginEdit', index);
	            var ed = OimPersonRequireLineGrid
	            .datagrid('getEditor', {index:index,field:field});
	            if (ed){
	                ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
	            }
	            editIndexOimPersonRequireLine = index;
	        } else {
	            setTimeout(function(){
	            	OimPersonRequireLineGrid
	            	.datagrid('selectRow', editIndexOimPersonRequireLine);
	            },0);
	        }
	    }
	}
	/**
	 * 结束编辑
	 * @returns {Boolean}
	 */
	var endEditingOimPersonRequireLine = function(){
		if (editIndexOimPersonRequireLine == undefined){return true}
	    if (OimPersonRequireLineGrid
	    	.datagrid('validateRow', editIndexOimPersonRequireLine)){
	    	OimPersonRequireLineGrid
	    	.datagrid('endEdit', editIndexOimPersonRequireLine);
	        editIndexOimPersonRequireLine = undefined;
	        return true;
	    } else {
	        return false;
	    }
	}
	/**
	 * 新增
	 */
	var addOimPersonRequireLine = function(){
		if (endEditingOimPersonRequireLine()){
			OimPersonRequireLineGrid
			.datagrid('appendRow',{id:Math.guid()});
	        editIndexOimPersonRequireLine = OimPersonRequireLineGrid
	        .datagrid('getRows').length-1;
	        OimPersonRequireLineGrid
	        .datagrid('selectRow', editIndexOimPersonRequireLine)
	                .datagrid('beginEdit', editIndexOimPersonRequireLine);
		}
		
	}
	/**
	 * 删除
	 */
	var removeOimPersonRequireLine = function (){
		if (editIndexOimPersonRequireLine == undefined){return}
		OimPersonRequireLineGrid
		.datagrid('cancelEdit', editIndexOimPersonRequireLine)
	    	.datagrid('deleteRow', editIndexOimPersonRequireLine);
		editIndexOimPersonRequireLine = undefined;
	}

/**
 * 初始加载
 */
$(function(){
	initActions();
});


