package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.ExamRecordsMapper;
import com.pojo.ExamRecords;
import com.service.IExamRecordsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamRecordsImpl extends ServiceImpl<ExamRecordsMapper, ExamRecords> implements IExamRecordsService {



    @Override
    public List<ExamRecords> getByTeacherName(String teacherName) {
        LambdaQueryWrapper<ExamRecords> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExamRecords::getTeacherName, teacherName);
        return this.list(queryWrapper);
    }
}
