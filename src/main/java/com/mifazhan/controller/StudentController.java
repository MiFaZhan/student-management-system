package com.mifazhan.controller;

import com.mifazhan.entity.Student;
import com.mifazhan.service.StudentService;
import com.mifazhan.vo.Result;
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
    public Result<List<Student>> getAllStudents() {
        Result<List<Student>> result = new Result<>();
        return result.success(studentService.list());
    }


    /**
     * 根据id查询学生
     */
    @GetMapping("/{id}")
    public Result<Student> getStudentById(@PathVariable Integer id) {
        Result<Student> result = new Result<>();
        return result.success(studentService.getById(id));
    }


    /**
     * 根据id批量查询学生信息
     */
    @PostMapping("/ids")
    public Result<List<Student>> getStudentsByIds(@RequestBody List<Integer> ids) {
        Result<List<Student>> result = new Result<>();
        return result.success(studentService.listByIds(ids));
    }


    /**
     * 根据姓名查询学生信息
     */
    @GetMapping("/name")
    public Result<List<Student>> searchStudentsByName(@RequestParam String name) {
        Result<List<Student>> result = new Result<>();
        return result.success(studentService.getByStuName(name));
    }


    /**
     * 新增学生信息
     */
    @PostMapping
    public Result createStudent(@RequestBody Student student) {
        Result result = new Result<>();
        return result.success(studentService.save(student));
    }

    /**
     * 批量新增学生信息
     */
    @PostMapping("/batch")
    public Result batchInsert(@RequestBody List<Student> students) {
        Result result = new Result<>();
        return result.success(studentService.saveBatch(students));
    }


    /**
     * 根据id更新学生表信息
     */
    @PutMapping
    public Result updateById(@RequestBody Student student) {
        Result result = new Result<>();
        return result.success(studentService.updateById(student));
    }


    /**
     * 根据id删除学生信息
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        Result result = new Result<>();
        return result.success(studentService.removeById(id));
    }
}