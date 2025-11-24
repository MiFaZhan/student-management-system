package com.mifazhan.converter;

import com.mifazhan.entity.ExamRecord;
import com.mifazhan.vo.ExamRecordVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamRecordConverter {

    /**
     * 将ExamRecord实体对象转换为ExamRecordVO视图对象
     * @param examRecord 待转换的考试记录实体对象
     * @return 转换后的考试记录视图对象
     */
    ExamRecordVO toVO(ExamRecord examRecord);

    /**
     * 将ExamRecord实体对象列表转换为ExamRecordVO视图对象列表
     * @param examRecords 待转换的考试记录实体对象列表
     * @return 转换后的考试记录视图对象列表
     */
    List<ExamRecordVO> toVOList(List<ExamRecord> examRecords);

    /**
     * 将ExamRecordVO视图对象转换为ExamRecord实体对象
     * @param examRecordVO 待转换的考试记录视图对象
     * @return 转换后的考试记录实体对象
     */
    ExamRecord toEntity(ExamRecordVO examRecordVO);

    /**
     * 将ExamRecordVO视图对象列表转换为ExamRecord实体对象列表
     * @param examRecordVOs 待转换的考试记录视图对象列表
     * @return 转换后的考试记录实体对象列表
     */
    List<ExamRecord> toEntityList(List<ExamRecordVO> examRecordVOs);

}
