package com.liga.api.method.client;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.org.AllMemberListRequest;
import com.liga.api.method.request.org.UserIdRequest;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.response.org.AllMemberListResponse;
import com.liga.api.method.LigaApiException;

import java.io.IOException;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface OrgMethodsClient {

    String PREFIX = "org";

    /**
     * 获取组织的人员信息（分页）
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<AllMemberListResponse>> allMemberList(AllMemberListRequest request) throws LigaApiException, IOException;

    /**
     * 启用组织的某个用户
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> enableOrgUser(UserIdRequest request) throws LigaApiException, IOException;

    /**
     * 禁用组织的某个用户
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> disableOrgUser(UserIdRequest request) throws LigaApiException, IOException;

    /**
     * 移除组织的某个用户
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> removeOrgUser(UserIdRequest request) throws LigaApiException, IOException;
}
