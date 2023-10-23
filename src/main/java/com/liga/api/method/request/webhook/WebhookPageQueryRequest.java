package com.liga.api.method.request.webhook;

import com.liga.api.method.request.Pageable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebhookPageQueryRequest implements Pageable {
    /**项目编号*/
    @NonNull
    private Long projectId;

    /**名称*/
    private String name;

    /**创建人ID集合 */
    private Set<Long> createByIdSet;

    /**webhook类型编码 */
    private Set<String> type;

    /**启用状态(enabled: 启用, disabled: 禁用) */
    private String state;

    /**创建时间排序规则（ASC=正序；DESC=倒序） */
    private String createTimeOrderBy = "DESC";
    private Integer pageNumber;
    private Integer pageSize;
    private String token;
}
