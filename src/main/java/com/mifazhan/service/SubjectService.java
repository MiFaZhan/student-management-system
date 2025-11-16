package com.mifazhan.service;

import com.mifazhan.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mifazhan.vo.SubjectVO;

import java.util.List;

/**
* @author MIFAZHAN
* @description 针对表【subject(科目表)】的数据库操作Service
* @createDate 2025-11-14 14:44:22
*/
public interface SubjectService extends IService<Subject> {

    List<SubjectVO> getSubject();
}
