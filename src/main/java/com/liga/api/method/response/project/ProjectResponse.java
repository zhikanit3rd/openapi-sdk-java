package com.liga.api.method.response.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {

    /**项目id*/
    private Long id;

    /**项目名称*/
    private String projectName;

    /**url*/
    private String url;

    /**项目leader id*/
    private Long leaderId;

    /**项目leader*/
    private String leader;

    /**项目关键字*/
    private String projectKey;

    /**图标*/
    private Long avatar;

    /**描述*/
    private String description;

    /**项目分类*/
    private Long projectCategory;

    /**项目状态*/
    private Integer status;

    /**创建时间*/
    private Date createTime;

    /**创建人id*/
    private Long createBy;

    /**更新时间*/
    private Date updateTime;

    /** 是否归档(0:否,1:是)*/
    private Integer archived;
}