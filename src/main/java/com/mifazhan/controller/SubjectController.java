package com.mifazhan.controller;

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
     * @return
     */
    @GetMapping
    public Result<List<SubjectVO>> listSubject() {
        return Result.success(subjectService.getSubject());
    }

    /**
     * 根据id查询课程
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getSubjectById(@PathVariable Integer id) {
        return Result.success(subjectService.getSubjectById(id));
    }

    /**
     * 根据名称查询课程
     * @param name
     * @return
     */
    @GetMapping("/name")
    public Result getSubjectByName(@RequestParam String name) {
        return Result.success(subjectService.getSubjectByName(name));
    }

    /**
     * 新增课程
     * @param subjectVO
     * @return
     */
//    @PostMapping
//    public Result insertSubject(@RequestBody SubjectVO subjectVO) {
//        return Result.success(subjectService.save(subjectVO));
//    }

}
