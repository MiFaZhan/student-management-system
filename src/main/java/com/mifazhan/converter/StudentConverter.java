package com.mifazhan.converter;

import com.mifazhan.dto.StudentDTO;
import com.mifazhan.entity.Student;
import com.mifazhan.vo.StudentVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Student实体类和VO之间的转换器
 */
@Mapper(componentModel = "spring")
public interface StudentConverter {

    /**
     * Student实体转StudentVO
     */
    StudentVO toVO(Student student);

    /**
     * StudentVO转Student实体
     */
    Student toEntity(StudentVO studentVO);

    /**
     * Student列表转StudentVO列表
     */
    List<StudentVO> toVOList(List<Student> students);

    /**
     * StudentVO列表转Student列表
     */
    List<Student> toEntityList(List<StudentVO> studentVOs);

    /**
     * StudentDTO转Student实体
     */
    Student toEntityFromDTO(StudentDTO studentDTO);

    /**
     * StudentDTO列表转Student列表
     */
    List<Student> toEntityListFromDTO(List<StudentDTO> studentDTOs);

    /**
     * Student实体转StudentDTO
     */
    StudentDTO toDTO(Student student);

    /**
     * Student实体列表转StudentDTO
     */
    List<StudentDTO> toDTOList(List<Student> students);
}