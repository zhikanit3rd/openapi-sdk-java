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
public class IssueFieldsResponse {

    /** 字段列表 */
    private List<IssueFieldVO> fields;
    
    @Data
    public static class IssueFieldVO {
        /**字段名称*/
        private String fieldName;

        /**字段编码*/
        private String fieldCode;
    }
}
