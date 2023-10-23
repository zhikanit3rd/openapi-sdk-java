package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.file.FileBindRequest;
import com.liga.api.method.request.file.FileKeyRequest;
import com.liga.api.method.request.file.FileQueryRequest;
import com.liga.api.method.request.file.FileUploadRequest;
import com.liga.api.method.response.file.FileUploadResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class FileMethodsClientImplTest extends AbstractLigaWithToken {

    @Test
    void upload() throws LigaApiException, IOException {

        File file = new File("src/test/resources/updateFile.txt");
        assertLigaApiResponseSuccess(liga.file().upload(FileUploadRequest.builder().token(token).file(file).build()));
    }

    @Test
    void download() throws LigaApiException, IOException {

        File out = new File("src/test/resources/downloadFile.txt");
        InputStream inputStream = liga.file().download(FileKeyRequest.builder().token(token).fileKey("a206b57b10694088beaf32b0dd49a1bb").build());
        byte[] buffer = new byte[1024];
        int len = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(out);
        while ((len = inputStream.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0, len);
        }
        inputStream.close();
        fileOutputStream.close();

        Assertions.assertTrue(out.exists());
        out.delete();
    }

    @Test
    void remove() throws LigaApiException, IOException {
        File file = new File("src/test/resources/updateFile.txt");
        LigaApiResponse<FileUploadResponse> uploadResponseLigaApiResponse = liga.file().upload(FileUploadRequest.builder().token(token).file(file).build());
        assertLigaApiResponseSuccess(liga.file().remove(
                FileKeyRequest.builder()
                        .token(token)
                        .fileKey(uploadResponseLigaApiResponse.getData().getFileKey()).build()
        ));
    }

    @Test
    void bind() throws LigaApiException, IOException {
        File file = new File("src/test/resources/updateFile.txt");
        LigaApiResponse<FileUploadResponse> uploadResponseLigaApiResponse = liga.file().upload(FileUploadRequest.builder().token(token).file(file).build());
        assertLigaApiResponseSuccess(liga.file().bind(FileBindRequest.builder()
                .token(token)
                .fileKey(uploadResponseLigaApiResponse.getData().getFileKey())
                .linkEntity("attachment")
                .linkModule("issue")
                .linkId(209475346L)
                .build()));
    }

    @Test
    void list() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.file().list(
                FileQueryRequest.builder()
                        .linkEntity("attachment")
                        .linkModule("issue")
                        .linkId(209475346L)
                        .token(token)
                        .build()
        ));
    }

}