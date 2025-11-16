package com.mifazhan.converter;

import com.mifazhan.entity.Subject;
import com.mifazhan.vo.SubjectVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectConverter {

    /**
     * 将Subject实体对象转换为SubjectVO视图对象
     * @param subject 待转换的Subject实体对象
     * @return 转换后的SubjectVO视图对象
     */
    SubjectVO toVO(Subject subject);

    /**
     * 将Subject实体对象列表转换为SubjectVO视图对象列表
     * @param subjects 待转换的Subject实体对象列表
     * @return 转换后的SubjectVO视图对象列表
     */
    List<SubjectVO> toVOList(List<Subject> subjects);

    /**
     * 将SubjectVO视图对象转换为Subject实体对象
     * @param subjectVO 待转换的SubjectVO视图对象
     * @return 转换后的Subject实体对象
     */
    Subject toEntity(SubjectVO subjectVO);

    /**
     * 将SubjectVO视图对象列表转换为Subject实体对象列表
     * @param subjectVOs 待转换的SubjectVO视图对象列表
     * @return 转换后的Subject实体对象列表
     */
    List<Subject> toEntityList(List<SubjectVO> subjectVOs);



}
