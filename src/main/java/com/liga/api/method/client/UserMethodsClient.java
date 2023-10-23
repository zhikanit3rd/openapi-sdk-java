package com.liga.api.method.client;

import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.user.ProjectUserListRequest;
import com.liga.api.method.request.user.ProjectUserMembersRequest;
import com.liga.api.method.request.user.ProjectUserPageRequest;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.response.user.ProjectUserResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface UserMethodsClient {

    String PREFIX = "user";

    /**
     * 获取项目的用户列表（不进行分页）
     * @param request
     * @return
     */
    LigaApiResponse<List<ProjectUserResponse>> projectUserList(ProjectUserListRequest request) throws LigaApiException, IOException;

    /**
     * 获取项目的用户列表（进行分页）
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<ProjectUserResponse>> projectUserPage(ProjectUserPageRequest request) throws IOException, LigaApiException;

    /**
     * 批量添加项目用户
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> addMembers(ProjectUserMembersRequest request) throws LigaApiException, IOException;

    /**
     * 批量移除项目中的用户
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> removeMembers(ProjectUserMembersRequest request) throws LigaApiException, IOException;
}
