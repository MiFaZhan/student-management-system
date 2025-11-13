package com.controller;

import com.pojo.Students;
import com.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired
    private IStudentsService studentsService;


    /**
     *查询所有学生
     */
    @GetMapping
    public List<Students> getAllStudents() {
        return studentsService.list();
    }


    /**
     *根据ID查询学生
     */
    @GetMapping("/{id}")
    public Students getStudentById(@PathVariable Integer id) {
        return studentsService.getById(id);
    }


    /**
     * 根据id批量查询学生信息
     */
    @PostMapping("/ids")
    public List<Students> getStudentsByIds(@RequestBody List<Integer> ids) {
        return studentsService.listByIds(ids);
    }


    /**
     * 根据姓名查询学生信息
     */
    @GetMapping("/name")
    public List<Students> searchStudentsByName(@RequestParam String name) {
        return studentsService.findByStuName(name);
    }


    /**
     * 新增学生信息
     */
    @PostMapping
    public void createStudent(@RequestBody Students student) {
        studentsService.save(student);
    }

    /**
     * 批量新增学生信息
     */
    @PostMapping("/batch")
    public boolean batchInsert(@RequestBody List<Students> students) {
        if (students == null || students.isEmpty()) {
            return false;
        }
        return studentsService.saveBatch(students);
    }



    /**
     * 更新学生表信息
     */
    @PutMapping
    public void updateById(@RequestBody Students student) {
        studentsService.updateById(student);
    }


    /**
     * 根据id删除学生信息
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        studentsService.removeById(id);
    }
}