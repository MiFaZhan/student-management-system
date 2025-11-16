package com.mifazhan.converter;

import com.mifazhan.entity.Score;
import com.mifazhan.vo.ScoreVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScoreConverter {

    ScoreVO toVO(Score score);

    List<ScoreVO> toVOList(List<Score> scores);

    Score toEntity(ScoreVO scoreVO);

    List<Score> toEntityList(List<ScoreVO> scoreVOs);
}
