package com.mifazhan.service.impl;

import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.mifazhan.converter.ExamRecordConverter;
import com.mifazhan.entity.ExamRecord;
import com.mifazhan.mapper.ExamRecordMapper;
import com.mifazhan.service.ExamRecordService;
import com.mifazhan.vo.ExamRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【exam_record(考试记录表)】的数据库操作Service实现
* @createDate 2025-11-14 14:44:22
*/
@Service
public class ExamRecordServiceImpl extends MPJBaseServiceImpl<ExamRecordMapper, ExamRecord>
    implements ExamRecordService {

    @Autowired
    private ExamRecordMapper examRecordMapper;

    @Autowired
    private ExamRecordConverter examRecordConverter;


    /**
     * 构建考试记录查询条件
     * @return 查询条件包装器
     */
    private MPJLambdaWrapper<ExamRecord> buildExamRecordWrapper() {
        MPJLambdaWrapper<ExamRecord> wrapper = new MPJLambdaWrapper<ExamRecord>()
                .select(ExamRecord::getExamId)
                .select(ExamRecord::getExamName)
                .select(ExamRecord::getTeacherName)
                .select(ExamRecord::getExamStartTime)
                .select(ExamRecord::getExamEndTime)
                // 子查询统计成绩人数
                .select("(SELECT COUNT(*) FROM score WHERE score.exam_id = t.exam_id AND score.deleted = 0) AS participantCount")
                .eq(ExamRecord::getDeleted, 0)
                .orderByAsc(ExamRecord::getExamStartTime);
        
        return wrapper;
    }

    /**
     * 查询所有考试记录
     */
    @Override
    public List<ExamRecordVO> getAllExamRecords() {
        MPJLambdaWrapper<ExamRecord> wrapper = buildExamRecordWrapper();
        List<ExamRecordVO> examRecords = examRecordMapper.selectJoinList(ExamRecordVO.class, wrapper);
        return examRecords;
    }

    /**
     * 根据课程id查询考试记录
     */
    @Override
    public List<ExamRecordVO> getExamRecordsBySubjectId(Integer subjectId) {
        MPJLambdaWrapper<ExamRecord> wrapper = buildExamRecordWrapper();
        wrapper.eq(ExamRecord::getSubjectId, subjectId);
        return this.selectJoinList(ExamRecordVO.class, wrapper);
    }

    /**
     * 根据出题教师查询考试记录
     */
    @Override
    public List<ExamRecordVO> getByTeacherName(String teacherName) {
        MPJLambdaWrapper<ExamRecord> wrapper = buildExamRecordWrapper();
        wrapper.eq(ExamRecord::getTeacherName, teacherName);
        return this.selectJoinList(ExamRecordVO.class, wrapper);
    }

    /**
     * 根据id查询考试记录
     */
    @Override
    public ExamRecordVO getExamRecordsById(Integer id) {
        MPJLambdaWrapper<ExamRecord> wrapper = buildExamRecordWrapper();
        wrapper.eq(ExamRecord::getExamId, id);
        return this.selectJoinOne(ExamRecordVO.class, wrapper);
    }
}




