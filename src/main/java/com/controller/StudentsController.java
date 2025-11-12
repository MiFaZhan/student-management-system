package com.controller;

import com.pojo.Students;
import com.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private IStudentsService studentsService;


    /**
     *查询所有学生
     */
    @GetMapping("/list")
    public List<Students> getAllStudents() {
        return studentsService.list();
    }

    /**
     *根据ID查询学生
     */
    @GetMapping("/{stuId}")
    public Students getStudentById(@PathVariable String stuId) {
        return studentsService.getById(stuId);
    }

    /**
     * 根据id批量查询学生信息
     */
    @PostMapping("/ids")
    public List<Students> getStudentsByIds(@RequestBody List<Integer> studentIds) {
        return studentsService.listByIds(studentIds);
    }

    /**
     * 根据姓名查询学生信息
     */
    @GetMapping("/search")
    public List<Students> searchStudentsByName(@RequestParam String stuName) {
        return studentsService.findByName(stuName);
    }


    /**
     * 插入学生信息
     */
    @PostMapping
    public void insertion(@RequestBody Students student) {
        studentsService.save(student);
    }

//    /**
//     * 批量插入学生信息
//     */
//    @PostMapping("/batch")
//    public void batchInsertion(@RequestBody List<Students> students) {
//        studentsService.saveBatch(students);
//    }

    /**
     * 根据id更新学生表信息
     */
    @PutMapping
    public void updateById(@RequestBody Students student) {
        studentsService.updateById(student);
    }

    /**
     * 根据id删除学生信息
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String stuId){
        studentsService.removeById(stuId);
    }
}