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
public class EpicAddRequest implements LigaApiRequest {

    private String token;
    @NonNull
    protected Long projectId;

    /**
     * 史诗字段集合数据
     */
    @NonNull
    protected Map<String, Object> data;
}
