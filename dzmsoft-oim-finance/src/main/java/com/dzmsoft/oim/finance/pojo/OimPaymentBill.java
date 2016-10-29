package com.dzmsoft.oim.finance.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class OimPaymentBill {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.recipient_id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private String recipientId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.recipient_name
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private String recipientName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.payment_id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private String paymentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.payment_name
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private String paymentName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.payment_time
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private Date paymentTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.amount
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.status
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.order_id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.order_type
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private String orderType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oim_payment_bill.create_time
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.id
     *
     * @return the value of oim_payment_bill.id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.id
     *
     * @param id the value for oim_payment_bill.id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.recipient_id
     *
     * @return the value of oim_payment_bill.recipient_id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public String getRecipientId() {
        return recipientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.recipient_id
     *
     * @param recipientId the value for oim_payment_bill.recipient_id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId == null ? null : recipientId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.recipient_name
     *
     * @return the value of oim_payment_bill.recipient_name
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public String getRecipientName() {
        return recipientName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.recipient_name
     *
     * @param recipientName the value for oim_payment_bill.recipient_name
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName == null ? null : recipientName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.payment_id
     *
     * @return the value of oim_payment_bill.payment_id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.payment_id
     *
     * @param paymentId the value for oim_payment_bill.payment_id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId == null ? null : paymentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.payment_name
     *
     * @return the value of oim_payment_bill.payment_name
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public String getPaymentName() {
        return paymentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.payment_name
     *
     * @param paymentName the value for oim_payment_bill.payment_name
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName == null ? null : paymentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.payment_time
     *
     * @return the value of oim_payment_bill.payment_time
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.payment_time
     *
     * @param paymentTime the value for oim_payment_bill.payment_time
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.amount
     *
     * @return the value of oim_payment_bill.amount
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.amount
     *
     * @param amount the value for oim_payment_bill.amount
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.status
     *
     * @return the value of oim_payment_bill.status
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.status
     *
     * @param status the value for oim_payment_bill.status
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.order_id
     *
     * @return the value of oim_payment_bill.order_id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.order_id
     *
     * @param orderId the value for oim_payment_bill.order_id
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.order_type
     *
     * @return the value of oim_payment_bill.order_type
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.order_type
     *
     * @param orderType the value for oim_payment_bill.order_type
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oim_payment_bill.create_time
     *
     * @return the value of oim_payment_bill.create_time
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oim_payment_bill.create_time
     *
     * @param createTime the value for oim_payment_bill.create_time
     *
     * @mbggenerated Tue Jun 28 23:39:20 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}