package cn.worth.oauth2;

import cn.worth.common.annotation.CurrentUser;
import cn.worth.core.domain.LoginUser;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@ComponentScan("cn.worth")
@RestController
@SpringBootApplication()
public class OAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class, args);
    }

    @RequestMapping("getNum")
    public Integer getNum(@CurrentUser LoginUser user, Integer num, Date now){
        log.info(JSON.toJSONString(user));
        return num + 1;
    }
}
