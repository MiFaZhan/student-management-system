package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Students;
import com.mapper.StudentsMapper;
import com.service.StudentsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【students(学生表)】的数据库操作Service实现
* @createDate 2025-11-14 14:44:22
*/
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students>
    implements StudentsService{

    @Override
    public List<Students> getByStuName(String studentName) {
        LambdaQueryWrapper<Students> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Students::getStudentName, studentName);
        return this.list(queryWrapper);
    }
}




