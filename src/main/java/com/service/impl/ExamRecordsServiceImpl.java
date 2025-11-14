package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    @Override
    public List<ExamRecordDTO> getExamRecordsBySubjectId(Integer subjectId) {

        MPJLambdaWrapper<ExamRecords> wrapper = new MPJLambdaWrapper<ExamRecords>()
                .select(ExamRecords::getExamId)
                .select(ExamRecords::getExamName)
                .select(ExamRecords::getTeacherName)
                .select(ExamRecords::getExamStartTime)
                .select(ExamRecords::getExamEndTime)

                // 子查询统计成绩人数
                .select("(SELECT COUNT(*) FROM scores WHERE scores.exam_id = t.exam_id AND scores.deleted = 0) AS participantCount")

                .eq(ExamRecords::getSubjectId, subjectId)
                .eq(ExamRecords::getDeleted, 0)
                .orderByAsc(ExamRecords::getExamStartTime);

        return this.selectJoinList(ExamRecordDTO.class, wrapper);
    }

    // 根据教师姓名查询考试记录
    @Override
    public List<ExamRecords> getByTeacherName(String teacherName) {
        LambdaQueryWrapper<ExamRecords> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExamRecords::getTeacherName, teacherName);
        return this.list(queryWrapper);
    }

}




