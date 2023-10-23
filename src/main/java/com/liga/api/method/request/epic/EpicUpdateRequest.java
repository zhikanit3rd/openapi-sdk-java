package com.liga.api.method.request.epic;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EpicUpdateRequest implements LigaApiRequest {

    private String token;

    /**
     * 史诗ID
     */
    @NonNull
    private Long id;

    /**
     * 史诗字段集合数据
     */
    @NonNull
    private Map<String, Object> data;
}
