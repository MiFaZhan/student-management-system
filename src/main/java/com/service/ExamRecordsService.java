package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dto.ExamRecordDTO;
import com.entity.ExamRecord;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【exam_records(考试记录表)】的数据库操作Service
* @createDate 2025-11-14 14:44:22
*/
public interface ExamRecordsService extends IService<ExamRecord> {
    /**
     * 查询所有考试记录
     * @return 考试记录DTO列表
     */
    List<ExamRecordDTO> getAllExamRecords();

    List<ExamRecordDTO> getExamRecordsBySubjectId(Integer subjectId);

    List<ExamRecordDTO> getByTeacherName(String teacherName);

    ExamRecordDTO getExamRecordsById(Integer id);
}
