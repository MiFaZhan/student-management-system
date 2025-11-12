package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    private int examId;
    private String subjectName;
    private String teacherName;
    private String exam_start_time;
    private String exam_end_time;
    private int deleted;
}
