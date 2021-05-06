package com.module.web.service.impl;

import com.module.generate.mapper.SysUserMapper;
import com.module.generate.model.SysUser;
import com.module.web.service.UserService;
import com.module.web.vo.UserVo;
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
}
