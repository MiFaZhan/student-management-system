package com.service;

import com.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【students(学生表)】的数据库操作Service
* @createDate 2025-11-14 14:44:22
*/
public interface StudentService extends IService<Student> {
    List<Student> getByStuName(String studentName);
}
