package com.dzmsoft.oim.base.test.common;

import org.junit.Test;

import com.dzmsoft.framework.base.util.security.ca.ExportCertFormKeystore;

public class DbTest {

    @Test
    public void genPassword_test(){
        String userpwd = "bwjfims";
        String jarPath = "D:/Program Files (x86)/apache-maven-3.1.1/repository/com/alibaba/druid/1.0.16/druid-1.0.16.jar";
        new ExportCertFormKeystore().genDruidPwd(userpwd,jarPath);
    }
}
