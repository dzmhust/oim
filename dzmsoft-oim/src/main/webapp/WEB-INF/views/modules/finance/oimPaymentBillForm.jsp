<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
																																	<head>
	<title></title>
	<%@ include file="/WEB-INF/views/include/meta.jsp"%>
	<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
	<%@ include file="/WEB-INF/views/include/easyui.jsp"%>
	</head>
<body>
	
			<form id="mainform" action="${ctx}/oimPaymentBill/${action}" method="post" enctype="multipart/form-data">
					<table class="formTable" width="100%" border="0" cellspacing="0" cellpadding="5" >
												<tr>
				<td>
					<input type="hidden" name="id" value="${oimPaymentBill.id}"/>
				</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">收款方ID：</td>
				<td width="75%">
											<input id="recipientId" name="recipientId" style="width:90%" value="${oimPaymentBill.recipientId}"
																																										class="easyui-textbox"
												data-options="required:false,validType:'length[32,32]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">收款方：</td>
				<td width="75%">
											<input id="recipientName" name="recipientName" style="width:90%" value="${oimPaymentBill.recipientName}"
																																										class="easyui-textbox"
												data-options="required:false,validType:'length[1,40]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">付款方id：</td>
				<td width="75%">
											<input id="paymentId" name="paymentId" style="width:90%" value="${oimPaymentBill.paymentId}"
																																										class="easyui-textbox"
												data-options="required:false,validType:'length[32,32]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">付款方：</td>
				<td width="75%">
											<input id="paymentName" name="paymentName" style="width:90%" value="${oimPaymentBill.paymentName}"
																																										class="easyui-textbox"
												data-options="required:false,validType:'length[1,40]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">付款时间：</td>
				<td width="75%">
											<input id="paymentTime" name="paymentTime" style="width:90%" value="${oimPaymentBill.paymentTime}"
																																										class="easyui-datetimebox"
												data-options="required:false,validType:'',formatter:DzmFrame.EasyUI.fmtDatetime,parser: DzmFrame.EasyUI.parseDate" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">金额：</td>
				<td width="75%">
											<input id="amount" name="amount" style="width:90%" value="${oimPaymentBill.amount}"
																																										class="easyui-numberbox"
												data-options="required:false,validType:'',precision:2,groupSeparator:','" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">状态：</td>
				<td width="75%">
											<input id="status" name="status" style="width:90%" value="${oimPaymentBill.status}"
																																										class="easyui-textbox"
												data-options="required:false,validType:'length[2,2]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">业务订单号：</td>
				<td width="75%">
											<input id="orderId" name="orderId" style="width:90%" value="${oimPaymentBill.orderId}"
																																										class="easyui-textbox"
												data-options="required:false,validType:'length[1,32]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">业务订单类型：</td>
				<td width="75%">
											<input id="orderType" name="orderType" style="width:90%" value="${oimPaymentBill.orderType}"
																																										class="easyui-textbox"
												data-options="required:false,validType:'length[2,2]'" >
															</td>
			</tr>
												<tr>
				<td width="25%" style="text-align:right">创建时间：</td>
				<td width="75%">
											<input id="createTime" name="createTime" style="width:90%" value="${oimPaymentBill.createTime}"
																																										class="easyui-datetimebox"
												data-options="required:false,validType:'',formatter:DzmFrame.EasyUI.fmtDatetime,parser: DzmFrame.EasyUI.parseDate" >
															</td>
			</tr>
								</table>
			</form>
	<script type="text/javascript">
	$(function(){
		initActions();
					});
		function initActions(){
			}
		</script>
</body>
</html>	