package com.mifazhan.controller;

import com.mifazhan.dto.SubjectDTO;
import com.mifazhan.service.SubjectService;
import com.mifazhan.vo.Result;
import com.mifazhan.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询所有课程
     */
    @GetMapping
    public Result<List<SubjectVO>> listSubject() {
        return Result.success(subjectService.getSubject());
    }

    /**
     * 根据id查询课程
     */
    @GetMapping("/{id}")
    public Result getSubjectById(@PathVariable Integer id) {
        return Result.success(subjectService.getSubjectById(id));
    }

    /**
     * 根据名称查询课程
     */
    @GetMapping("/name")
    public Result getSubjectByName(@RequestParam String name) {
        return Result.success(subjectService.getSubjectByName(name));
    }

    /**
     * 新增课程
     */
    @PostMapping
    public Result insertSubject(@RequestBody SubjectDTO subjectDTO) {
        return Result.success(subjectService.insertSubject(subjectDTO));
    }

    /**
     * 批量新增课程
     */

}
