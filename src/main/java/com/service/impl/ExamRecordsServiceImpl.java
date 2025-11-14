package com.service.impl;

import com.dto.ExamRecordDTO;
import com.entity.ExamRecords;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.mapper.ExamRecordsMapper;
import com.service.ExamRecordsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【exam_records(考试记录表)】的数据库操作Service实现
* @createDate 2025-11-14 14:44:22
*/
@Service
public class ExamRecordsServiceImpl extends MPJBaseServiceImpl<ExamRecordsMapper, ExamRecords>
    implements ExamRecordsService{

    /**
     * 构建考试记录查询条件
     * @return 查询条件包装器
     */
    private MPJLambdaWrapper<ExamRecords> buildExamRecordWrapper() {
        MPJLambdaWrapper<ExamRecords> wrapper = new MPJLambdaWrapper<ExamRecords>()
                .select(ExamRecords::getExamId)
                .select(ExamRecords::getExamName)
                .select(ExamRecords::getTeacherName)
                .select(ExamRecords::getExamStartTime)
                .select(ExamRecords::getExamEndTime)
                // 子查询统计成绩人数
                .select("(SELECT COUNT(*) FROM scores WHERE scores.exam_id = t.exam_id AND scores.deleted = 0) AS participantCount")
                .eq(ExamRecords::getDeleted, 0)
                .orderByAsc(ExamRecords::getExamStartTime);
        
        return wrapper;
    }

    /**
     * 查询所有考试记录
     */
    @Override
    public List<ExamRecordDTO> getAllExamRecords() {
        MPJLambdaWrapper<ExamRecords> wrapper = buildExamRecordWrapper();
        return this.selectJoinList(ExamRecordDTO.class, wrapper);
    }

    /**
     * 根据课程id查询考试记录
     */
    @Override
    public List<ExamRecordDTO> getExamRecordsBySubjectId(Integer subjectId) {
        MPJLambdaWrapper<ExamRecords> wrapper = buildExamRecordWrapper();
        wrapper.eq(ExamRecords::getSubjectId, subjectId);
        return this.selectJoinList(ExamRecordDTO.class, wrapper);
    }

    /**
     * 根据出题教师查询考试记录
     */
    @Override
    public List<ExamRecordDTO> getByTeacherName(String teacherName) {
        MPJLambdaWrapper<ExamRecords> wrapper = buildExamRecordWrapper();
        wrapper.eq(ExamRecords::getTeacherName, teacherName);
        return this.selectJoinList(ExamRecordDTO.class, wrapper);
    }

    /**
     * 根据id查询考试记录
     */
    @Override
    public ExamRecordDTO getExamRecordsById(Integer id) {
        MPJLambdaWrapper<ExamRecords> wrapper = buildExamRecordWrapper();
        wrapper.eq(ExamRecords::getExamId, id);
        return this.selectJoinOne(ExamRecordDTO.class, wrapper);
    }
}




