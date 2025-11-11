package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pojo.Students;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentsMapper extends BaseMapper<Students> {
    List<Students> selectByName(@Param("name") String name);

}
