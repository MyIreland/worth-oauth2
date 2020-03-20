package cn.worth.oauth2.service.impl;

import cn.worth.common.utils.CollectionUtils;
import cn.worth.common.v2.domain.LoginUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private String realName;
    private String email;
    private Long tenantId;
    private Integer status;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 角色码
     */
    private Set<String> roleCodes;
    /**
     * 按钮权限码
     */
    private Set<String> perms;
    /**
     * 菜单权限码
     */
    private Set<String> menus;

    public UserDetailsImpl(LoginUser authUser) {
        this.id = authUser.getId();
        this.username = authUser.getUsername();
        this.realName = authUser.getRealName();
        this.password = authUser.getPassword();
        this.email = authUser.getEmail();
        this.avatar = authUser.getAvatar();
        this.tenantId = authUser.getTenantId();
        this.status = authUser.getStatus();
        this.roleCodes = authUser.getRoleCodes();
        this.perms = authUser.getPerms();
        this.menus = authUser.getMenus();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        if (CollectionUtils.isNotEmpty(roleCodes)) {
            roleCodes.forEach(role -> collection.add(new SimpleGrantedAuthority(role)));
        }
        return collection;
    }

    public Set<String> getPerms() {
        return perms;
    }

    public void setPerms(Set<String> perms) {
        this.perms = perms;
    }

    public Set<String> getMenus() {
        return menus;
    }

    public void setMenus(Set<String> menus) {
        this.menus = menus;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<String> getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(Set<String> roleCodes) {
        this.roleCodes = roleCodes;
    }

}