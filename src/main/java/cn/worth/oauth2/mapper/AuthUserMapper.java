package cn.worth.oauth2.mapper;

import cn.worth.common.v2.domain.LoginUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author myireland
 * @version 1.0.0
 * @date 2019-08-01
 * @description
 **/
@Mapper
public interface AuthUserMapper extends BaseMapper<cn.worth.oauth2.domain.AuthUser> {
    LoginUser loadUserByUsername(cn.worth.oauth2.domain.AuthUser userQuery);
}

