package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.ExamRecordDTO;
import com.entity.ExamRecords;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【exam_records(考试记录表)】的数据库操作Service
* @createDate 2025-11-14 14:44:22
*/
public interface ExamRecordsService extends IService<ExamRecords> {
    List<ExamRecordDTO> getExamRecordsBySubjectId(Integer subjectId);

    List<ExamRecords> getByTeacherName(String teacherName);
}
