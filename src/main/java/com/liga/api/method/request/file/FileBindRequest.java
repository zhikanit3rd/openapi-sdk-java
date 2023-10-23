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
public class FileBindRequest implements LigaApiRequest {

    private String token;

    /**
     * 文件key
     */
    @NonNull
    private String fileKey;

    /**
     * 关联模块, issue
     */
    @NonNull
    private String linkModule;

    /**
     * 关联实体, attachment
     */
    @NonNull
    private String linkEntity;

    /**
     * 关联id
     */
    @NonNull
    private Long linkId;
}
