package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("exam_records")
public class ExamRecords {
    @TableId(type = IdType.AUTO)
    private Integer examId;
    private String subjectName;
    private String teacherName;
    private String examStartTime;
    private String examEndTime;
    @TableLogic
    private int deleted;
}
