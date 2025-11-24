package com.mifazhan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mifazhan.converter.StudentConverter;
import com.mifazhan.dto.StudentDTO;
import com.mifazhan.entity.Student;
import com.mifazhan.exception.BusinessException;
import com.mifazhan.mapper.StudentMapper;
import com.mifazhan.service.StudentService;
import com.mifazhan.vo.StudentVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author MIFAZHAN
* 针对表【students(学生表)】的数据库操作Service实现
* 2025-11-14 14:44:22
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

    private final StudentMapper studentMapper;
    private final StudentConverter studentConverter;

    public StudentServiceImpl(StudentMapper studentMapper, StudentConverter studentConverter) {
        this.studentMapper = studentMapper;
        this.studentConverter = studentConverter;
    }

    @Override
    public List<StudentVO> listStudents() {
        List<Student> list = this.list();
        return studentConverter.toVOList(list);
    }

    @Override
    public StudentVO getStudentById(Integer id) {
        if (id == null || id <= 0) {
            throw new BusinessException(400, "学生ID无效");
        }

        Student student = this.getById(id);
        if (student == null) {
            throw new BusinessException(404, "未找到ID为" + id + "的学生");
        }

        return studentConverter.toVO(student);
    }

    @Override
    public List<StudentVO> listStudentsByIds(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new BusinessException(400, "学生ID列表不能为空");
        }

        List<Student> list = this.listByIds(ids);
        if (list.isEmpty()) {
            throw new BusinessException(404, "未找到ID列表中的学生");
        }

        return studentConverter.toVOList(list);
    }

    @Override
    public List<StudentVO> getStudentsByName(String studentName) {
        if (studentName == null || studentName.isEmpty()) {
            throw new BusinessException(400, "学生姓名不能为空");
        }

        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getStudentName, studentName);
        List<Student> students = studentMapper.selectList(queryWrapper);

        if (students.isEmpty()) {
            throw new BusinessException(404, "未找到姓名为" + studentName + "的学生");
        }

        return studentConverter.toVOList(students);
    }

    @Override
    public StudentVO insertStudent(StudentDTO studentDTO) {
        if (studentDTO == null) {
            throw new BusinessException(400, "新增学生DTO不能为空");
        }

        Student student = studentConverter.toEntityFromDTO(studentDTO);
        if (this.save(student))
            return studentConverter.toVO(student);
        else
            throw new BusinessException(500, "新增学生失败");
    }

    //待完善
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<StudentVO> insertBatch(List<StudentDTO> studentsDTO) {
        if (studentsDTO == null || studentsDTO.isEmpty()) {
            throw new BusinessException(400, "批量新增学生DTO列表不能为空");
        }

        List<Student> students = studentConverter.toEntityListFromDTO(studentsDTO);
        if (students.isEmpty()) {
            throw new BusinessException(400, "DTO转换为实体类后为空，请检查DTO数据有效性");
        }

        if (!this.saveBatch(students)) {
            throw new BusinessException(500, "批量插入学生失败");
        }
        return studentConverter.toVOList(students);
    }

    @Override
    public StudentVO updateStudentById(StudentDTO studentDTO) {
        if (studentDTO == null ) {
            throw new BusinessException(400, "根据ID更新学生DTO不能为空");
        }

        if (studentDTO.getStudentId() == null || studentDTO.getStudentId() <= 0) {
            throw new BusinessException(400, "学生ID无效");
        }

        // 检查学生是否存在
        Student existingStudent = this.getById(studentDTO.getStudentId());
        if (existingStudent == null) {
            throw new BusinessException(404, "未找到ID为" + studentDTO.getStudentId() + "的学生");
        }

        Student student = studentConverter.toEntityFromDTO(studentDTO);
        if (student == null) {
            throw new BusinessException(400, "DTO转换为实体类后为空，请检查DTO数据有效性");
        }

        if (this.updateById(student))
            return studentConverter.toVO(student);
        else
            throw new BusinessException(500, "根据ID更新学生失败");
    }

    @Override
    public StudentVO deleteStudentById(Integer id) {
        if (id == null || id <= 0) {
            throw new BusinessException(400, "学生ID无效");
        }

        Student student = this.getById(id);
        if (student == null) {
            throw new BusinessException(404, "未找到ID为" + id + "的学生");
        }

        if (this.removeById(id))
            return studentConverter.toVO(student);
        else
            throw new BusinessException(500, "根据ID删除学生失败");
    }

}




