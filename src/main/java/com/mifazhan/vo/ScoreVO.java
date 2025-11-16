package com.mifazhan.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ScoreVO {
    private Integer scoreId;
    private String studentNumber;
    private String examName;
//    private String subjectName;
    private String teacherName;
    private BigDecimal score;
    private Date examStartTime;
}