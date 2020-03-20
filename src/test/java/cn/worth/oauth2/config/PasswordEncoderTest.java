package cn.worth.oauth2.config;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author myireland
 * @version 1.0.0
 * @date 2019-08-01
 * @description
 **/
public class PasswordEncoderTest {

    @Test
    public void testEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }

}
