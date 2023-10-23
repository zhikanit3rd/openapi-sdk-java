package com.liga.api.method.client.impl;

import com.alibaba.fastjson.TypeReference;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.client.UserMethodsClient;
import com.liga.api.method.request.user.ProjectUserListRequest;
import com.liga.api.method.request.user.ProjectUserMembersRequest;
import com.liga.api.method.request.user.ProjectUserPageRequest;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.response.user.ProjectUserResponse;
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
public class UserMethodsClientImpl implements UserMethodsClient {

    @Setter
    @Getter
    private String endpointUrlPrefix;
    private final LigaHttpClient ligaHttpClient;

    public UserMethodsClientImpl(LigaHttpClient ligaHttpClient) {
        this.ligaHttpClient = ligaHttpClient;
    }

    public UserMethodsClientImpl(String endpointUrlPrefix, LigaHttpClient ligaHttpClient) {
        this.endpointUrlPrefix = endpointUrlPrefix;
        this.ligaHttpClient = ligaHttpClient;
    }


    @Override
    public LigaApiResponse<List<ProjectUserResponse>> projectUserList(ProjectUserListRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/project-user-list", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, new TypeReference<LigaApiResponse<List<ProjectUserResponse>>>(){});
    }

    @Override
    public LigaApiResponse<PageDataList<ProjectUserResponse>> projectUserPage(ProjectUserPageRequest request) throws IOException, LigaApiException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/project-user-page", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<PageDataList<ProjectUserResponse>>>(){});
    }

    @Override
    public LigaApiResponse<SuccessResponse> addMembers(ProjectUserMembersRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/add-members", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> removeMembers(ProjectUserMembersRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.deleteJsonBody(this.endpointUrlPrefix  + PREFIX + "/remove-members", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }
}
