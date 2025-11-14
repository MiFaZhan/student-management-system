package com.controller;

import com.entity.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
     * 查询所有学生
     */
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.list();
    }


    /**
     * 根据id查询学生
     */
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getById(id);
    }


    /**
     * 根据id批量查询学生信息
     */
    @PostMapping("/ids")
    public List<Student> getStudentsByIds(@RequestBody List<Integer> ids) {
        return studentService.listByIds(ids);
    }


    /**
     * 根据姓名查询学生信息
     */
    @GetMapping("/name")
    public List<Student> searchStudentsByName(@RequestParam String name) {
        return studentService.getByStuName(name);
    }


    /**
     * 新增学生信息
     */
    @PostMapping
    public boolean createStudent(@RequestBody Student student) {
        if (student == null) {
            return false;
        }
        return studentService.save(student);
    }

    /**
     * 批量新增学生信息
     */
    @PostMapping("/batch")
    public boolean batchInsert(@RequestBody List<Student> students) {
        if (students == null || students.isEmpty()) {
            return false;
        }
        return studentService.saveBatch(students);
    }


    /**
     * 根据id更新学生表信息
     */
    @PutMapping
    public void updateById(@RequestBody Student student) {
        studentService.updateById(student);
    }


    /**
     * 根据id删除学生信息
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        studentService.removeById(id);
    }
}