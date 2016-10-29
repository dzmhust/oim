package com.dzmsoft.oim.base.test.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.dzmsoft.framework.base.util.security.EncodesUtil;

public class HexTest {
    
    @Test
    public void test_hex() throws NoSuchAlgorithmException{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update("123456".getBytes());
        byte[] m = md5.digest();
        
        System.out.println(EncodesUtil.encodeHex(m));
        System.out.println(bytesToHex(m));
                
    }

    public String bytesToHex(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        int len = bytes.length;
        for (int j = 0; j < len; j++) {
            if ((bytes[j] & 0xff) < 16) {
                buff.append('0');
            }
            buff.append(Integer.toHexString(bytes[j] & 0xff));
        }
        return buff.toString();
    }
    
    @Test
    public void length_test(){
        System.out.print("266d873943719dca1603ffb6".length());
        System.out.print("237a8d79ae1954101344ce87".length());
    }
}
