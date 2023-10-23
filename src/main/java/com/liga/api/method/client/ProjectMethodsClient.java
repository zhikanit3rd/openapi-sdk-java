package com.liga.api.method.client;

import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.TokenRequest;
import com.liga.api.method.request.project.ProjectAddRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.project.ProjectKeyRequest;
import com.liga.api.method.request.project.ProjectUpdateRequest;
import com.liga.api.method.request.project.ProjectUserRoleSetRequest;
import com.liga.api.method.response.IdResponse;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.response.project.ProjectNameReponse;
import com.liga.api.method.response.project.ProjectResponse;
import com.liga.api.method.response.project.ProjectSchemeResponse;
import com.liga.api.method.response.project.ProjectTemplateResponse;
import com.liga.api.method.response.project.RoleResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface ProjectMethodsClient {

    String PREFIX = "project";

    /**
     * 项目模板列表
     * @param request
     * @return
     */
    LigaApiResponse<List<ProjectTemplateResponse>> projectTemplate(TokenRequest request) throws LigaApiException, IOException;

    /**
     * 获取项目列表
     * @param request
     * @return
     */
    LigaApiResponse<List<ProjectNameReponse>> list(TokenRequest request) throws LigaApiException, IOException;

    /**
     * 获取项目概览模版
     * @param request
     * @return
     */
    LigaApiResponse<ProjectSchemeResponse> projectOverviewScheme(ProjectIdRequest request) throws LigaApiException, IOException;

    /**
     * 新建项目
     * @param request
     * @return
     */
    LigaApiResponse<IdResponse> add(ProjectAddRequest request) throws LigaApiException, IOException;

    /**
     * 更新项目
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> update(ProjectUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 获取项目信息
     * @param request
     * @return
     */
    LigaApiResponse<ProjectResponse> get(ProjectIdRequest request) throws LigaApiException, IOException;

    /**
     * 根据项目key获取项目信息
     * @param request
     * @return
     */
    LigaApiResponse<ProjectResponse> getByProjectKey(ProjectKeyRequest request) throws LigaApiException, IOException;

    /**
     * 更改用户的角色
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> roleChange(ProjectUserRoleSetRequest request) throws LigaApiException, IOException;

    /**
     * 获取项目角色列表
     * @param request
     * @return
     */
    LigaApiResponse<List<RoleResponse>> roleType(TokenRequest request) throws LigaApiException, IOException;
}
