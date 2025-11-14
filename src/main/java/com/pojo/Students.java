package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@TableName("students")
public class Students {

    @TableId(type = IdType.AUTO)
    private Integer studentId;
    private String studentName;
    private String gender;
    private String phone;
    private String idCard;
    private String grade;
    private String className;
    private String hometown;
    private String address;
    @TableLogic
    private int deleted;

}