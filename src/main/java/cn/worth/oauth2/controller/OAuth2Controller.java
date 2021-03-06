package cn.worth.oauth2.controller;

import cn.worth.common.annotation.CurrentUser;
import cn.worth.common.domain.R;
import cn.worth.core.domain.LoginUser;
import cn.worth.oauth2.utils.AuthUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author myireland
 * @version 1.0.0
 * @date 2019-08-15
 * @description
 **/
@RestController
@RequestMapping("/oauth")
public class OAuth2Controller {

//    @Resource
//    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/currentUser")
    public R currentUser(@CurrentUser LoginUser loginUser){
        return R.success(loginUser);
    }

//    @PostMapping("/logout")
//    public R logout(HttpServletRequest request){
//        String accessToken = AuthUtils.getBearerToken(request);
//        if(StringUtils.isNotBlank(accessToken)){
//            consumerTokenServices.revokeToken(accessToken);
//        }
//        return R.success("");
//    }
}
