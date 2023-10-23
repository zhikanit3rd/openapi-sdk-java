package com.liga.api.method.field;

/**
 * 项目概要系统字段枚举类型
 */
public enum ProjectFieldEnum {

    /**
     * 项目名称
     */
    PNAME("pname"),
    /**
     *项目负责人
     */
    LEADER_ID("leader_id"),
    /**
     *开始日期
     */
    START_TIME("start_time"),
    /**
     *结束日期
     */
    END_TIME("end_time"),
    /**
     *项目描述
     */
    DESCRIPTION("description"),
    /**
     *项目背景颜色
     */
    BACKGROUND_COLOR("background_color"),
    /**
     *总个数
     */
    TOTAL_COUNT("total_count"),
    /**
     *总点数
     */
    TOTAL_POINT("total_point"),
    /**
     *总预估工时
     */
    TOTAL_ESTIMATED_WT("total_estimated_wt"),
    /**
     *总已用工时
     */
    TOTAL_USED_WT("total_used_wt"),
    /**
     *总剩余工时
     */
    TOTAL_REMAINING_WT("total_remaining_wt"),
    /**
     *项目进度
     */
    PROGRESS("progress"),
    ;

    public final String code;

    ProjectFieldEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
