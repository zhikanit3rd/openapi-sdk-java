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
public class FileKeyRequest implements LigaApiRequest {

    private String token;

    /**
     * 文件key
     */
    @NonNull
    private String fileKey;
}
