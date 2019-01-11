package com.dnp.service.zuul.modular.autoCode.service.impl;

import com.dnp.service.zuul.modular.autoCode.entity.User;
import com.dnp.service.zuul.modular.autoCode.dao.UserMapper;
import com.dnp.service.zuul.modular.autoCode.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author huazai
 * @since 2018-11-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
