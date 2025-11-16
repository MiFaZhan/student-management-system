package com.mifazhan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mifazhan.converter.StudentConverter;
import com.mifazhan.entity.Student;
import com.mifazhan.mapper.StudentMapper;
import com.mifazhan.service.StudentService;
import com.mifazhan.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【students(学生表)】的数据库操作Service实现
* @createDate 2025-11-14 14:44:22
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentConverter studentConverter;

    @Override
    public List<StudentVO> getStudentsByName(String studentName) {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getStudentName, studentName);
        List<Student> students = studentMapper.selectList(queryWrapper);
        return studentConverter.toVOList(students);
//        if(students != null){
//            return studentConverter.toVOList(students);
//        }else
//            return null;
    }


    @Override
    public List<StudentVO> listStudents() {
        List<Student> list = this.list();
        return studentConverter.toVOList(list);
    }

    @Override
    public StudentVO getStudentById(Integer id) {
        Student student = this.getById(id);
        return studentConverter.toVO(student);
    }

    @Override
    public List<StudentVO> listStudentsByIds(List<Integer> ids) {
        List<Student> list = this.listByIds(ids);
        return studentConverter.toVOList(list);
    }

    @Override
    public StudentVO insertStudent(Student student) {
        if (this.save(student))
            return studentConverter.toVO(student);
        else
            return null;
    }

    @Override
    public List<StudentVO> insertBatch(List<Student> students) {
        if (this.saveBatch(students))
            return studentConverter.toVOList( students);
        else
            return null;
    }

    @Override
    public StudentVO updateStudentById(Student student) {
        if (this.updateById(student))
            return studentConverter.toVO(student);
        else
            return null;
    }

    @Override
    public StudentVO deleteStudentById(Integer id) {
        this.removeById(id);
        return studentConverter.toVO(this.getById(id));
    }

}




