package com.mifazhan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mifazhan.entity.Student;
import com.mifazhan.vo.StudentVO;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【students(学生表)】的数据库操作Service
* @createDate 2025-11-14 14:44:22
*/
public interface StudentService extends IService<Student> {

    List<StudentVO> listStudents();

    StudentVO getStudentById(Integer id);

    List<StudentVO> listStudentsByIds(List<Integer> ids);

    List<StudentVO> getStudentsByName(String name);

    StudentVO insertStudent(Student student);

    List<StudentVO> insertBatch(List<Student> students);

    StudentVO updateStudentById(Student student);

    StudentVO deleteStudentById(Integer id);
}
