package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.field.IssueFieldEnum;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.epic.EpicAddRequest;
import com.liga.api.method.request.epic.EpicFieldRequest;
import com.liga.api.method.request.epic.EpicFilterRequest;
import com.liga.api.method.request.epic.EpicIssueFilterRequest;
import com.liga.api.method.request.epic.EpicRelationIssueRequest;
import com.liga.api.method.request.epic.EpicUpdateRequest;
import com.liga.api.method.request.issue.IssueAddRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.response.IdResponse;
import com.liga.api.method.response.epic.EpicResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class EpicMethodsClientImplTest  extends AbstractLigaWithToken {

    @Test
    void filterOptions() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.epic().filterOptions(ProjectIdRequest.builder()
                        .projectId(167019207L)
                .token(token).build()));
    }

    @Test
    void page() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.epic().page(EpicFilterRequest.builder().token(token).projectId(167019207L).build()));
        assertLigaApiResponseSuccess(liga.epic().page(EpicFilterRequest.builder().token(token).keyword("sdf").projectId(167019207L).build()));
    }

    @Test
    void pageIssue() throws LigaApiException, IOException {
        EpicResponse  response = liga.epic().page(EpicFilterRequest.builder().token(token).keyword("sdf").projectId(167019207L).build()).getData().getList().get(0);
        assertLigaApiResponseSuccess(liga.epic().pageIssue(EpicIssueFilterRequest.builder()
                .id(response.getId())
                .projectId(167019207L)
                .token(token)
                .build()));
    }

    @Test
    void epicFields() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.epic().epicFields(ProjectIdRequest.builder().token(token).projectId(167019207L).build()));
    }

    @Test
    void epicFieldInfo() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.epic().epicFieldInfo(EpicFieldRequest.builder().fieldCode("summary").token(token).projectId(167019207L).build()));
    }

    @Test
    void add() throws LigaApiException, IOException {
        Map<String, Object> epic = new HashMap<>(10);
        epic.put(IssueFieldEnum.SUMMARY.code, "标题1" + new Date().getTime());
        assertLigaApiResponseSuccess(liga.epic().add(EpicAddRequest.builder()
                        .token(token)
                        .projectId(167019207L)
                        .data(epic)
                .build()));
    }

    @Test
    void update() throws LigaApiException, IOException {
        Map<String, Object> epic = new HashMap<>(10);
        epic.put(IssueFieldEnum.SUMMARY.code, "标题1" + new Date().getTime());
        LigaApiResponse<IdResponse> idResponseLigaApiResponse = liga.epic().add(EpicAddRequest.builder()
                .token(token)
                .projectId(167019207L)
                .data(epic)
                .build());

        Map<String, Object> updateEpic = new HashMap<>(10);
        updateEpic.put(IssueFieldEnum.SUMMARY.code, "更新标题1" + new Date().getTime());
        assertLigaApiResponseSuccess(liga.epic().update(EpicUpdateRequest.builder()
                        .token(token)
                        .id(idResponseLigaApiResponse.getData().getId())
                        .data(updateEpic)
                .build()));
    }

    @Test
    void remove() throws LigaApiException, IOException {
        Map<String, Object> epic = new HashMap<>(10);
        epic.put(IssueFieldEnum.SUMMARY.code, "标题1" + new Date().getTime());
        LigaApiResponse<IdResponse> idResponseLigaApiResponse = liga.epic().add(EpicAddRequest.builder()
                .token(token)
                .projectId(167019207L)
                .data(epic)
                .build());

        assertLigaApiResponseSuccess(liga.epic().remove(IdRequest.builder().token(token).id(idResponseLigaApiResponse.getData().getId()).build()));
    }

    @Test
    void detail() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.epic().detail(IdRequest.builder().token(token).id(190416421L).build()));
    }

    @Test
    void relationIssue() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        LigaApiResponse<IdResponse> idResponseLigaApiResponse = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(209965468L)
                .issueTypeId(209965665L)
                .data(issue1)
                .build());
        assertLigaApiResponseSuccess(liga.epic().relationIssue(EpicRelationIssueRequest.builder()
                .token(token).epicId(190416421L)
                .issueIds(Collections.singletonList(idResponseLigaApiResponse.getData().getId()))
                .build()));
    }
}