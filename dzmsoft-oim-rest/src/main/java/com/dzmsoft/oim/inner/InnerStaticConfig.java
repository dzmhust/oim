package com.dzmsoft.oim.inner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InnerStaticConfig {
    /**
     * 配置中心上下文
     */
    private static String ccs_ctx;

    public static String getCcs_ctx() {
        return ccs_ctx;
    }

    @Value("${ccs_ctx}")
    public  void setCcs_ctx(String ccs_ctx) {
        InnerStaticConfig.ccs_ctx = ccs_ctx;
    }

}
