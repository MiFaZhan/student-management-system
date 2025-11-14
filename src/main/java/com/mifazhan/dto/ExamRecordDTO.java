package com.mifazhan.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ExamRecordDTO {
    private Integer examId;
    private String examName;
    private String teacherName;
    private Date examStartTime;
    private Date examEndTime;
    private Integer participantCount;
}
