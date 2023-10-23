package com.liga.api.method.response.issue;

import com.liga.api.method.response.user.UserSimpleVO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class IssueSampleResponse {

    /**
     * issue主键编号
     */
    private Long id;

    /**
     * 概要
     */
    private String summary;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 状态id
     */
    private Long statusId;

    /** 状态类别（未开始：2|进行中：3|已完成：4）*/
    private Integer statusType;

    /**
     * 执行人
     */
    private String assigneeName;

    /**
     * 执行人id
     */
    private Long assigneeId;

    /**
     * 执行人信息
     */
    private UserSimpleVO assigneeVO;

    /**
     * 事项类型名称
     */
    private String issueTypeName;

    /**
     * 事项类型id
     */
    private Long issueTypeId;

    /**
     * 事项类型信息
     */
    private IssueTypeSimpleVO issueTypeVO;

    /**
     * 优先级名称
     */
    private String priorityName;

    /**
     * 优先级编号
     */
    private Long priorityId;

    /**
     * 截止时间
     */
    private Date dueDate;

    /**
     * 迭代id
     */
    private Long sprintId;

    /**
     * 迭代名称
     */
    private String sprintName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建人信息
     */
    private UserSimpleVO createByVO;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 更新人信息
     */
    private UserSimpleVO updateByVO;

    /**
     * 标签列表
     */
    private List<TagVO> tags;

    /**
     * 自定义字段数据
     */
    private Map<String, Object> customFieldData;

    @Data
    public static class TagVO{
        /** 主键 */
        private Long id;
        /** 标签名*/
        private String tagName;
    }
}
