package com.liga.api.method.response.issue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomFieldResponse {

    /**
     * 自定义字段编号
     */
    private Long customFieldId;

    /**
     * 字段编码
     */
    private String fieldCode;

    /**
     * 字段名称
     */
    private String customFieldName;

    /**
     * 类型编码
     */
    private String controlCode;

    /**
     * 字段描述
     */
    private String fieldDescription;

    /**
     * 选项值列表
     */
    private List<IssueFieldOptionVO> options;

    /**
     * 是否必填 0:不是 1:是
     */
    private Boolean requiredFlag;

    /**
     * 字段类型，text,datetime,date,
     */
    private String fieldType;

    /**
     * 是否多选
     */
    private Boolean multipleChoice;

    /**
     * 是否默认值
     */
    private Boolean isDefault;

    /**
     * 子字段
     */
    private List<CustomFieldResponse> childFields;
}
