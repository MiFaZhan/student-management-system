package com.controller;

import com.service.ExamRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private ExamRecordsService examRecordsService;

    /**
     * 查询所有课程
     */
//    public SubjectDTO

}
