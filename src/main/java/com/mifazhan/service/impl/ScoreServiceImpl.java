package com.mifazhan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mifazhan.entity.Score;
import com.mifazhan.service.ScoreService;
import com.mifazhan.mapper.ScoreMapper;
import org.springframework.stereotype.Service;

/**
* @author MIFAZHAN
* @description 针对表【scores(成绩表)】的数据库操作Service实现
* @createDate 2025-11-14 14:44:22
*/
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
    implements ScoreService {

}




