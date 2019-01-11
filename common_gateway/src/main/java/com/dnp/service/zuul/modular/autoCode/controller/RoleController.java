package com.dnp.service.zuul.modular.autoCode.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.dnp.service.zuul.modular.autoCode.entity.Role;
import com.dnp.service.zuul.modular.autoCode.service.RoleService;
import com.dnp.service.zuul.modular.autoCode.vo.PageVo;

/**
 * <p>
 * 角色  前端控制器
 * </p>
 * @author huazai
 * @since 2018-11-13
 */
@Api(value = "RoleController", description = "角色")
@RestController
@RequestMapping(value = "/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleController {
@Autowired private RoleService roleService;

@RequestMapping(value = "", method = RequestMethod.GET)
@ApiOperation(value = "查询所有角色", notes = "查询所有角色")
public Object findAll(PageVo pageVo,
@ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search){
        return null;
        }


@RequestMapping(value = "/{id}", method = RequestMethod.GET)
@ApiOperation(value = "查询角色详情", notes = "查询角色详情", httpMethod = "GET" )
public Role findById(@ApiParam(name = "id", value = "角色id", required = true) @PathVariable("id") Integer id){
        return roleService.getById(id);
        }

@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
@ApiOperation(value = "修改角色", notes = "修改角色")
public void updateById(Role role){
    roleService.saveOrUpdate(role);
        }

@RequestMapping(value = "", method = RequestMethod.POST)
@ApiOperation(value = "添加角色", notes = "添加角色")
public void save(

             @ApiParam(name = "name", value = "角色名")
    @RequestParam(required = false, name = "name" ) String name
                        ,
                 @ApiParam(name = "seq", value = "排序号")
    @RequestParam(required = false, name = "seq" ) Integer seq
                        ,
                 @ApiParam(name = "description", value = "简介")
    @RequestParam(required = false, name = "description" ) String description
                        ,
                 @ApiParam(name = "status", value = "状态")
    @RequestParam(required = false, name = "status" ) Integer status
                    ){
Role role =new Role(

        name,    seq,    description,    status        );
roleService.save(role);
        }

@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
@ApiOperation(value = "删除角色", notes = "修改角色")
public void deleteById(@ApiParam(name = "id", value = "角色id", required = true) @PathVariable("id") Integer id){
    roleService.removeById(id);
        }

        }
