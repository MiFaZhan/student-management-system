package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@TableName("students")
public class Students {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String major;
//    private String className;
    private String phone;
    private Date enrollmentdate;
}