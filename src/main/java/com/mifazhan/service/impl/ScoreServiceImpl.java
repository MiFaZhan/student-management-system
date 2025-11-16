package com.mifazhan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.mifazhan.converter.ScoreConverter;
import com.mifazhan.entity.ExamRecord;
import com.mifazhan.entity.Score;
import com.mifazhan.entity.Student;
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
                .select(Score::getScoreId)
                .leftJoin(Student.class, Student::getStudentName, Score::getStudentNumber)
                .select(Score::getStudentNumber)
                .leftJoin(ExamRecord.class,ExamRecord::getExamId, Score::getExamId)
                .select(ExamRecord::getExamName)
//                .leftJoin(Subject.class, ExamRecord::getSubjectId, Subject::getSubjectId)
//                .select(Subject::getSubjectName)
                .select(ExamRecord::getTeacherName)
                .select(Score::getScore)
                .select(ExamRecord::getExamStartTime);

        return wrapper;
    }

    @Override
    public List<ScoreVO> listScores() {
        MPJLambdaWrapper<Score> wrapper = buildScoreWrapper();
        List<ScoreVO> list = scoreMapper.selectJoinList(ScoreVO.class, wrapper);
        return list;

//        List<Score> list = this.list();
//        return scoreConverter.toVOList(list);
    }
}




