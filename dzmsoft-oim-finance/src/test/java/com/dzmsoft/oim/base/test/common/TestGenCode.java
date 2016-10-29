package com.dzmsoft.oim.base.test.common;

import org.junit.Test;

import com.dzmsoft.framework.base.util.StringUtil;
import com.dzmsoft.framework.gencode.common.GenCodeConstant;
import com.dzmsoft.framework.gencode.handle.GenCodeHandler;
import com.dzmsoft.framework.gencode.param.GenCodeCfg;
import com.dzmsoft.framework.gencode.param.VmParams;
import com.dzmsoft.framework.gencode.param.dto.JDBCConnectionConfiguration;
import com.dzmsoft.framework.gencode.param.dto.StrategyType;
import com.dzmsoft.oim.finance.pojo.OimPaymentBill;
import com.dzmsoft.oim.finance.pojo.OimRecipientBill;

public class TestGenCode {

	
    public JDBCConnectionConfiguration getJdbcConfig() {
        JDBCConnectionConfiguration config = new JDBCConnectionConfiguration();
        config.setConnectionURL("jdbc:mysql://localhost:3306/walle");
        config.setDriverClass("com.mysql.jdbc.Driver");
        config.setUserId("root");
        config.setPassword("root");
        return config;
    }

    //js文件地址
    private static final String jsPath = "F:/dzmsoftwork/dzmsoft-oim/src/main/webapp/resources/pages/modules";
    //jsp文件地址
    private static final String jspPath = "F:/dzmsoftwork/dzmsoft-oim/src/main/webapp/WEB-INF/views/modules";
    //service和controller的所在包名
    private static final String packagePath = "com.dzmsoft.oim.finance";
    //生成js和jsp文件时的文件夹名
    private static final String modulePath = "finance";
    
    @Test
    public void genCommon(){
        // 模板参数
        VmParams vmParams = new VmParams.Builder()
            .setJsPath(jsPath).setJspPath(jspPath).setModulePath(modulePath).setPackagePath(packagePath)
            .setJdbcConfig(getJdbcConfig())
            .addBeanName(OimPaymentBill.class.getName())
            .addBeanName(OimRecipientBill.class.getName())
//            .addExtra(GenCodeConstant.EXTRA_ENABLE_DISABLE, true)
//            .addExtra(GenCodeConstant.EXTRA_TAB_RICHTEXT, true)
            .build();
        // 生成代码的配置
        GenCodeCfg genCodeCfg = new GenCodeCfg.Builder()
            .setStrategyType(StrategyType.Common)
            .setVmParams(vmParams)
            .addAllFlat()
//            .addCodeType(CodeType.FlatController)
//            .addCodeType(CodeType.FlatService)
//            .addCodeType(CodeType.FlatServiceImpl)
//            .addCodeType(CodeType.FlatListJs)
//            .addCodeType(CodeType.FlatFormJsp)
            .build();
        // 生成代码
        GenCodeHandler handler = GenCodeHandler.getInstance();
        handler.genCode(genCodeCfg);
    }
    


}
