package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.field.IssueFieldEnum;
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
import com.liga.api.method.response.issue.IssueBatchAddResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class IssueMethodsClientImplTest extends AbstractLigaWithToken {

    private static final Long projectId = 209965468L;
    private static final Long issueTypeId = 209965665L;

    @Test
    void typeList() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().typeList(ProjectIdRequest.builder().token(token).projectId(projectId).build()));
    }

    @Test
    void issueScheme() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().issueScheme(IssueTypeRequest.builder().token(token).projectId(projectId).issueTypeId(issueTypeId).build()));
    }

    @Test
    void issueFields() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().issueFields(IssueTypeRequest.builder().token(token).projectId(projectId).issueTypeId(issueTypeId).build()));
    }

    @Test
    void issueFieldInfo() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().issueFieldInfo(IssueFieldRequest.builder().token(token).issueTypeId(issueTypeId).fieldCode("status").projectId(projectId).build()));
    }

    @Test
    void batchAdd() throws LigaApiException, IOException {

        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        assertLigaApiResponseSuccess(liga.issue().batchAdd(IssueBatchAddRequest.builder()
                        .token(token)
                        .projectId(projectId)
                        .issueTypeId(issueTypeId)
                        .datas(Collections.singletonList(issue1))
                .build()));
    }

    @Test
    void add() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        assertLigaApiResponseSuccess(liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()));

    }

    @Test
    void batchUpdate() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();
        Map<String, Object> updateIssue = new HashMap<>(10);
        updateIssue.put(IssueFieldEnum.SUMMARY.code, "标题2");
        assertLigaApiResponseSuccess(liga.issue().batchUpdate(IssueBatchUpdateRequest.builder()
                        .issueIds(Collections.singletonList(idResponse.getId()))
                        .issueTypeId(issueTypeId)
                        .projectId(projectId)
                .token(token)
                .data(updateIssue)
                .build()));
    }

    @Test
    void update() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        Map<String, Object> updateIssue = new HashMap<>(10);
        updateIssue.put(IssueFieldEnum.SUMMARY.code, "标题2");
        assertLigaApiResponseSuccess(liga.issue().update(IssueUpdateRequest.builder()
                        .id(idResponse.getId())
                        .token(token)
                        .data(updateIssue)
                .build()));
    }

    @Test
    void get() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().get(IdRequest.builder().token(token).id(210783460L).build()));
    }

    @Test
    void getByIssueNumber() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().getByIssueNumber(IssueNumberRequest.builder().token(token).issueNumber("OPENA-31").build()));
    }

    @Test
    void remove() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        assertLigaApiResponseSuccess(liga.issue().remove(IdRequest.builder().token(token).id(idResponse.getId()).build()));
    }

    @Test
    void batchRemove() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        assertLigaApiResponseSuccess(liga.issue().batchRemove(IssueBatchRemoveRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueIds(Collections.singletonList(idResponse.getId())).build()));
    }

    @Test
    void page() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().page(IssueSelectRequest.builder().token(token).projectId(projectId).build()));
    }

    @Test
    void filterConditionField() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().filterConditionField(ProjectIdRequest.builder().token(token).projectId(projectId).build()));
    }

    @Test
    void selectOptions() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().selectOptions(
                FilterSelectOptionsRequest.builder().token(token).projectId(projectId).customFiledIds(Collections.singletonList(12574097L)).build()));
    }

    @Test
    void relationshipList() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        Map<String, Object> issue2 = new HashMap<>(10);
        issue2.put(IssueFieldEnum.SUMMARY.code, "关联标题2");
        issue2.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse2 = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue2)
                .build()).getData();

        assertLigaApiResponseSuccess(liga.issue().addRelationship(IssueRelationshipRequest.builder()
                .token(token)
                .issueId(idResponse.getId())
                .linkedIssueId(idResponse2.getId())
                .type("RELATES_TO")
                .build()));
        assertLigaApiResponseSuccess(liga.issue().relationshipList(IdRequest.builder().token(token).id(idResponse.getId()).build()));
        assertLigaApiResponseSuccess(liga.issue().relationshipList(IdRequest.builder().token(token).id(idResponse2.getId()).build()));
    }

    @Test
    void addRelationship() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        Map<String, Object> issue2 = new HashMap<>(10);
        issue2.put(IssueFieldEnum.SUMMARY.code, "关联标题2");
        issue2.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse2 = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue2)
                .build()).getData();

        assertLigaApiResponseSuccess(liga.issue().addRelationship(IssueRelationshipRequest.builder()
                .token(token)
                        .issueId(idResponse.getId())
                        .linkedIssueId(idResponse2.getId())
                        .type("RELATES_TO")
                .build()));
    }

    @Test
    void removeRelationship() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        Map<String, Object> issue2 = new HashMap<>(10);
        issue2.put(IssueFieldEnum.SUMMARY.code, "关联标题2");
        issue2.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse2 = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue2)
                .build()).getData();

        assertLigaApiResponseSuccess(liga.issue().addRelationship(IssueRelationshipRequest.builder()
                .token(token)
                .issueId(idResponse.getId())
                .linkedIssueId(idResponse2.getId())
                .type("RELATES_TO")
                .build()));

        assertLigaApiResponseSuccess(liga.issue().removeRelationship(IssueRelationshipRequest.builder()
                .token(token)
                .issueId(idResponse.getId())
                .linkedIssueId(idResponse2.getId())
                .type("RELATES_TO")
                .build()));
    }

    @Test
    void batchAddSubTask() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        Map<String, Object> subIssue2 = new HashMap<>(10);
        subIssue2.put(IssueFieldEnum.SUMMARY.code, "子任务标题1");
        assertLigaApiResponseSuccess(liga.issue().batchAddSubTask(IssueSubTaskBatchAddRequest.builder()
                        .token(token)
                        .issueId(idResponse.getId())
                        .datas(Collections.singletonList(subIssue2))
                .build()));
    }

    @Test
    void removeSubTask() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        Map<String, Object> subIssue2 = new HashMap<>(10);
        subIssue2.put(IssueFieldEnum.SUMMARY.code, "子任务标题1");
        LigaApiResponse<IssueBatchAddResponse> issueBatchAddResponseLigaApiResponse =  liga.issue().batchAddSubTask(IssueSubTaskBatchAddRequest.builder()
                .token(token)
                .issueId(idResponse.getId())
                .datas(Collections.singletonList(subIssue2))
                .build());

        assertLigaApiResponseSuccess(liga.issue().removeSubTask(IssueSubTaskRemoveRequest.builder()
                        .token(token)
                        .issueId(idResponse.getId())
                        .subTaskId(issueBatchAddResponseLigaApiResponse.getData().getIssueAddVOList().get(0).getId())
                .build()));
    }

    @Test
    void updateSubTask() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        Map<String, Object> subIssue2 = new HashMap<>(10);
        subIssue2.put(IssueFieldEnum.SUMMARY.code, "子任务标题1");
        LigaApiResponse<IssueBatchAddResponse> issueBatchAddResponseLigaApiResponse =  liga.issue().batchAddSubTask(IssueSubTaskBatchAddRequest.builder()
                .token(token)
                .issueId(idResponse.getId())
                .datas(Collections.singletonList(subIssue2))
                .build());

        Map<String, Object> subIssue3 = new HashMap<>(10);
        subIssue3.put(IssueFieldEnum.SUMMARY.code, "更新子任务标题1");
        assertLigaApiResponseSuccess(liga.issue().updateSubTask(IssueUpdateRequest.builder()
                        .token(token)
                        .id(issueBatchAddResponseLigaApiResponse.getData().getIssueAddVOList().get(0).getId())
                        .data(subIssue3)
                .build()));
    }

    @Test
    void listSubTask() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        Map<String, Object> subIssue2 = new HashMap<>(10);
        subIssue2.put(IssueFieldEnum.SUMMARY.code, "子任务标题1");
        LigaApiResponse<IssueBatchAddResponse> issueBatchAddResponseLigaApiResponse =  liga.issue().batchAddSubTask(IssueSubTaskBatchAddRequest.builder()
                .token(token)
                .issueId(idResponse.getId())
                .datas(Collections.singletonList(subIssue2))
                .build());

        assertLigaApiResponseSuccess(liga.issue().listSubTask(IdRequest.builder()
                .token(token)
                .id(idResponse.getId())
                .build()));
    }

    @Test
    void updateSubTaskStatus() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();

        Map<String, Object> subIssue2 = new HashMap<>(10);
        subIssue2.put(IssueFieldEnum.SUMMARY.code, "子任务标题1");
        LigaApiResponse<IssueBatchAddResponse> issueBatchAddResponseLigaApiResponse =  liga.issue().batchAddSubTask(IssueSubTaskBatchAddRequest.builder()
                .token(token)
                .issueId(idResponse.getId())
                .datas(Collections.singletonList(subIssue2))
                .build());

        liga.issue().updateSubTaskStatus(UpdateSubtaskStatusRequest.builder()
                        .id(issueBatchAddResponseLigaApiResponse.getData().getIssueAddVOList().get(0).getId())
                        .done(Boolean.TRUE)
                        .projectId(projectId)
                        .token(token)
                .build());
    }

    @Test
    void listSubTaskField() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().listSubTaskField(IssueTypeRequest.builder()
                        .token(token)
                        .projectId(projectId)
                        .issueTypeId(issueTypeId)
                .build()));
    }

    @Test
    void labourRecordAdd() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        IdResponse idResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(projectId)
                .issueTypeId(issueTypeId)
                .data(issue1)
                .build()).getData();
        assertLigaApiResponseSuccess(liga.issue().labourRecordAdd(IssueLabourRecordAddRequest.builder()
                        .issueId(idResponse.getId())
                        .token(token)
                        .labour(new BigDecimal("1"))
                        .recordTime(new Date())
                        .remarks("工时上报")
                .build()));
    }

    @Test
    void labourRecordUpdate() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().labourRecordUpdate(IssueLabourRecordRequest.builder()
                        .token(token)
                        .id(210784702L)
                        .labour(new BigDecimal("2"))
                        .recordTime(new Date())
                        .remarks("工时上报修改")
                .build()));
    }

    @Test
    void labourRecordDelete() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().labourRecordDelete(IdRequest.builder()
                .token(token)
                .id(210784647L)
                .build()));
    }

    @Test
    void labourRecordPage() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().labourRecordPage(IssueLabourListSelectionRequest.builder().token(token).projectId(projectId).build()));


    }

    @Test
    void trashSelectOptions() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().trashSelectOptions(TokenRequest.builder().token(token).build()));
    }

    @Test
    void trashPage() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().trashPage(IssueTrashRequest.builder()
                .token(token)
                .build()));
    }

    @Test
    void restoreIssue() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().restoreIssue(IdRequest.builder()
                .token(token)
                .id(209965544L)
                .build()));
    }

    @Test
    void pageFinished() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.issue().pageFinished(IssueFinishedRequest.builder()
                        .token(token)
                        .after(new Date())

                .build()));
    }
}