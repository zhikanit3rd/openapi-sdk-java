package com.liga.api.method.client.impl;

import com.alibaba.fastjson.TypeReference;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.sprint.SprintAddRequest;
import com.liga.api.method.request.sprint.SprintIdRequest;
import com.liga.api.method.request.sprint.SprintUpdateRequest;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.client.SprintMethodsClient;
import com.liga.api.method.response.sprint.SprintCountResponse;
import com.liga.api.method.response.sprint.SprintResponse;
import com.liga.api.util.http.LigaHttpClient;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
public class SprintMethodsClientImpl implements SprintMethodsClient {

    @Setter
    @Getter
    private String endpointUrlPrefix;
    private final LigaHttpClient ligaHttpClient;

    public SprintMethodsClientImpl(LigaHttpClient ligaHttpClient) {
        this.ligaHttpClient = ligaHttpClient;
    }

    public SprintMethodsClientImpl(String endpointUrlPrefix, LigaHttpClient ligaHttpClient) {
        this.endpointUrlPrefix = endpointUrlPrefix;
        this.ligaHttpClient = ligaHttpClient;
    }

    @Override
    public LigaApiResponse<SprintResponse> add(SprintAddRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/add", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SprintResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> update(SprintUpdateRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.patchJsonBody(this.endpointUrlPrefix  + PREFIX + "/update", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> remove(SprintIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/remove", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<SprintResponse> get(IdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/get", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SprintResponse.class);
    }

    @Override
    public LigaApiResponse<List<SprintCountResponse>> listWithCount(ProjectIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/list-with-count", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<SprintCountResponse>>>(){});
    }
}
