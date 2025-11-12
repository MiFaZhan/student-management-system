package com.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pojo.Students;

import java.util.List;

public interface IStudentsService extends IService<Students> {
    List<Students> findByName(String stuName);
}
