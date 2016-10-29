/**
 * 数据字典中的类型
 */
var DICTIONARY_FIELD = {
	// 树型数据字典
	SEX : '0001',
	// 启用、禁用、删除状态
	STATUS : '0002',
	// 行政区域
	ADMIN_REGION : '0004',
	//收款单状态
	RECIPIENT_BILL:'0024',
	//方案类型
	SOLUTION_TYPE:'0015',
	// 用户类型
	USER_TYPE : '0005',
	// 供应商类型 
	SUPPLIER_TYPE:'0007',
	// 用户状态
	EMP_STATUS:'0008',
	// 平台用户角色
	PLATFORM_ROLE:'0009',
	// APK状态
	APK_STATUS:'0010',
	// APK产品
	APK_PRODUCT:'0011',
	// 合作伙伴状态
	PARTNER_STATUS:'0027',
	// 民族
	NATION:'0028',
	// 平台用户类型
	PLATFORM_USER_TYPE:'0032'
}
/**
 * http状态
 * 
 * @type
 */
var HTTP_STATUS = {
	SC_UNAUTHORIZED : '401',
	ERR_CONNECTION_REFUSED : '0'
}
/**
 * 应用状态
 */
var APK_STATUS = {
	// 初始
	INIT : '00'
	// 上线
	,
	ONLINE : '01'
	// 删除
	,
	DELETE : '02'
	// 下线
	,
	OFFLINE : '03'
}
/**
 * 数据状态
 */
var DATA_STATUS = {
	// 禁用
	DISABLED : '00'
	// 启用
	,
	ENABLE : '01'
	// 删除
	,
	DELETE : '02'
}
var PACKAGE_TYPE = {
	// 简单
	SIMPLE : '00',
	// 豪华
	LUXURY : '02',
	// 实用
	PRACTICAL : '01'
}
/**
 * 用户类型
 */
var USER_TYPE = {
	// 业主
	OWNER : '60'
	// 主材商
	,
	ADVOCATEMATERIAL : '20'
	// 主材商内部用户
	,
	ADVOCATETHEINTERNALUSERS : '21'
	// 平台内部用户
	,
	PLATFORMFORINTERNALUSERS : '01'
	// 辅材商
	,
	AUXILIARYMATERIALL : '30'
	// 工长
	,
	FOREMAN : '50'
	// 加盟商
	,
	FRANCHISEE : '10'
	// 工人
	,
	WORKER : '51'
	// 设计师
	,
	DESIGNER : '40'
	// 超级管理员
	,
	ADMINISTRATORS : '00'

}
/**
 * 付款单状态
 */
var PAYMENT_BILL = {
	// 已支付
	PAID : '01',
	// 未支付
	NONPAYMENT : '00',

}
/**
 * 收款单状态
 */
var RECIPIENT_BILL = {
	// 已支付
	PAID : '02',
	// 待提现
	FORWITHDRAWAL : '00',
	//提现
	WITHDRAW:'01',
	//支付失败
	PAYMENTFAILED:'03'

}
/**
 * 方案类型
 */
var SOLUTION_TYPE = {
	// 主材订单
	ADVOCATEMATERIALORDER : '04',
	//施工合同
	CONSTRUCTIONCONTRACT : '03',
	// 审计图订单
	AUDITFIGUREORDER : '01',
	// 辅材订单
	COMPLEMENTARYMATERIALORDER : '02'

}


/**
 * 合作伙伴状态
 */
var PARTNER_STATUS = {
	// 加盟
	JOIN:'01',
	// 审核不通过
	RELEASE:'00'
}