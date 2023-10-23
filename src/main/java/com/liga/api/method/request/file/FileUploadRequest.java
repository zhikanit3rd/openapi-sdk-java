package com.liga.api.method.request.file;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadRequest implements LigaApiRequest {

    private String token;

    /**
     * 文件
     */
    private File file;
}
