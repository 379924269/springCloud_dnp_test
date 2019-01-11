//package com.dnp.service.zuul.service;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.dnp.service.zuul.modular.autoCode.entity.Role;
//import com.dnp.service.zuul.modular.autoCode.entity.User;
//import com.dnp.service.zuul.modular.autoCode.service.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class SecurityUser extends User implements UserDetails
//{
//
//    @Autowired
//    RoleService roleService;
//
//    private static final long serialVersionUID = 1L;
//    public SecurityUser(User user) {
//        if(user != null)
//        {
//            this.setId(user.getId());
//            this.setName(user.getName());
//            this.setPassword(user.getPassword());
//            this.setSex(user.getSex());
//        }
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("id", getId());
//        List<Role> roles = roleService.list(queryWrapper);
//        if(roles != null)
//        {
//            for (Role role : roles) {
//                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
//                authorities.add(authority);
//            }
//        }
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return super.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return super.getName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}
