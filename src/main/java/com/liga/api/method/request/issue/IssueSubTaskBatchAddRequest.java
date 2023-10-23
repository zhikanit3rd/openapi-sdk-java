package com.liga.api.method.request.issue;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueSubTaskBatchAddRequest implements LigaApiRequest {

    private String token;

    /** issue编号 */
    @NonNull
    private Long issueId;

    /** 修改字段列表 */
    @NonNull
    private List<Map<String, Object>> datas;
}
