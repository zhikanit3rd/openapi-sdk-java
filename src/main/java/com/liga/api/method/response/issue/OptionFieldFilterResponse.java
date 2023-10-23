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
public class OptionFieldFilterResponse {
    
    /**字段id */
    private Long customFieldId;

    /**字段筛选值 */
    private List<IssueFieldOptionVO> filterOptionVOList;
}
