package com.mifazhan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.mifazhan.converter.ScoreConverter;
import com.mifazhan.entity.ExamRecord;
import com.mifazhan.entity.Score;
import com.mifazhan.entity.Student;
import com.mifazhan.entity.Subject;
import com.mifazhan.mapper.ScoreMapper;
import com.mifazhan.service.ScoreService;
import com.mifazhan.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【scores(成绩表)】的数据库操作Service实现
* @createDate 2025-11-14 14:44:22
*/
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
    implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private ScoreConverter scoreConverter;

    private MPJLambdaWrapper<Score> buildScoreWrapper() {
        MPJLambdaWrapper wrapper = new MPJLambdaWrapper<Score>()
                .leftJoin(ExamRecord.class,ExamRecord::getExamId, Score::getExamId)
                .leftJoin(Subject.class,Subject::getSubjectId,ExamRecord::getSubjectId)
                .select(Subject::getSubjectName)
                .select(ExamRecord::getExamName)
                .select(ExamRecord::getTeacherName)
                .leftJoin(Student.class, Student::getStudentNumber, Score::getStudentNumber)
                .select(Score::getStudentNumber)
                .select(Student::getStudentName)
                .select(Score::getScore)
//                .select(ExamRecord::getExamStartTime);
                .select("DATE(exam_start_time) as examTime");


        return wrapper;
    }

    @Override
    public List<ScoreVO> listScores() {
        MPJLambdaWrapper<Score> wrapper = buildScoreWrapper();
        List<ScoreVO> list = scoreMapper.selectJoinList(ScoreVO.class, wrapper);
        return list;
    }

    @Override
    public List<ScoreVO> listStudentScores(String studentNumber) {
        MPJLambdaWrapper<Score> wrapper = buildScoreWrapper();
        wrapper.eq(Score::getStudentNumber, studentNumber);
        List<ScoreVO> list = scoreMapper.selectJoinList(ScoreVO.class, wrapper);
        return list;
    }
    
    @Override
    public List<ScoreVO> listStudentScoresByName(String studentName) {
        MPJLambdaWrapper<Score> wrapper = buildScoreWrapper();
        wrapper.eq(Student::getStudentName, studentName);
        List<ScoreVO> list = scoreMapper.selectJoinList(ScoreVO.class, wrapper);
        return list;
    }
}