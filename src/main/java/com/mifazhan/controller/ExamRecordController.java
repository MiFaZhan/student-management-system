package com.mifazhan.controller;

import com.mifazhan.vo.ExamRecordVO;
import com.mifazhan.service.ExamRecordService;
import com.mifazhan.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exam-record")
public class ExamRecordController {

    @Autowired
    private ExamRecordService examRecordService;

    /**
     * 查询所有考试记录
     */
    @GetMapping
    public Result<List<ExamRecordVO>> listExamRecords() {
        return Result.success(examRecordService.listExamRecords());
    }

    /**
     * 根据科目ID查询考试记录
     */
    @GetMapping("/subject/{id}")
    public Result<List<ExamRecordVO>> getExamRecordsBySubjectId(@PathVariable Integer id) {
        return Result.success(examRecordService.getExamRecordsBySubjectId(id));
    }

    /**
     * 根据id查询考试记录
     */
    @GetMapping("/{id}")
    public Result getExamRecordsById(@PathVariable Integer id) {
        return Result.success(examRecordService.getExamRecordsById(id));
    }


    /**
     * 根据出题教师查询考试记录
     */
    @GetMapping("/teacherName")
    public Result<List<ExamRecordVO>> getExamRecordsByTeacherName(@RequestParam String teacherName) {
        return Result.success(examRecordService.getExamRecordsByTeacherName(teacherName));
    }






//    /**
//     * 新增考试记录
//     */
//    @PostMapping("/examRecords")
//    public boolean saveExamRecords(@RequestBody ExamRecords examRecords){
//        if (examRecords == null)
//            return false;
//        return examRecordsService.save(examRecords);
//    }
//
//    /**
//     * 批量新增考试记录
//     */
//    @PostMapping("/batch")
//    public boolean batchInsert(@RequestBody List<ExamRecords> examRecords){
//        if (examRecords == null || examRecords.isEmpty())
//            return false;
//        return examRecordsService.saveBatch(examRecords);
//    }
//
//    /**
//     * 根据id更新考试记录
//     */
//    @PutMapping
//    public boolean updateExamRecordsById(@RequestBody ExamRecords examRecords){
//        return examRecordsService.updateById(examRecords);
//    }
//
//    /**
//     * 根据id删除考试记录
//     */
//    @DeleteMapping("/{id}")
//    public void deleteExamRecords(@PathVariable int id) {
//        examRecordsService.removeById(id);
//    }
}
