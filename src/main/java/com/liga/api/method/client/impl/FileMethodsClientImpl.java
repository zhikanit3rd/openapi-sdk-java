package com.liga.api.method.client.impl;

import com.alibaba.fastjson.TypeReference;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.file.FileBindRequest;
import com.liga.api.method.request.file.FileKeyRequest;
import com.liga.api.method.request.file.FileQueryRequest;
import com.liga.api.method.request.file.FileUploadRequest;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.response.file.FileListResponse;
import com.liga.api.method.response.file.FileUploadResponse;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.client.FileMethodsClient;
import com.liga.api.util.http.LigaHttpClient;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
public class FileMethodsClientImpl implements FileMethodsClient {

    @Setter
    @Getter
    private String endpointUrlPrefix;
    private final LigaHttpClient ligaHttpClient;

    public FileMethodsClientImpl(LigaHttpClient ligaHttpClient) {
        this.ligaHttpClient = ligaHttpClient;
    }

    public FileMethodsClientImpl(String endpointUrlPrefix, LigaHttpClient ligaHttpClient) {
        this.endpointUrlPrefix = endpointUrlPrefix;
        this.ligaHttpClient = ligaHttpClient;
    }

    @Override
    public LigaApiResponse<FileUploadResponse> upload(FileUploadRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postMultipart(this.endpointUrlPrefix  + PREFIX + "/upload",
                request.getToken(), request.getFile());
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, FileUploadResponse.class);
    }

    @Override
    public InputStream download(FileKeyRequest request) throws IOException, LigaApiException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/download", request);
        return this.ligaHttpClient.parseStreamResponseAndRunListeners(response);
    }

    @Override
    public LigaApiResponse<SuccessResponse> remove(FileKeyRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.deleteJsonBody(this.endpointUrlPrefix  + PREFIX + "/remove", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<List<FileListResponse>> list(FileQueryRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/list", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<FileListResponse>>>(){});
    }

    @Override
    public LigaApiResponse<SuccessResponse> bind(FileBindRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/bind", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }
}
