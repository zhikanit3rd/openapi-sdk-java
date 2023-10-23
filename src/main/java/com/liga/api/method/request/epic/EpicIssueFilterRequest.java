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
public class EpicIssueFilterRequest implements Pageable {
    @NonNull
    private Long projectId;

    /** 史诗编号 */
    @NonNull
    private Long id;
    private Integer pageNumber;
    private Integer pageSize;
    private String token;
}
