package com.liga.api.method.response.issue;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterConditionFieldResponse {

    /**字段id*/
    private Long customFieldId;

    /**字段编码*/
    private String customFieldCode;

    /**字段名称*/
    private String customFieldName;

    /**字段控件类型*/
    private String controlCode;
}