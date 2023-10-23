package com.liga.api.method.response.epic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EpicResponse {

    /**
     * 史诗id
     */
    Long id;

    /**
     * 史诗标题
     */
    String summary;


    /**
     * 史诗状态
     */
    AttributeVO status;

    /**
     * 优先级
     */
    AttributeVO priority;

    /**
     * 负责人
     */
    AttributeVO owner;

    /**
     * 关注者列表
     */
    List<AttributeVO> follows;

    /**
     * 标签
     */
    List<AttributeVO> labels;

    /**
     * 开始时间
     */
    Date startDate;

    /**
     * 截止时间
     */
    Date dueDate;
}
