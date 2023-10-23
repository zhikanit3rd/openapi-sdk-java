package com.liga.api.method.request.epic;

import com.liga.api.method.request.Pageable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EpicFilterRequest implements Pageable {

    @NonNull
    private Long projectId;

    /**
     * 标题关键字
     */
    private String keyword;

    /**
     * 负责人
     */
    private Long owner;

    /**
     * 状态
     */
    private Long status;
    private Integer pageNumber;
    private Integer pageSize;
    private String token;
}
