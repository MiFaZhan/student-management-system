package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.ExamRecordsMapper;
import com.pojo.ExamRecords;
import com.service.IExamRecordsService;
import org.springframework.stereotype.Service;

@Service
public class ExamRecordsImpl extends ServiceImpl<ExamRecordsMapper, ExamRecords> implements IExamRecordsService {

}
