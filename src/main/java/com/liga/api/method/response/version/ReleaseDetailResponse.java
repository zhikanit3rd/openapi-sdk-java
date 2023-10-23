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
public class ReleaseDetailResponse {
    /**版本id*/
    private Long id;

    /**版本名称*/
    private String name;

    /**开始时间*/
    private Date startDate;

    /**预计发布时间*/
    private Date planDate;

    /**发布时间*/
    private Date releasedDate;

    /**版本说明*/
    private String description;

   /** 发布状态 */
    private String status;

    /**共计工作日*/
    private Integer totalDays;

    /**距发布日期数*/
    private Integer daysToRelease;

}
