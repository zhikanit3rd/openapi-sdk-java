package com.liga.api.method.response.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTemplateResponse {
    
    /**项目模板id*/
    private Long id;
    /**项目模板Code*/
    private String code;
    /**项目模板类型*/
    private String category;
    /**项目模板名称*/
    private String name;
    /**项目模板备注*/
    private String remark;
}