package com.mifazhan.controller;

import com.mifazhan.dto.StudentDTO;
import com.mifazhan.service.StudentService;
import com.mifazhan.vo.Result;
import com.mifazhan.vo.StudentVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    // 使用构造器注入替代 @Autowired 字段注入
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 查询所有学生
     */
    @GetMapping
    public Result<List<StudentVO>> listStudents() {
        return Result.success("成功，查询所有学生数据如下",studentService.listStudents());
    }


    /**
     * 根据id查询学生
     */
    @GetMapping("/{id}")
    public Result<StudentVO> getStudentById(@PathVariable Integer id) {
        return Result.success("成功，根据id查询学生数据如下",studentService.getStudentById(id));
    }


    /**
     * 根据id批量查询学生信息
     */
    @PostMapping("/ids")
    public Result<List<StudentVO>> listStudentsByIds(@RequestBody List<Integer> ids) {
        return Result.success("成功，根据id批量查询学生数据如下",studentService.listStudentsByIds(ids));
    }


    /**
     * 根据姓名查询学生信息
     */
    @GetMapping("/name")
    public Result<List<StudentVO>> getStudentsByName(@RequestParam String name) {
        return Result.success("成功，根据姓名查询学生数据如下",studentService.getStudentsByName(name));
    }


    /**
     * 新增学生信息
     */
    @PostMapping
    public Result<StudentVO> insertStudent(@RequestBody StudentDTO studentDTO) {
        return Result.success("成功，新增学生数据如下",studentService.insertStudent(studentDTO));
    }


    /**
     * 批量新增学生信息
     */
    @PostMapping("/batch")
    public Result<List<StudentVO>> insertBatch(@RequestBody List<StudentDTO> studentsDTO) {
        return Result.success("成功，批量新增学生数据如下",studentService.insertBatch(studentsDTO));
    }


    /**
     * 根据id更新学生表信息
     */
    @PutMapping
    public Result<StudentVO> updateStudentById(@RequestBody StudentDTO studentDTO) {
        return Result.success("成功，更新学生数据如下",studentService.updateStudentById(studentDTO));
    }


    /**
     * 根据id删除学生信息
     */
    @DeleteMapping("/{id}")
    public Result<StudentVO> deleteStudentById(@PathVariable Integer id){
        return Result.success("成功，删除学生数据如下",studentService.deleteStudentById(id));
    }
}