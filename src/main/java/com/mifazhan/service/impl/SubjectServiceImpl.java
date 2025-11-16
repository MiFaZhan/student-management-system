package com.mifazhan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mifazhan.converter.SubjectConverter;
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
        List<Subject> subjects = subjectMapper.getSubject();
        return List.of();
    }
}




