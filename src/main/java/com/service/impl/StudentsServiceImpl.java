package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pojo.Students;
import com.mapper.StudentsMapper;
import com.service.IStudentsService;
import org.springframework.stereotype.Service;

@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements IStudentsService {

}
