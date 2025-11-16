package com.mifazhan.controller;

import com.mifazhan.service.ScoreService;
import com.mifazhan.vo.Result;
import com.mifazhan.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**
     * 查询所有学生成绩
     */
    @GetMapping
    public Result<List<ScoreVO>> listScores() {
        return Result.success(scoreService.listScores());
    }

}
