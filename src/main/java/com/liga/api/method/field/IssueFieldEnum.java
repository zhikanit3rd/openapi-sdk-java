package com.liga.api.method.field;

public enum IssueFieldEnum {
    /**
     * 扩展字段前缀
     */
    EXT_FIELD_PREFIX("value"),

    /**
     * 扩展字段前缀2
     */
    EXT_FIELD_PREFIX_("value_"),

    /**
     * 主键编号
     */
    ID("id"),

    /**
     * issue类别id
     */
    ISSUE_TYPE_ID("issueTypeId"),
    /**
     * 项目id
     */
    PROJECT_ID("projectId"),
    /**
     * 工作流编号
     */
    WORKFLOW_ID("workflowId"),

    /**
     * 优先级
     */
    PRIORITY("priority"),

    /**
     * 概要
     */
    SUMMARY("summary"),

    /**
     * 状态
     */
    STATUS("status"),

    /**
     * 描述
     */
    DESCRIPTION("description"),

    /**
     * 过期日期
     */
    DUE_DATE("dueDate"),

    /**
     * 开始日期
     */
    START_DATE("startDate"),

    /**
     * 时间区间
     */
    DATE_RANGE("dateRange"),

    /**
     * 子任务
     */
    SUB_TASK("subtask"),

    /**
     * 工时登记信息
     */
    LABOUR_RECORD("labourRecord"),

    /**
     * 关联
     */
    RELATIONSHIP("relationship"),

    /**
     * 关联类型
     */
    RELATIONSHIP_TYPE("type"),

    /**
     * 关联编号
     */
    RELATIONSHIP_ID("id"),

    /**
     * 是否就绪
     */
    READY("ready"),

    /**
     * 标签
     */
    LABEL("label"),

    /**
     * 关注/关注者
     */
    FOLLOWS("follows"),

    /**
     * 附件
     */
    ATTACHMENT("attachment"),

    /**
     * 史诗
     */
    EPIC("epic"),

    /**
     * 迭代
     */
    SPRINT("sprint"),

    /**
     * 发布版本号
     */
    RELEASE_VERSION("releaseVersion"),

    /**
     * 问题序号
     */
    ISSUE_NUMBER("issueNumber"),

    /**
     * 指派人/执行人
     */
    ASSIGNEE("assignee"),

    /**
     * 预计工时/点数
     */
    ESTIMATE_POINT("estimatePoint"),

    /**
     * 自动计算点数标志位
     */
    AUTO_CALCULATE_FLAG("autoCalculateFlag"),

    /**
     * 源事项id
     */
    SOURCE_ISSUE_ID("sourceIssueId"),

    /**
     * 所属人/负责人
     */
    OWNER("owner"),

    /**
     * 状态类别
     */
    STATE_CATEGORY("stateCategory"),

    /**
     * 排序
     */
    SORT("sort"),

    /**
     * 评论
     */
    COMMENTS("comments"),

    /**
     * 子任务
     */
    SUBTASK_LIST("subTaskVOList"),

    /**
     * 创建人
     */
    CREATE_BY("createBy"),

    /**
     * 更新人/最后更新人
     */
    UPDATE_BY("updateBy"),

    /**
     * 操作记录
     */
    ACTIVITIES("activities"),
    /**
     * 事项
     */
    ISSUE("issue"),
    /**
     * 项目
     */
    PROJECT("project"),
    /**
     * 创建时间
     */
    CREATE_TIME("createTime"),
    /**
     * 更新时间
     */
    UPDATE_TIME("updateTime"),
    /**
     * 预估工时
     */
    ESTIMATE_LABOUR("estimateLabour"),
    /**
     * 实际工时
     */
    ACTUAL_LABOUR("actualLabour"),
    /**
     * 剩余工时
     */
    REMAINING_LABOUR("remainingLabour"),
    /**
     * 总实际工时（包含子任务）
     */
    TOTAL_ACTUAL_LABOUR("totalActualLabour"),
    /**
     * 总剩余工时（包含子任务）
     */
    TOTAL_REMAINING_LABOUR("totalRemainingLabour"),
    /**
     * 总预估工时（包含子任务）
     */
    TOTAL_ESTIMATE_LABOUR("totalEstimateLabour"),
    /**
     *  剩余工时是否被修改过
     */
    REMAINING_LABOUR_MODIFIED("remainingLabourModified"),

    /**
     * 父任务标题
     */
    PARENT_SUMMARY("parentSummary"),

    /**
     * 项目pkey
     */
    PKEY("pkey"),

    /**
     * 父事项id
     */
    PARENT_LINK_ISSUE("parentLinkIssue"),

    /**
     * 子事项id
     */
    CHILD_LINK_ISSUES("childLinkIssues"),

    /**
     * Figma字段
     */
    FIGMA("figma"),
    ;

    public final String code;
    IssueFieldEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
