package com.mifazhan.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ExamRecordVO {
    private Integer examId;
    private String examName;
    private String subjectName;
    private String teacherName;
    private Date examStartTime;
    private Date examEndTime;
    private Integer participantCount;
}
