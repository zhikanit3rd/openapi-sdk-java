package com.liga.api.method.client;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.TokenRequest;
import com.liga.api.method.request.issue.FilterSelectOptionsRequest;
import com.liga.api.method.request.issue.IssueAddRequest;
import com.liga.api.method.request.issue.IssueBatchAddRequest;
import com.liga.api.method.request.issue.IssueBatchRemoveRequest;
import com.liga.api.method.request.issue.IssueBatchUpdateRequest;
import com.liga.api.method.request.issue.IssueFieldRequest;
import com.liga.api.method.request.issue.IssueFinishedRequest;
import com.liga.api.method.request.issue.IssueLabourListSelectionRequest;
import com.liga.api.method.request.issue.IssueLabourRecordAddRequest;
import com.liga.api.method.request.issue.IssueLabourRecordRequest;
import com.liga.api.method.request.issue.IssueNumberRequest;
import com.liga.api.method.request.issue.IssueRelationshipRequest;
import com.liga.api.method.request.issue.IssueSelectRequest;
import com.liga.api.method.request.issue.IssueSubTaskBatchAddRequest;
import com.liga.api.method.request.issue.IssueSubTaskRemoveRequest;
import com.liga.api.method.request.issue.IssueTrashRequest;
import com.liga.api.method.request.issue.IssueTypeRequest;
import com.liga.api.method.request.issue.IssueUpdateRequest;
import com.liga.api.method.request.issue.UpdateSubtaskStatusRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.response.IdResponse;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.response.issue.CustomFieldResponse;
import com.liga.api.method.response.issue.FilterConditionFieldResponse;
import com.liga.api.method.response.issue.IssueAddResponse;
import com.liga.api.method.response.issue.IssueBatchAddResponse;
import com.liga.api.method.response.issue.IssueFieldsResponse;
import com.liga.api.method.response.issue.IssueFinishedResponse;
import com.liga.api.method.response.issue.IssueRelationshipResponse;
import com.liga.api.method.response.issue.IssueRemoveWithReasonResponse;
import com.liga.api.method.response.issue.IssueResponse;
import com.liga.api.method.response.issue.IssueSampleResponse;
import com.liga.api.method.response.issue.IssueSubTaskResponse;
import com.liga.api.method.response.issue.IssueTypeResponse;
import com.liga.api.method.response.issue.OptionFieldFilterResponse;
import com.liga.api.method.response.issue.TrashFilterResponse;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.response.issue.IssueLabourRecordDetailResponse;
import com.liga.api.method.response.issue.IssueSchemeResponse;
import com.liga.api.method.response.issue.IssueSubTaskFieldResponse;
import com.liga.api.method.response.issue.IssueTrashResponse;
import com.liga.api.method.response.issue.IssueUpdateResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface IssueMethodsClient {

    String PREFIX = "issue";

    /**
     * 获取issue类型列表
     * @param request
     * @return
     */
    LigaApiResponse<List<IssueTypeResponse>> typeList(ProjectIdRequest request) throws LigaApiException, IOException;

    /**
     * 获取issue模版
     * @param request
     * @return
     */
    LigaApiResponse<IssueSchemeResponse>  issueScheme(IssueTypeRequest request) throws LigaApiException, IOException;

    /**
     * 获取issue的字段列表
     * @param request
     * @return
     */
    LigaApiResponse<IssueFieldsResponse> issueFields(IssueTypeRequest request) throws LigaApiException, IOException;

    /**
     * 获取issue的字段详情
     * @param request
     * @return
     */
    LigaApiResponse<CustomFieldResponse> issueFieldInfo(IssueFieldRequest request) throws LigaApiException, IOException;

    /**
     * 批量新建issue
     * @param request
     * @return
     */
    LigaApiResponse<List<IssueAddResponse>> batchAdd(IssueBatchAddRequest request) throws LigaApiException, IOException;

    /**
     * 新建issue
     * @param request
     * @return
     */
    LigaApiResponse<IdResponse> add(IssueAddRequest request) throws LigaApiException, IOException;

    /**
     * 批量更新issue
     * @param request
     * @return
     */
    LigaApiResponse<List<IssueUpdateResponse>> batchUpdate(IssueBatchUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 更新issue
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> update(IssueUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 获取issue详情
     * @param request
     * @return
     */
    LigaApiResponse<IssueResponse> get(IdRequest request) throws LigaApiException, IOException;

    /**
     *根据issue编号获取详情
     * @param request
     * @return
     */
    LigaApiResponse<IssueResponse> getByIssueNumber(IssueNumberRequest request) throws LigaApiException, IOException;

    /**
     * 删除issue
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> remove(IdRequest request) throws LigaApiException, IOException;

    /**
     * 批量删除issue
     * @param request
     * @return
     */
    LigaApiResponse<List<IssueRemoveWithReasonResponse>> batchRemove(IssueBatchRemoveRequest request) throws LigaApiException, IOException;

    /**
     * issue列表
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<IssueSampleResponse>> page(IssueSelectRequest request) throws LigaApiException, IOException;

    /**
     * 获取项目下所有的筛选条件
     * @param request
     * @return
     */
    LigaApiResponse<List<FilterConditionFieldResponse>> filterConditionField(ProjectIdRequest request) throws LigaApiException, IOException;

    /**
     * 获取字段的下拉选项
     * @param request
     * @return
     */
    LigaApiResponse<List<OptionFieldFilterResponse>> selectOptions(FilterSelectOptionsRequest request) throws LigaApiException, IOException;

    /**
     * 获取事项的关联事项列表
     * @param request
     * @return
     */
    LigaApiResponse<List<IssueRelationshipResponse>> relationshipList(IdRequest request) throws LigaApiException, IOException;

    /**
     * 事项添加关联
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> addRelationship(IssueRelationshipRequest request) throws LigaApiException, IOException;

    /**
     * 事项移除关联
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> removeRelationship(IssueRelationshipRequest request) throws LigaApiException, IOException;

    /**
     * 批量新建子任务
     * @param request
     * @return
     */
    LigaApiResponse<IssueBatchAddResponse> batchAddSubTask(IssueSubTaskBatchAddRequest request) throws LigaApiException, IOException;

    /**
     * 删除子任务
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> removeSubTask(IssueSubTaskRemoveRequest request) throws LigaApiException, IOException;

    /**
     * 更新子任务
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> updateSubTask(IssueUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 获取子任务列表
     * @param request
     * @return
     */
    LigaApiResponse<List<IssueSubTaskResponse>> listSubTask(IdRequest request) throws LigaApiException, IOException;

    /**
     * 更新子任务状态
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> updateSubTaskStatus(UpdateSubtaskStatusRequest request) throws LigaApiException, IOException;

    /**
     * 获取子任务可修改字段列表
     * @param request
     * @return
     */
    LigaApiResponse<List<IssueSubTaskFieldResponse>> listSubTaskField(IssueTypeRequest request) throws LigaApiException, IOException;

    /**
     * 新建工时登记
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> labourRecordAdd(IssueLabourRecordAddRequest request) throws LigaApiException, IOException;

    /**
     * 更新工时登记
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> labourRecordUpdate(IssueLabourRecordRequest request) throws LigaApiException, IOException;

    /**
     * 删除工时登记
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> labourRecordDelete(IdRequest request) throws LigaApiException, IOException;

    /**
     * 工时登记分页查询
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<IssueLabourRecordDetailResponse>> labourRecordPage(IssueLabourListSelectionRequest request) throws LigaApiException, IOException;


    /**
     * 获取回收站下拉选项列表（免费版本暂不支持）
     * @param request
     * @return
     */
    LigaApiResponse<TrashFilterResponse> trashSelectOptions(TokenRequest request) throws LigaApiException, IOException;

    /**
     * 回收站列表（免费版本暂不支持）
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<IssueTrashResponse>> trashPage(IssueTrashRequest request) throws LigaApiException, IOException;

    /**
     * 恢复issue（免费版本暂不支持）
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> restoreIssue(IdRequest request) throws LigaApiException, IOException;

    /**
     * 已完成issue列表
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<IssueFinishedResponse>> pageFinished(IssueFinishedRequest request) throws LigaApiException, IOException;

}
