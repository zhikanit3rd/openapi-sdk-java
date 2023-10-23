package com.liga.api.method.response.version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseResponse {

    /**主键编号*/
    private Long id;

    /**项目版本名称*/
    private String name;

    /**状态名称*/
    private String statusName;

    /**状态编码", example = "release*/
    private String status;

    /**开始日期*/
    private Date startDate;

    /**预计发布日期*/
    private Date planDate;

    /**发布日期*/
    private Date releasedDate;

    /**描述*/
    private String description;

    /**owner名字*/
    private String ownerName;

    /**owner用户id*/
    private Long ownerId;
}