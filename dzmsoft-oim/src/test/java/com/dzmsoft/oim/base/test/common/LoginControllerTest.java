package com.dzmsoft.oim.base.test.common;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.dzmsoft.framework.base.util.HttpUtil;

public class LoginControllerTest {

    @Test
    public void login_test(){
        String uri = "http://192.168.4.187:8096/hio/login";
        //
        Map<String,String> params = new HashMap<String,String>();
        params.put("username", "0001");
//        params.put("password", DigestsUtil.md2Hex(DigestsUtil.md2Hex("__ORIG_VAL__.")));
        params.put("captcha", "1234");
        String result = HttpUtil.doPost(uri, params);
        System.out.println(result);
    }
}
