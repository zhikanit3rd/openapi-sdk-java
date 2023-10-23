package com.liga.api.method.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdResponse{

    /**
     * 查询相关id
     */
    @NonNull
    private Long id;
}
