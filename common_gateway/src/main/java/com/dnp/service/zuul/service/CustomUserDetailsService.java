//package com.dnp.service.zuul.service;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.dnp.service.zuul.modular.autoCode.entity.User;
//import com.dnp.service.zuul.modular.autoCode.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    private UserService userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("username" , userName);
//        User user = userRepository.getOne(queryWrapper);
//        if (user == null) {
//            throw new UsernameNotFoundException("UserName " + userName + " not found");
//        }
//        return new SecurityUser(user);
//    }
//}
