package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Scores;
import com.service.ScoresService;
import com.mapper.ScoresMapper;
import org.springframework.stereotype.Service;

/**
* @author MIFAZHAN
* @description 针对表【scores(成绩表)】的数据库操作Service实现
* @createDate 2025-11-14 14:44:22
*/
@Service
public class ScoresServiceImpl extends ServiceImpl<ScoresMapper, Scores>
    implements ScoresService{

}




