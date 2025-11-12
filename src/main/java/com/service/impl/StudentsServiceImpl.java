package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pojo.Students;
import com.mapper.StudentsMapper;
import com.service.IStudentsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements IStudentsService {
    @Override
    public List<Students> findByStuName(String stuName) {
        LambdaQueryWrapper<Students> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Students::getStuName, stuName);
        return this.list(wrapper);
    }

    @Override
    public boolean deleteStuById(Integer id) {
        return baseMapper.deleteById(id) > 0;
    }
}
