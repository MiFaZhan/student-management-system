package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pojo.ExamRecords;

import java.util.List;

public interface IExamRecordsService extends IService<ExamRecords> {

    List<ExamRecords> getByTeacherName(String teacherName);
}
