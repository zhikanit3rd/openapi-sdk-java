package com.liga.api.method.response.epic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EpicIssueResponse {
    /**
     * 问题编号
     */
    Long id;

    /**
     * 问题序列
     */
    Long issueNumber;

    /**
     * 问题概要
     */
    String summary;

    /**
     * 点数
     */
    BigDecimal estimatePoint;

    /**
     * issue开始时间
     */
    Date startDate;

    /**
     * issue截止时间
     */
    Date dueDate;

    /**
     * 问题类型
     */
    AttributeVO issueType;

    /**
     * 优先级
     */
    AttributeVO priority;

    /**
     * 所属者
     */
    AttributeVO owner;


    /**
     * 状态
     */
    AttributeVO state;

    /**
     * 迭代
     */
    AttributeVO sprint;

    /**
     * 关注人列表
     */
    List<AttributeVO> follows;
}
