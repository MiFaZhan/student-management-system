package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public List<Students> list(){
        return studentsService.list();
    }

    /**
     *根据ID查询学生
     */
    @GetMapping("/{id}")
    public Students getStudents(@PathVariable String id){
        return studentsService.getById(id);
    }

    /**
     * 根据姓名查询学生信息方式一
     */
    @GetMapping("/search1")
    public List<Students> getStudentsByName1(@RequestParam String name){
        QueryWrapper<Students> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        return studentsService.list(wrapper);
    }

    /**
     * 根据姓名查询学生信息方式二
     */
    @GetMapping("/search2")
    public List<Students> getStudentsByName2(@RequestParam String name){
        LambdaQueryWrapper<Students> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Students::getName, name);
        return studentsService.list(wrapper);
    }


    /**
     * 插入学生信息
     */
    @PostMapping
    public void insertInfo(@RequestBody Students students){
        studentsService.save(students);
    }

    /**
     * 根据id更新学生表信息
     */
    @PutMapping
    public void updateById(@RequestBody Students students){
        studentsService.updateById(students);
    }

    /**
     * 根据id删除学生信息
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        studentsService.removeById(id);
    }
}