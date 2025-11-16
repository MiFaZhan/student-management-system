package com.mifazhan.vo;

import lombok.Data;

@Data
public class StudentVO {

    private Integer studentId;

    /**
     * 学号
     */
    private String studentNumber;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 年级
     */
    private String grade;

    /**
     * 班级
     */
    private String className;

    /**
     * 籍贯
     */
    private String hometown;

    /**
     * 住址
     */
    private String address;
}
