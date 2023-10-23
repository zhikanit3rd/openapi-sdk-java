package com.liga.api.method.client;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.TokenRequest;
import com.liga.api.method.request.version.PageAssociateRequest;
import com.liga.api.method.request.version.ReleaseAddRequest;
import com.liga.api.method.request.version.ReleaseAssociateRequest;
import com.liga.api.method.request.version.ReleaseStatusUpdateRequest;
import com.liga.api.method.request.version.ReleaseUpdateRequest;
import com.liga.api.method.response.IdResponse;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.response.version.OptionalOwnerListResponse;
import com.liga.api.method.response.version.ReleaseDetailResponse;
import com.liga.api.method.response.version.ReleaseIssueResponse;
import com.liga.api.method.response.version.ReleaseStatusResponse;
import com.liga.api.method.response.version.ReleaseResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface VersionMethodsClient {

    String PREFIX = "version";

    /**
     * 获取版本的状态列表
     * @param request
     * @return
     */
    LigaApiResponse<List<ReleaseStatusResponse>> versionStatusList(TokenRequest request) throws LigaApiException, IOException;

    /**
     * 获取版本可供选择的人员
     * @param request
     * @return
     */
    LigaApiResponse<List<OptionalOwnerListResponse>> optionalOwnerList(TokenRequest request) throws LigaApiException, IOException;

    /**
     * 获取所有的版本信息
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<ReleaseResponse>> allVersion(TokenRequest request) throws LigaApiException, IOException;

    /**
     * 新建版本
     * @param request
     * @return
     */
    LigaApiResponse<IdResponse> add(ReleaseAddRequest request) throws LigaApiException, IOException;

    /**
     * 更新版本
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> update(ReleaseUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 删除版本
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> remove(IdRequest request) throws LigaApiException, IOException;

    /**
     * 发布版本
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> release(ReleaseStatusUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 取消发布版本
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> unrelease(IdRequest request) throws LigaApiException, IOException;

    /**
     * 归档版本
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> archive(IdRequest request) throws LigaApiException, IOException;

    /**
     * 取消归档版本
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> unarchive(IdRequest request) throws LigaApiException, IOException;


    /**
     * 获取版本的详情
     * @param request
     * @return
     */
    LigaApiResponse<ReleaseDetailResponse> detail(IdRequest request) throws LigaApiException, IOException;

    /**
     * 添加事项与版本的关联
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> associateIssues(ReleaseAssociateRequest request) throws LigaApiException, IOException;

    /**
     * 解除事项与版本的关联
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> disassociateIssues(ReleaseAssociateRequest request) throws LigaApiException, IOException;

    /**
     * 获取版本关联issue列表
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<ReleaseIssueResponse>> pageAssociate(PageAssociateRequest request) throws LigaApiException, IOException;
}
