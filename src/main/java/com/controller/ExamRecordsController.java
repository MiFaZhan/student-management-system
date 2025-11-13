package com.controller;

import com.pojo.ExamRecords;
import com.service.IExamRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam-records")
public class ExamRecordsController {
    @Autowired
    private IExamRecordsService examRecordsService;

    /**
     * 查询所有考试记录
     */
    @GetMapping
    public List<ExamRecords> getExamRecords() {
        return examRecordsService.list();
    }

    /**
     * 插入数据
     */
    @PostMapping("/examRecords")
    public void saveExamRecords(@RequestBody ExamRecords examRecords){
        examRecordsService.save(examRecords);
    }

    /**
     * 根据id删除考试记录
     */
    @DeleteMapping("/{id}")
    public void deleteExamRecords(@PathVariable int id) {
        examRecordsService.removeById(id);
    }
}
