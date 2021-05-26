package com.module.web.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.module.common.exception.ApiException;
import com.module.generate.mapper.SysUserMapper;
import com.module.generate.model.SysUser;
import com.module.web.service.UserService;
import com.module.web.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/5/6 10:12
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper ;

    @Override
    public Integer register(UserVo vo) {
        SysUser sysUser = new SysUser();
        sysUser.setLoginName(vo.getName());
        sysUser.setLoginPassword(vo.getPassword());
        sysUser.setCreateTime(LocalDateTime.now());
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public Object selectUsers(Integer pageNum ,Integer pageSize) {
        IPage<SysUser> page = new Page<>(pageNum, pageSize);
        IPage<SysUser> sysUserIPage = sysUserMapper.selectPage(page, null);
        return sysUserIPage;
    }
}
