package com.liga.api.method.client.impl;

import com.alibaba.fastjson.TypeReference;
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
import com.liga.api.method.client.IssueMethodsClient;
import com.liga.api.method.response.issue.IssueLabourRecordDetailResponse;
import com.liga.api.method.response.issue.IssueSchemeResponse;
import com.liga.api.method.response.issue.IssueSubTaskFieldResponse;
import com.liga.api.method.response.issue.IssueTrashResponse;
import com.liga.api.method.response.issue.IssueUpdateResponse;
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
public class IssueMethodsClientImpl implements IssueMethodsClient {

    @Setter
    @Getter
    private String endpointUrlPrefix;
    private final LigaHttpClient ligaHttpClient;

    public IssueMethodsClientImpl(LigaHttpClient ligaHttpClient) {
        this.ligaHttpClient = ligaHttpClient;
    }

    public IssueMethodsClientImpl(String endpointUrlPrefix, LigaHttpClient ligaHttpClient) {
        this.endpointUrlPrefix = endpointUrlPrefix;
        this.ligaHttpClient = ligaHttpClient;
    }

    @Override
    public LigaApiResponse<List<IssueTypeResponse>> typeList(ProjectIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/type-list", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<IssueTypeResponse>>>(){});
    }

    @Override
    public LigaApiResponse<IssueSchemeResponse> issueScheme(IssueTypeRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/issue-scheme", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IssueSchemeResponse.class);
    }

    @Override
    public LigaApiResponse<IssueFieldsResponse> issueFields(IssueTypeRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/issue-fields", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IssueFieldsResponse.class);
    }

    @Override
    public LigaApiResponse<CustomFieldResponse> issueFieldInfo(IssueFieldRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/issue-field-info", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, CustomFieldResponse.class);
    }

    @Override
    public LigaApiResponse<List<IssueAddResponse>> batchAdd(IssueBatchAddRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/batch-add", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<IssueAddResponse>>>(){});
    }

    @Override
    public LigaApiResponse<IdResponse> add(IssueAddRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/add", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IdResponse.class);
    }

    @Override
    public LigaApiResponse<List<IssueUpdateResponse>> batchUpdate(IssueBatchUpdateRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.patchJsonBody(this.endpointUrlPrefix  + PREFIX + "/batch-update", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<IssueUpdateResponse>>>(){});
    }

    @Override
    public LigaApiResponse<SuccessResponse> update(IssueUpdateRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.patchJsonBody(this.endpointUrlPrefix  + PREFIX + "/update", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<IssueResponse> get(IdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/get", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IssueResponse.class);
    }

    @Override
    public LigaApiResponse<IssueResponse> getByIssueNumber(IssueNumberRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/get-by-issue-number", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IssueResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> remove(IdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.deleteJsonBody(this.endpointUrlPrefix  + PREFIX + "/remove", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<List<IssueRemoveWithReasonResponse>> batchRemove(IssueBatchRemoveRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.deleteJsonBody(this.endpointUrlPrefix  + PREFIX + "/batch-remove", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<IssueRemoveWithReasonResponse>>>(){});
    }

    @Override
    public LigaApiResponse<PageDataList<IssueSampleResponse>> page(IssueSelectRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/page", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<PageDataList<IssueSampleResponse>>>(){});
    }

    @Override
    public LigaApiResponse<List<FilterConditionFieldResponse>> filterConditionField(ProjectIdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/filter-condition-field", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<FilterConditionFieldResponse>>>(){});
    }

    @Override
    public LigaApiResponse<List<OptionFieldFilterResponse>> selectOptions(FilterSelectOptionsRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/select-options", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<OptionFieldFilterResponse>>>(){});
    }

    @Override
    public LigaApiResponse<List<IssueRelationshipResponse>> relationshipList(IdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.get(this.endpointUrlPrefix  + PREFIX + "/relationship-list", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<IssueRelationshipResponse>>>(){});
    }

    @Override
    public LigaApiResponse<SuccessResponse> addRelationship(IssueRelationshipRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/add-relationship", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> removeRelationship(IssueRelationshipRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/remove-relationship", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<IssueBatchAddResponse> batchAddSubTask(IssueSubTaskBatchAddRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/batch-add-subtask", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IssueBatchAddResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> removeSubTask(IssueSubTaskRemoveRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.deleteJsonBody(this.endpointUrlPrefix  + PREFIX + "/remove-subtask", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> updateSubTask(IssueUpdateRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.patchJsonBody(this.endpointUrlPrefix  + PREFIX + "/update-subtask", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<List<IssueSubTaskResponse>> listSubTask(IdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/list-subtask", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<IssueSubTaskResponse>>>(){});
    }

    @Override
    public LigaApiResponse<SuccessResponse> updateSubTaskStatus(UpdateSubtaskStatusRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.patchJsonBody(this.endpointUrlPrefix  + PREFIX + "/update-subtask-status", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<List<IssueSubTaskFieldResponse>> listSubTaskField(IssueTypeRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/list-subtask-field", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<IssueSubTaskFieldResponse>>>(){});
    }

    @Override
    public LigaApiResponse<SuccessResponse> labourRecordAdd(IssueLabourRecordAddRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/labour-record/add", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> labourRecordUpdate(IssueLabourRecordRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.patchJsonBody(this.endpointUrlPrefix  + PREFIX + "/labour-record/update", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> labourRecordDelete(IdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.deleteJsonBody(this.endpointUrlPrefix  + PREFIX + "/labour-record/delete", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<PageDataList<IssueLabourRecordDetailResponse>> labourRecordPage(IssueLabourListSelectionRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/labour-record/page", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<PageDataList<IssueLabourRecordDetailResponse>>>(){});
    }

    @Override
    public LigaApiResponse<TrashFilterResponse> trashSelectOptions(TokenRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/trash-select-options", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, TrashFilterResponse.class);
    }

    @Override
    public LigaApiResponse<PageDataList<IssueTrashResponse>> trashPage(IssueTrashRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/trash/page", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<PageDataList<IssueTrashResponse>>>(){});
    }

    @Override
    public LigaApiResponse<SuccessResponse> restoreIssue(IdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/trash/restore", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<PageDataList<IssueFinishedResponse>> pageFinished(IssueFinishedRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/page-finished", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<PageDataList<IssueFinishedResponse>>>(){});
    }
}
