package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.field.IssueFieldEnum;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.TokenRequest;
import com.liga.api.method.request.issue.IssueAddRequest;
import com.liga.api.method.request.version.PageAssociateRequest;
import com.liga.api.method.request.version.ReleaseAddRequest;
import com.liga.api.method.request.version.ReleaseAssociateRequest;
import com.liga.api.method.request.version.ReleaseStatusUpdateRequest;
import com.liga.api.method.request.version.ReleaseUpdateRequest;
import com.liga.api.method.response.IdResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

class VersionMethodsClientImplTest  extends AbstractLigaWithToken {

    @Test
    void versionStatusList() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.version().versionStatusList(TokenRequest.builder().token(token).build()));
    }

    @Test
    void optionalOwnerList() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.version().optionalOwnerList(TokenRequest.builder().token(token).build()));
    }

    @Test
    void allVersion() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.version().allVersion(TokenRequest.builder().token(token).build()));
    }

    @Test
    void add() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                        .description("openAPI添加的版本号")
                        .name("新版本" + new Date().getTime())
                        .token(token)
                        .ownerId(188687189L)
                .build());

        assertLigaApiResponseSuccess(idResponseLigaApiResponse);
    }

    @Test
    void update() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                .description("openAPI添加的版本号")
                .name("新版本" + new Date().getTime())
                .token(token)
                .ownerId(188687189L)
                .build());

        assertLigaApiResponseSuccess(liga.version().update(ReleaseUpdateRequest.builder()
                        .id(idResponseLigaApiResponse.getData().getId())
                        .token(token)
                        .description("openAPI更新的版本号")
                        .ownerId(188687189L)
                        .name("更新新版本" + new Date().getTime())
                        .planDate(new Date(new Date().getTime() + 1000000))
                        .startDate(new Date())
                .build()));
    }

    @Test
    void remove() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                .description("openAPI添加的版本号")
                .name("新版本" + new Date().getTime())
                .token(token)
                .ownerId(188687189L)
                .build());

        assertLigaApiResponseSuccess(
                liga.version().remove(IdRequest.builder().token(token).id(idResponseLigaApiResponse.getData().getId()).build())
        );
    }

    @Test
    void release() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                .description("openAPI添加的版本号")
                .name("新版本" + new Date().getTime())
                .token(token)
                .ownerId(188687189L)
                .build());
        assertLigaApiResponseSuccess(liga.version().release(
                ReleaseStatusUpdateRequest.builder().token(token).id(idResponseLigaApiResponse.getData().getId()).releasedDate(new Date()).build()));
    }

    @Test
    void unrelease() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                .description("openAPI添加的版本号")
                .name("新版本" + new Date().getTime())
                .token(token)
                .ownerId(188687189L)
                .build());
        liga.version().release(
                ReleaseStatusUpdateRequest.builder().token(token).id(idResponseLigaApiResponse.getData().getId()).releasedDate(new Date()).build());

        assertLigaApiResponseSuccess(liga.version().unrelease(
                IdRequest.builder().token(token).id(idResponseLigaApiResponse.getData().getId()).build()));

    }

    @Test
    void archive() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                .description("openAPI添加的版本号")
                .name("新版本" + new Date().getTime())
                .token(token)
                .ownerId(188687189L)
                .build());

        assertLigaApiResponseSuccess(liga.version().archive(IdRequest.builder().token(token).id(idResponseLigaApiResponse.getData().getId()).build()));
    }

    @Test
    void unarchive() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                .description("openAPI添加的版本号")
                .name("新版本" + new Date().getTime())
                .token(token)
                .ownerId(188687189L)
                .build());

        liga.version().archive(IdRequest.builder().token(token).id(idResponseLigaApiResponse.getData().getId()).build());
        assertLigaApiResponseSuccess(liga.version().unarchive(IdRequest.builder().token(token).id(idResponseLigaApiResponse.getData().getId()).build()));
    }

    @Test
    void detail() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                .description("openAPI添加的版本号")
                .name("新版本" + new Date().getTime())
                .token(token)
                .ownerId(188687189L)
                .build());

        assertLigaApiResponseSuccess(liga.version().detail(IdRequest.builder().token(token).id(idResponseLigaApiResponse.getData().getId()).build()));
    }

    @Test
    void associateIssues() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        LigaApiResponse<IdResponse> issue = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(209965468L)
                .issueTypeId(209965665L)
                .data(issue1)
                .build());

        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                .description("openAPI添加的版本号")
                .name("新版本" + new Date().getTime())
                .token(token)
                .ownerId(188687189L)
                .build());

        assertLigaApiResponseSuccess(liga.version().associateIssues(ReleaseAssociateRequest.builder()
                        .token(token)
                        .issueId(issue.getData().getId())
                        .releaseId(idResponseLigaApiResponse.getData().getId())
                .build()));
    }

    @Test
    void disassociateIssues() throws LigaApiException, IOException {

        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        LigaApiResponse<IdResponse> issue = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(209965468L)
                .issueTypeId(209965665L)
                .data(issue1)
                .build());

        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                .description("openAPI添加的版本号")
                .name("新版本" + new Date().getTime())
                .token(token)
                .ownerId(188687189L)
                .build());

        assertLigaApiResponseSuccess(liga.version().associateIssues(ReleaseAssociateRequest.builder()
                .token(token)
                .issueId(issue.getData().getId())
                .releaseId(idResponseLigaApiResponse.getData().getId())
                .build()));

        assertLigaApiResponseSuccess(liga.version().disassociateIssues(ReleaseAssociateRequest.builder()
                .token(token)
                .issueId(issue.getData().getId())
                .releaseId(idResponseLigaApiResponse.getData().getId())
                .build()));
    }

    @Test
    void pageAssociate() throws LigaApiException, IOException {
        Map<String, Object> issue1 = new HashMap<>(10);
        issue1.put(IssueFieldEnum.SUMMARY.code, "标题1");
        issue1.put(IssueFieldEnum.STATUS.code, 209965544L);
        LigaApiResponse<IdResponse> issue = liga.issue().add(IssueAddRequest.builder()
                .token(token)
                .projectId(209965468L)
                .issueTypeId(209965665L)
                .data(issue1)
                .build());

        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.version().add(ReleaseAddRequest.builder()
                .description("openAPI添加的版本号")
                .name("新版本" + new Date().getTime())
                .token(token)
                .ownerId(188687189L)
                .build());

        assertLigaApiResponseSuccess(liga.version().associateIssues(ReleaseAssociateRequest.builder()
                .token(token)
                .issueId(issue.getData().getId())
                .releaseId(idResponseLigaApiResponse.getData().getId())
                .build()));

        assertLigaApiResponseSuccess(liga.version().pageAssociate(PageAssociateRequest.builder()
                        .token(token)
                        .releaseId(idResponseLigaApiResponse.getData().getId())

                .build()));
    }
}