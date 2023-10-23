package com.liga.api.method.response.sprint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SprintCountResponse {
    
    /**迭代主键id*/
    private Long id;

    /**迭代名称*/
    private String name;

    /**开始日期*/
    private Date startDate;

    /**结束日期*/
    private Date endDate;

    /**完成日期*/
    private Date completeDate;

    /**是否开始*/
    private Byte started;

    /**是否关闭*/
    private Byte closed;

    /**迭代状态 1.进行中 2.未开始 4.已完成*/
    private Integer status;

    /**目标*/
    private String goal;

    /**point统计*/
    private Long estimatePointTotal;

    /**问题类型数量统计*/
    private Map<String, Integer> issueTypeCountMap;

    /**迭代负责人id*/
    private Long assignee;

    /**迭代负责人*/
    private String assigneeName;
}