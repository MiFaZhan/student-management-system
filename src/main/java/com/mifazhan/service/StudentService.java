package com.mifazhan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mifazhan.dto.StudentDTO;
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

    StudentVO insertStudent(StudentDTO studentDTO);

    List<StudentVO> insertBatch(List<StudentDTO> studentsDTO);

    StudentVO updateStudentById(StudentDTO studentDTO);

    StudentVO deleteStudentById(Integer id);
}
