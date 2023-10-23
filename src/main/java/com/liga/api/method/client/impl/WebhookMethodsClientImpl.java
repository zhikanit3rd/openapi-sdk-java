package com.liga.api.method.client.impl;

import com.alibaba.fastjson.TypeReference;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.client.WebhookMethodsClient;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.webhook.WebhookAddRequest;
import com.liga.api.method.request.webhook.WebhookIdRequest;
import com.liga.api.method.request.webhook.WebhookPageQueryRequest;
import com.liga.api.method.request.webhook.WebhookUpdateRequest;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.response.webhook.EventResponse;
import com.liga.api.method.response.webhook.WebhookInfoResponse;
import com.liga.api.method.response.webhook.WebhookTypeResponse;
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
public class WebhookMethodsClientImpl implements WebhookMethodsClient {

    @Setter
    @Getter
    private String endpointUrlPrefix;
    private final LigaHttpClient ligaHttpClient;

    public WebhookMethodsClientImpl(LigaHttpClient ligaHttpClient) {
        this.ligaHttpClient = ligaHttpClient;
    }

    public WebhookMethodsClientImpl(String endpointUrlPrefix, LigaHttpClient ligaHttpClient) {
        this.endpointUrlPrefix = endpointUrlPrefix;
        this.ligaHttpClient = ligaHttpClient;
    }

    @Override
    public LigaApiResponse<List<WebhookTypeResponse>> listTypes(ProjectIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/list-types", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<WebhookTypeResponse>>>(){});
    }

    @Override
    public LigaApiResponse<List<EventResponse>> listEvents(ProjectIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/list-events", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<EventResponse>>>(){});
    }

    @Override
    public LigaApiResponse<WebhookInfoResponse> add(WebhookAddRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/add", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, WebhookInfoResponse.class);
    }

    @Override
    public LigaApiResponse<WebhookInfoResponse> delete(WebhookIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.deleteJsonBody(this.endpointUrlPrefix  + PREFIX + "/delete", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, WebhookInfoResponse.class);
    }

    @Override
    public LigaApiResponse<WebhookInfoResponse> update(WebhookUpdateRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.patchJsonBody(this.endpointUrlPrefix  + PREFIX + "/update", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, WebhookInfoResponse.class);
    }

    @Override
    public LigaApiResponse<WebhookInfoResponse> get(WebhookIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/get", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, WebhookInfoResponse.class);
    }

    @Override
    public LigaApiResponse<PageDataList<WebhookInfoResponse>> page(WebhookPageQueryRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/page", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<PageDataList<WebhookInfoResponse>>>(){});
    }
}
