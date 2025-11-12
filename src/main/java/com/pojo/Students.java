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
    private Integer stuId;
    private String stuName;
    private String gender;
    private String phone;
    private String idCard;
    private String grade;
    private String className;
    private String hometown;
    private String address;
    private int deleted;

}