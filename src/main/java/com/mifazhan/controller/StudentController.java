package com.mifazhan.controller;

import com.mifazhan.entity.Student;
import com.mifazhan.service.StudentService;
import com.mifazhan.vo.Result;
import com.mifazhan.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
     * 查询所有学生
     */
    @GetMapping
    public Result<List<StudentVO>> getAllStudents() {
        return Result.success(studentService.getAllStudents());
    }


    /**
     * 根据id查询学生
     */
    @GetMapping("/{id}")
    public Result<StudentVO> getStudentById(@PathVariable Integer id) {
        return Result.success(studentService.getStudentById(id));
    }


    /**
     * 根据id批量查询学生信息
     */
    @PostMapping("/ids")
    public Result<List<StudentVO>> getStudentsByIds(@RequestBody List<Integer> ids) {
        return Result.success(studentService.getStudentsByIds(ids));
    }


    /**
     * 根据姓名查询学生信息
     */
    @GetMapping("/name")
    public Result<List<StudentVO>> getStudentsByName(@RequestParam String name) {
        return Result.success(studentService.getStudentsByName(name));
    }


    /**
     * 新增学生信息
     */
    @PostMapping
    public Result createStudent(@RequestBody Student student) {
        return Result.success(studentService.save(student));
    }

    /**
     * 批量新增学生信息
     */
    @PostMapping("/batch")
    public Result batchInsert(@RequestBody List<Student> students) {
        return Result.success(studentService.saveBatch(students));
    }


    /**
     * 根据id更新学生表信息
     */
    @PutMapping
    public Result updateById(@RequestBody Student student) {
        return Result.success(studentService.updateById(student));
    }


    /**
     * 根据id删除学生信息
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        return Result.success(studentService.removeById(id));
    }
}