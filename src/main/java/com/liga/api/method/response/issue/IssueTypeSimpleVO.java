package com.liga.api.method.response.issue;

import lombok.Data;

@Data
public class IssueTypeSimpleVO {
    
    /**问题类型编号*/
    protected Long id;

    /**问题类型名称*/
    protected String name;

    /**问题类型编码*/
    protected String code;
}
