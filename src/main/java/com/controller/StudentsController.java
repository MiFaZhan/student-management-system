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
    @GetMapping("/{id}")
    public Students getStudentById(@PathVariable String id) {
        return studentsService.getById(id);
    }

    /**
     * 根据id批量查询学生信息
     */
    @PostMapping("/ids")
    public List<Students> getStudentsByIds(@RequestBody List<Integer> studentIds) {
        return studentsService.listByIds(studentIds);
    }

    /**
     * 姓名查询笔记
     * 根据姓名查询学生信息一
     * 方式：使用条件构造器的QueryWrapper构造查询条件
     * 缺点：不如LambdaQueryWrapper，因此弃用
     * https://yuanbao.tencent.com/bot/app/share/chat/vgPtVIw9atH4
     * @GetMapping("/search1")
     *     public List<Students> getStudentsByName1(@RequestParam String name){
     *         QueryWrapper<Students> wrapper = new QueryWrapper<>();
     *         wrapper.eq("name", name);
     *         return studentsService.list(wrapper);
     *     }
     *
     * 根据姓名查询学生信息二
     * 方式：使用条件构造器的LambdaQueryWrapper构造查询条件
     * 缺点：Controller 层主要负责接收请求、返回响应，不建议直接编写业务逻辑或数据库操作。
     * 改进：应把把数据库查询封装到 Service 层，让 Controller 层只负责调用
     * @GetMapping("/search2")
     *     public List<Students> getStudentsByName2(@RequestParam String name){
     *         LambdaQueryWrapper<Students> wrapper = new LambdaQueryWrapper<>();
     *         wrapper.eq(Students::getName, name);
     *         return studentsService.list(wrapper);
     *     }
     */

    /**
     * 根据姓名查询学生信息
     */
    @GetMapping("/search")
    public List<Students> searchStudentsByName(@RequestParam String name) {
        return studentsService.findByName(name);
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
    public void deleteById(@PathVariable String id){
        studentsService.removeById(id);
    }
}