package com.mifazhan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 学生表
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
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

    /**
     * 逻辑删除
     */
    private Integer deleted;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getStudentNumber() == null ? other.getStudentNumber() == null : this.getStudentNumber().equals(other.getStudentNumber()))
            && (this.getStudentName() == null ? other.getStudentName() == null : this.getStudentName().equals(other.getStudentName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getClassName() == null ? other.getClassName() == null : this.getClassName().equals(other.getClassName()))
            && (this.getHometown() == null ? other.getHometown() == null : this.getHometown().equals(other.getHometown()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getStudentNumber() == null) ? 0 : getStudentNumber().hashCode());
        result = prime * result + ((getStudentName() == null) ? 0 : getStudentName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getClassName() == null) ? 0 : getClassName().hashCode());
        result = prime * result + ((getHometown() == null) ? 0 : getHometown().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", studentNumber=").append(studentNumber);
        sb.append(", studentName=").append(studentName);
        sb.append(", gender=").append(gender);
        sb.append(", phone=").append(phone);
        sb.append(", idCard=").append(idCard);
        sb.append(", grade=").append(grade);
        sb.append(", className=").append(className);
        sb.append(", hometown=").append(hometown);
        sb.append(", address=").append(address);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}