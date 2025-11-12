package com.controller;

import com.pojo.ExamRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam-records")
public class ExamRecordsController {
    @Autowired
    private ExamRecordsController examRecordsController;

    @RequestMapping("examrecords-list")
    public List<ExamRecords> getExamRecords(){
        return examRecordsController.getExamRecords();
    }
}
