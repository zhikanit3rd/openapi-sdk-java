package com.liga.api.method.client.impl;

import com.alibaba.fastjson.TypeReference;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.TokenRequest;
import com.liga.api.method.request.project.ProjectAddRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.project.ProjectKeyRequest;
import com.liga.api.method.request.project.ProjectUpdateRequest;
import com.liga.api.method.request.project.ProjectUserRoleSetRequest;
import com.liga.api.method.response.IdResponse;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.client.ProjectMethodsClient;
import com.liga.api.method.response.project.ProjectNameReponse;
import com.liga.api.method.response.project.ProjectResponse;
import com.liga.api.method.response.project.ProjectSchemeResponse;
import com.liga.api.method.response.project.ProjectTemplateResponse;
import com.liga.api.method.response.project.RoleResponse;
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
public class ProjectMethodsClientImpl implements ProjectMethodsClient {

    @Setter
    @Getter
    private String endpointUrlPrefix;
    private final LigaHttpClient ligaHttpClient;

    public ProjectMethodsClientImpl(LigaHttpClient ligaHttpClient) {
        this.ligaHttpClient = ligaHttpClient;
    }

    public ProjectMethodsClientImpl(String endpointUrlPrefix, LigaHttpClient ligaHttpClient) {
        this.endpointUrlPrefix = endpointUrlPrefix;
        this.ligaHttpClient = ligaHttpClient;
    }

    @Override
    public LigaApiResponse<List<ProjectTemplateResponse>> projectTemplate(TokenRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/project-template", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<ProjectTemplateResponse>>>(){});
    }

    @Override
    public LigaApiResponse<List<ProjectNameReponse>> list(TokenRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/list", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<ProjectNameReponse>>>(){});
    }

    @Override
    public LigaApiResponse<ProjectSchemeResponse> projectOverviewScheme(ProjectIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/project-overview-scheme", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, ProjectSchemeResponse.class);
    }

    @Override
    public LigaApiResponse<IdResponse> add(ProjectAddRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/add", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IdResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> update(ProjectUpdateRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.patchJsonBody(this.endpointUrlPrefix  + PREFIX + "/update", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<ProjectResponse> getByProjectKey(ProjectKeyRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/get-by-project-key", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, ProjectResponse.class);
    }


    @Override
    public LigaApiResponse<ProjectResponse> get(ProjectIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/get", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, ProjectResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> roleChange(ProjectUserRoleSetRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/role-change", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<List<RoleResponse>> roleType(TokenRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/role-type", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<RoleResponse>>>(){});
    }
}
