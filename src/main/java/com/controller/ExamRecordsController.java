package com.controller;

import com.dto.ExamRecordDTO;
import com.entity.ExamRecords;
import com.service.ExamRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam-records")
public class ExamRecordsController {

    @Autowired
    private ExamRecordsService examRecordsService;

    /**
     * 根据科目ID查询考试记录
     */
    @GetMapping("/subject/{subjectId}")
    public List<ExamRecordDTO> getBySubject(@PathVariable Integer subjectId) {
        return examRecordsService.getExamRecordsBySubjectId(subjectId);
    }

    /**
     * 查询所有考试记录
     */
    @GetMapping
    public List<ExamRecords> getExamRecords() {
        return examRecordsService.list();
    }

    /**
     * 根据id查询考试记录
     */
    @GetMapping("/{id}")
    public ExamRecords getExamRecordsById(@PathVariable Integer id) {
        return examRecordsService.getById(id);
    }


    /**
     * 根据老师查询考试记录
     */
    @GetMapping("/teacherName")
    public List<ExamRecords> getExamRecordsByTeacherName(@RequestParam String teacherName) {
        return examRecordsService.getByTeacherName(teacherName);
    }

    /**
     * 新增考试记录
     */
    @PostMapping("/examRecords")
    public boolean saveExamRecords(@RequestBody ExamRecords examRecords){
        if (examRecords == null)
            return false;
        return examRecordsService.save(examRecords);
    }

    /**
     * 批量新增考试记录
     */
    @PostMapping("/batch")
    public boolean batchInsert(@RequestBody List<ExamRecords> examRecords){
        if (examRecords == null || examRecords.isEmpty())
            return false;
        return examRecordsService.saveBatch(examRecords);
    }

    /**
     * 根据id更新考试记录
     */
    @PutMapping
    public boolean updateExamRecordsById(@RequestBody ExamRecords examRecords){
        return examRecordsService.updateById(examRecords);
    }

    /**
     * 根据id删除考试记录
     */
    @DeleteMapping("/{id}")
    public void deleteExamRecords(@PathVariable int id) {
        examRecordsService.removeById(id);
    }
}
