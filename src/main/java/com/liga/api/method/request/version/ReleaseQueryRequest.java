package com.liga.api.method.request.version;

import com.liga.api.method.request.Pageable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseQueryRequest implements Pageable {

    /**版本名称*/
    private String name;

    /**状态*/
    private List<String> statusList;

    /**负责人id*/
    private List<Long> ownerIds;
    private Integer pageNumber;
    private Integer pageSize;
    private String token;
}