package com.mifazhan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mifazhan.converter.SubjectConverter;
import com.mifazhan.dto.SubjectDTO;
import com.mifazhan.entity.Subject;
import com.mifazhan.mapper.SubjectMapper;
import com.mifazhan.service.SubjectService;
import com.mifazhan.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【subject(科目表)】的数据库操作Service实现
* @createDate 2025-11-14 14:44:22
*/
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject>
    implements SubjectService{

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private SubjectConverter subjectConverter;

    @Override
    public List<SubjectVO> getSubject() {
        List<Subject> subjects = this.list();
        return subjectConverter.toVOList(subjects);
    }

    @Override
    public SubjectVO getSubjectById(Integer id) {
        Subject subject = this.getById(id);
        if (subject != null) {
            return subjectConverter.toVO(subject);
        }
        else return null;
    }

    @Override
    public SubjectVO getSubjectByName(String name) {
        LambdaQueryWrapper<Subject> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Subject::getSubjectName, name);
        Subject subject = this.getOne(queryWrapper);
        if (subject != null)
            return subjectConverter.toVO(subject);
        else return null;
    }

    @Override
    public SubjectVO insertSubject(SubjectDTO subjectDTO) {
        Subject subject = subjectConverter.toEntityFromDTO(subjectDTO);
        if (this.save(subject))
            return subjectConverter.toVO(subject);
         else
            return null;
    }
}




