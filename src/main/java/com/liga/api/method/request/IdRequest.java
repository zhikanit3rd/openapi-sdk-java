package com.liga.api.method.request;

import com.liga.api.method.LigaApiRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdRequest implements LigaApiRequest {

    /**
     * 查询相关id
     */
    @NonNull
    private Long id;
    private String token;
}
