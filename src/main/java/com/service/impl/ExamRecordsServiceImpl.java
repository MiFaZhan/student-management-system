package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.ExamRecords;
import com.service.ExamRecordsService;
import com.mapper.ExamRecordsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【exam_records(考试记录表)】的数据库操作Service实现
* @createDate 2025-11-14 14:44:22
*/
@Service
public class ExamRecordsServiceImpl extends ServiceImpl<ExamRecordsMapper, ExamRecords>
    implements ExamRecordsService{

    @Override
    public List<ExamRecords> getByTeacherName(String teacherName) {
        LambdaQueryWrapper<ExamRecords> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExamRecords::getTeacherName, teacherName);
        return this.list(queryWrapper);
    }

}




