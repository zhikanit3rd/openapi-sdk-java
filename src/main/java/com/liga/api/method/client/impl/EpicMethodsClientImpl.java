package com.liga.api.method.client.impl;

import com.alibaba.fastjson.TypeReference;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.epic.EpicAddRequest;
import com.liga.api.method.request.epic.EpicFieldRequest;
import com.liga.api.method.request.epic.EpicFilterRequest;
import com.liga.api.method.request.epic.EpicIssueFilterRequest;
import com.liga.api.method.request.epic.EpicRelationIssueRequest;
import com.liga.api.method.request.epic.EpicUpdateRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.response.IdResponse;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.response.epic.EpicFilterOptionsResponse;
import com.liga.api.method.response.epic.EpicIssueResponse;
import com.liga.api.method.response.epic.EpicResponse;
import com.liga.api.method.response.issue.CustomFieldResponse;
import com.liga.api.method.response.issue.IssueFieldsResponse;
import com.liga.api.method.response.issue.IssueResponse;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.client.EpicMethodsClient;
import com.liga.api.util.http.LigaHttpClient;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
public class EpicMethodsClientImpl implements EpicMethodsClient {

    @Setter
    @Getter
    private String endpointUrlPrefix;
    private final LigaHttpClient ligaHttpClient;

    public EpicMethodsClientImpl(LigaHttpClient ligaHttpClient) {
        this.ligaHttpClient = ligaHttpClient;
    }

    public EpicMethodsClientImpl(String endpointUrlPrefix, LigaHttpClient ligaHttpClient) {
        this.endpointUrlPrefix = endpointUrlPrefix;
        this.ligaHttpClient = ligaHttpClient;
    }

    @Override
    public LigaApiResponse<EpicFilterOptionsResponse> filterOptions(ProjectIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/filter-options", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, EpicFilterOptionsResponse.class);
    }

    @Override
    public LigaApiResponse<PageDataList<EpicResponse>> page(EpicFilterRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/page", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<PageDataList<EpicResponse>>>(){});
    }

    @Override
    public LigaApiResponse<PageDataList<EpicIssueResponse>> pageIssue(EpicIssueFilterRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/page-issue", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<PageDataList<EpicIssueResponse>>>(){});
    }

    @Override
    public LigaApiResponse<IssueFieldsResponse> epicFields(ProjectIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/epic-fields", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IssueFieldsResponse.class);
    }

    @Override
    public LigaApiResponse<CustomFieldResponse> epicFieldInfo(EpicFieldRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/epic-field-info", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, CustomFieldResponse.class);
    }

    @Override
    public LigaApiResponse<IdResponse> add(EpicAddRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/add", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IdResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> update(EpicUpdateRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/update", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> remove(IdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/remove", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<IssueResponse> detail(IdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/detail", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IssueResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> relationIssue(EpicRelationIssueRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/relation-issue", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }
}
