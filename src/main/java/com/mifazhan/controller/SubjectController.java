package com.mifazhan.controller;

import com.mifazhan.service.SubjectService;
import com.mifazhan.vo.Result;
import com.mifazhan.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询所有课程
     * @return
     */
    @GetMapping
    public Result<List<SubjectVO>> getSubject() {
        return Result.success(subjectService.getSubject());
    }

    /**
     * 根据id查询课程
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getSubjectById(@PathVariable String id) {
        return Result.success(subjectService.getById(id));
    }

}
