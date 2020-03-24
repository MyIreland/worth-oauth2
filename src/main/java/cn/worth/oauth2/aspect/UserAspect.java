package cn.worth.oauth2.aspect;

import cn.worth.common.constant.SecurityConstants;
import cn.worth.oauth2.utils.UserUtils;
import com.xiaoleilu.hutool.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class UserAspect {

    @Pointcut("execution(public cn.worth.common.domain.R *(..))")
    public void pointCutUser() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp 切点 所有返回对象R
     * @return R  结果包装
     */
    @Around("pointCutUser()")
    public Object methodUserHandler(ProceedingJoinPoint pjp) throws Throwable {
        return methodHandler(pjp);
    }


    private Object methodHandler(ProceedingJoinPoint pjp) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String username = request.getHeader(SecurityConstants.USER_HEADER);
        if (StrUtil.isNotBlank(username)) {
            log.info("Controller AOP get username:{}", username);
            UserUtils.setUser(username);
        }
        Object result = pjp.proceed();

        if (StrUtil.isNotEmpty(username)) {
            UserUtils.clearAllUserInfo();
        }

        return result;
    }
}