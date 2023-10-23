package com.liga.api.method.request.file;

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
public class FileQueryRequest implements LigaApiRequest {

    /**
     * 关联模块, issue
     */
    private String linkModule;

    /**
     * 关联实体, attachment
     */
    private String linkEntity;

    /**
     * 关联id
     */
    @NonNull
    private Long linkId;
    private String token;
}
