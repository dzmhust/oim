/**
 * Copyright (C), dzmsoft Co., Ltd
 */

/**
 * 初始化绑定事件
 */
function initActions(){
		$('.addOimMemberAddress').linkbutton({'onClick':function(){addOimMemberAddress();}});		
	$('.removeOimMemberAddress').linkbutton({'onClick':function(){removeOimMemberAddress();}});
	initOimMemberAddress();
	loadOimMemberAddress();
	}
/**
 * 初始化方案明细
 */
	//
	var editIndexOimMemberAddress=undefined;
		// 初始化明细
	var initOimMemberAddress = function(){
				var action = $('#action').val();
		OimMemberAddressGrid = $('#OimMemberAddressGrid').datagrid({  
		idField : 'id',singleSelect:true,
	    fit:true, fitColumns : true,border : false,striped:true,
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
	    	    toolbar:'OimMemberAddress_tb',
	    enableHeaderClickMenu: false,
	    enableHeaderContextMenu: false,
	    autoEditing:(action == 'view')?false:true,
	    extEditing:(action == 'view')?false:true,
	    onClickCell:onClickCellOimMemberAddress
		});
	};
	// 加载数据
	var loadOimMemberAddress = function(){
		var action = $('#action').val();
		if (action == 'edit' || action == 'view'){
			var datasOimMemberAddress = $("#datasOimMemberAddress").val();
			if (!$.string.isNullOrEmpty(datasOimMemberAddress)){
				var datasJsonOimMemberAddress = $.parseJSON(datasOimMemberAddress);
								OimMemberAddressGrid.datagrid('loadData',datasJsonOimMemberAddress);
			}
		}
	}
	/**
	 * 选择单元格
	 * @param index
	 * @param field
	 */
	var onClickCellOimMemberAddress = function (index, field){
	    if (editIndexOimMemberAddress != index){
	        if (endEditingOimMemberAddress()){
	        	OimMemberAddressGrid
	        	.datagrid('selectRow', index).datagrid('beginEdit', index);
	            var ed = OimMemberAddressGrid
	            .datagrid('getEditor', {index:index,field:field});
	            if (ed){
	                ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
	            }
	            editIndexOimMemberAddress = index;
	        } else {
	            setTimeout(function(){
	            	OimMemberAddressGrid
	            	.datagrid('selectRow', editIndex);
	            },0);
	        }
	    }
	}
	/**
	 * 结束编辑
	 * @returns {Boolean}
	 */
	var endEditingOimMemberAddress = function(){
		if (editIndexOimMemberAddress == undefined){return true}
	    if (OimMemberAddressGrid
	    	.datagrid('validateRow', editIndexOimMemberAddress)){
	    	OimMemberAddressGrid
	    	.datagrid('endEdit', editIndexOimMemberAddress);
	        editIndexOimMemberAddress = undefined;
	        return true;
	    } else {
	        return false;
	    }
	}
	/**
	 * 新增
	 */
	var addOimMemberAddress = function(){
		if (endEditingOimMemberAddress()){
			OimMemberAddressGrid
			.datagrid('appendRow',{id:Math.guid()});
	        editIndexOimMemberAddress = OimMemberAddressGrid
	        .datagrid('getRows').length-1;
	        OimMemberAddressGrid
	        .datagrid('selectRow', editIndexOimMemberAddress)
	                .datagrid('beginEdit', editIndexOimMemberAddress);
		}
		
	}
	/**
	 * 删除
	 */
	var removeOimMemberAddress = function (){
		if (editIndexOimMemberAddress == undefined){return}
		OimMemberAddressGrid
		.datagrid('cancelEdit', editIndex)
	    	.datagrid('deleteRow', editIndex);
		editIndexOimMemberAddress = undefined;
	}

/**
 * 初始加载
 */
$(function(){
	initActions();
});


