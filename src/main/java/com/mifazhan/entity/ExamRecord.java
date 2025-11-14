package com.mifazhan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 考试记录表
 * @TableName exam_records
 */
@TableName(value ="exam_records")
@Data
public class ExamRecord {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer examId;

    /**
     * 科目id
     */
    private Integer subjectId;

    /**
     * 考试名称
     */
    private String examName;

    /**
     * 出题教师
     */
    private String teacherName;

    /**
     * 考试开始时间
     */
    private Date examStartTime;

    /**
     * 考试结束时间
     */
    private Date examEndTime;

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
        ExamRecord other = (ExamRecord) that;
        return (this.getExamId() == null ? other.getExamId() == null : this.getExamId().equals(other.getExamId()))
            && (this.getSubjectId() == null ? other.getSubjectId() == null : this.getSubjectId().equals(other.getSubjectId()))
            && (this.getExamName() == null ? other.getExamName() == null : this.getExamName().equals(other.getExamName()))
            && (this.getTeacherName() == null ? other.getTeacherName() == null : this.getTeacherName().equals(other.getTeacherName()))
            && (this.getExamStartTime() == null ? other.getExamStartTime() == null : this.getExamStartTime().equals(other.getExamStartTime()))
            && (this.getExamEndTime() == null ? other.getExamEndTime() == null : this.getExamEndTime().equals(other.getExamEndTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExamId() == null) ? 0 : getExamId().hashCode());
        result = prime * result + ((getSubjectId() == null) ? 0 : getSubjectId().hashCode());
        result = prime * result + ((getExamName() == null) ? 0 : getExamName().hashCode());
        result = prime * result + ((getTeacherName() == null) ? 0 : getTeacherName().hashCode());
        result = prime * result + ((getExamStartTime() == null) ? 0 : getExamStartTime().hashCode());
        result = prime * result + ((getExamEndTime() == null) ? 0 : getExamEndTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", examId=").append(examId);
        sb.append(", subjectId=").append(subjectId);
        sb.append(", examName=").append(examName);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", examStartTime=").append(examStartTime);
        sb.append(", examEndTime=").append(examEndTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}