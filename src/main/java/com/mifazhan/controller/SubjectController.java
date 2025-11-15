package com.mifazhan.controller;

import com.mifazhan.dto.SubjectDTO;
import com.mifazhan.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询所有课程
     * @return
     */
//    @GetMapping
//    public List<SubjectDTO> getSubjects() {
//        return subjectService.list();
//        return BeanUtil.copyToList(list, SubjectDTO.class);
//    }

    /**
     * 根据id查询课程
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public SubjectDTO getSubjectById(@PathVariable String id) {
        return getSubjectById(id);
    }

}
