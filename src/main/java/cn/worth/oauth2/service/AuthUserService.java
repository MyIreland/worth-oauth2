package cn.worth.oauth2.service;


import cn.worth.oauth2.domain.AuthUser;
import cn.worth.oauth2.domain.LoginUser;
import com.baomidou.mybatisplus.extension.service.IService;

public interface AuthUserService extends IService<AuthUser> {
    /**
     * 通过用户名查询用户、角色信息
     *
     * @param username 用户名
     * @return UserVo
     */
    LoginUser findUserByUsername(String username);
}