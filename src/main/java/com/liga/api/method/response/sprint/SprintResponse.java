package com.liga.api.method.response.sprint;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SprintResponse {
    
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

    /**目标*/
    private String goal;

    //todo 类型改为LONG
    /**项目主键id", example = "1*/
    private String projectId;

    /**迭代状态 1.Active 2.To be Started 3.Unplaned 4.Finished", example = "1*/
    private Integer status;

    /**迭代负责人id*/
    private Long assignee;

    /**迭代负责人*/
    private String assigneeName;
}