package com.dzmsoft.oim.base.common;

public abstract class OimBaseConstant {
    /**
     * 员工状态
     * @author dzm
     */
    public interface EmployeeStatus{
        /**
         * 在岗
         */
        public static final String IN_JOB = "01";
        /**
         * 离职
         */
        public static final String OUT_JOB = "00";
    }
    
    /**
     * APK状态
     * @author dzm
     */
    public interface ApkStatus{
        /**
         * 初始
         */
        public static final String INIT = "00";
        /**
         * 上线
         */
        public static final String ONLINE="01";
        /**
         * 删除
         */
        public static final String DELETE="02";
        /**
         * 下线
         */
        public static final String OFFLINE="03";
    }
    
    /**
     * 合作伙伴状态
     * @author dzm
     */
    public interface PartnerStatus{
        /**
         * 加盟
         */
        public static final String JOIN = "01";
        /**
         * 解约
         */
        public static final String RELEASE = "00";
    }
}
