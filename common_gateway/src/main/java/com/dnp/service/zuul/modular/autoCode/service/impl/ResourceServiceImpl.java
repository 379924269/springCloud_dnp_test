package com.dnp.service.zuul.modular.autoCode.service.impl;

import com.dnp.service.zuul.modular.autoCode.entity.Resource;
import com.dnp.service.zuul.modular.autoCode.dao.ResourceMapper;
import com.dnp.service.zuul.modular.autoCode.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源 服务实现类
 * </p>
 *
 * @author huazai
 * @since 2018-11-13
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

}
