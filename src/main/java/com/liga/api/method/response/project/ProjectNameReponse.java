package com.liga.api.method.response.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectNameReponse {

    /**项目主键编号*/
    private Long id;
    /**项目名称*/
    private String pname;
    /**项目key*/
    private String pkey;
    /** 是否归档(0:否,1:是)*/
    private Integer archived;
}