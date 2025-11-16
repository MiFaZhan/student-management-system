package com.mifazhan.vo;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ScoreVO {
    private Integer scoreId;
    private String studentNumber;
    private Integer examId;
    private BigDecimal score;
}