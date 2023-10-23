package com.liga.api.method.client;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.file.FileBindRequest;
import com.liga.api.method.request.file.FileKeyRequest;
import com.liga.api.method.request.file.FileQueryRequest;
import com.liga.api.method.request.file.FileUploadRequest;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.response.file.FileListResponse;
import com.liga.api.method.response.file.FileUploadResponse;
import com.liga.api.method.LigaApiException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface FileMethodsClient {

    String PREFIX = "file";

    /**
     * 上传文件
     * @param request
     * @return
     */
    LigaApiResponse<FileUploadResponse> upload(FileUploadRequest request) throws LigaApiException, IOException;

    /**
     * 下载文件
     * @param request
     * @return
     */
    InputStream download(FileKeyRequest request) throws IOException, LigaApiException;

    /**
     * 删除文件
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> remove(FileKeyRequest request) throws LigaApiException, IOException;

    /**
     * 获取文件列表
     * @param request
     * @return
     */
    LigaApiResponse<List<FileListResponse>> list(FileQueryRequest request) throws LigaApiException, IOException;

    /**
     * 绑定文件
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> bind(FileBindRequest request) throws LigaApiException, IOException;
}
