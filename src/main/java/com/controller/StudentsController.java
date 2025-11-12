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
    @GetMapping("/students-list")
    public List<Students> getAllStudents() {
        return studentsService.list();
    }


    /**
     *根据ID查询学生
     */
    @GetMapping("/{stuId}")
    public Students getStudentById(@PathVariable Integer stuId) {
        return studentsService.getById(stuId);
    }


    /**
     * 根据id批量查询学生信息
     */
    @PostMapping("/studentIds")
    public List<Students> getStudentsByIds(@RequestBody List<Integer> stuIds) {
        return studentsService.listByIds(stuIds);
    }


    /**
     * 根据姓名查询学生信息
     */
    @GetMapping("/stuName")
    public List<Students> searchStudentsByName(@RequestParam String stuName) {
        return studentsService.findByStuName(stuName);
    }


    /**
     * 插入学生信息
     */
    @PostMapping
    public void insertion(@RequestBody Students student) {
        studentsService.save(student);
    }


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
    @DeleteMapping("/{stuId}")
    public void deleteById(@PathVariable Integer stuId){
        studentsService.deleteStuById(stuId);
    }
}