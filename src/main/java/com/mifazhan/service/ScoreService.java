package com.mifazhan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mifazhan.entity.Score;
import com.mifazhan.vo.ScoreVO;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【scores(成绩表)】的数据库操作Service
* @createDate 2025-11-14 14:44:22
*/
public interface ScoreService extends IService<Score> {

    List<ScoreVO> listScores();

    List<ScoreVO> listStudentScores(String studentNumber);

    List<ScoreVO> listStudentScoresByName(String studentName);
}
