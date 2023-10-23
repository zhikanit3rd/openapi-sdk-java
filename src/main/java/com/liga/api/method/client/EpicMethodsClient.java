package com.liga.api.method.client;

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

import java.io.IOException;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface EpicMethodsClient {

    String PREFIX = "epic";

    /**
     * 史诗过滤选项值
     * @param request
     * @return
     */
    LigaApiResponse<EpicFilterOptionsResponse> filterOptions(ProjectIdRequest request) throws LigaApiException, IOException;

    /**
     * 史诗列表
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<EpicResponse>> page(EpicFilterRequest request) throws LigaApiException, IOException;

    /**
     * 史诗关联事项列表
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<EpicIssueResponse>> pageIssue(EpicIssueFilterRequest request) throws LigaApiException, IOException;

    /**
     * 获取史诗字段列表
     * @param request
     * @return
     */
    LigaApiResponse<IssueFieldsResponse> epicFields(ProjectIdRequest request) throws LigaApiException, IOException;

    /**
     * 获取史诗字段详情
     * @param request
     * @return
     */
    LigaApiResponse<CustomFieldResponse> epicFieldInfo(EpicFieldRequest request) throws LigaApiException, IOException;

    /**
     * 新建史诗
     * @param request
     * @return
     */
    LigaApiResponse<IdResponse> add(EpicAddRequest request) throws LigaApiException, IOException;

    /**
     * 更新史诗
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> update(EpicUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 删除史诗
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> remove(IdRequest request) throws LigaApiException, IOException;

    /**
     * 获取史诗详情
     * @param request
     * @return
     */
    LigaApiResponse<IssueResponse> detail(IdRequest request) throws LigaApiException, IOException;

    /**
     * 史诗关联事项
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> relationIssue(EpicRelationIssueRequest request) throws LigaApiException, IOException;
}
