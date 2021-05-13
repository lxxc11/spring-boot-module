package com.module.web.service;

import com.module.web.vo.UserVo;

public interface UserService {
    Integer register(UserVo vo);

    Object selectUsers(Integer pageNum ,Integer pageSize);
}
