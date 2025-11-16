package com.mifazhan.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ScoreVO {
//    private Integer scoreId;
    private String subjectName;
    private String examName;
    private String teacherName;
    private String studentNumber;
    private String studentName;
    private BigDecimal score;
    private LocalDate examTime;
}