package com.liga.api.method.response.issue;

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
public class IssueResponse {

    /**主键id*/
    private Long id;

    /**
     * 数据
     */
    private Map<String, Object> data;

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;
    /**项目id*/
    private Long projectId;

}
