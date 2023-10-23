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
public class IssueBatchAddResponse {

    /** issue */
    List<IssueAddVO> issueAddVOList;

    @Data
    public static class IssueAddVO{
        /** issue编号 */
        private Long id;
    }
}
