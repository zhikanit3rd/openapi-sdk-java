package com.liga.api.method.request.issue;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueSelectRequest implements LigaApiRequest {

    private String token;

    /**项目id编号 */
    @NonNull
    private Long projectId;

    /**概要 */
    private String summary;

    /**
     * 下拉选项问题字段
     */
    /**下拉选项字段集合 */
    protected Map<String, List<Long>> selectFields;

    /**时间选项字段集合 */
    protected Map<String, List<Long>> dateFields;

    /**
     * 展示的自定义字段列表
     */
    private Set<String> showedCustomFieldCodes;

    /**状态类别列表（未开始：2|进行中：3|已完成：4） */
    private Set<Integer> statusTypes;

    /**排序字段（createTime|updateTime） */
    private String orderBy;

    /**排序方式（DESC|ASC）, 默认DESC */
    private String sort;
}
