package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.request.user.ProjectUserListRequest;
import com.liga.api.method.request.user.ProjectUserMembersRequest;
import com.liga.api.method.request.user.ProjectUserPageRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

class UserMethodsClientImplTest extends AbstractLigaWithToken {

    @Test
    void projectUserList() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.user().projectUserList(ProjectUserListRequest.builder()
                        .token(token)
                        .projectId(209965468L)
                .build()));

        assertLigaApiResponseSuccess(liga.user().projectUserList(ProjectUserListRequest.builder()
                .token(token)
                .projectId(167019207L)
                 .keyword("aaa")
                .build()));
    }

    @Test
    void projectUserPage() throws LigaApiException, IOException {

        assertLigaApiResponseSuccess(liga.user().projectUserPage(ProjectUserPageRequest.builder()
                .token(token)
                .projectId(167019207L)
                .pageSize(20)
                .pageNumber(2)
                .build()));
    }

    @Test
    void addMembers() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(
                liga.user().addMembers(ProjectUserMembersRequest.builder()
                                .userIds(Collections.singleton(188687189L))
                                .projectId(167019207L)
                                .token(token)
                        .build())
        );
    }

    @Test
    void removeMembers() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(
                liga.user().removeMembers(ProjectUserMembersRequest.builder()
                        .userIds(Collections.singleton(188687189L))
                        .projectId(167019207L)
                        .token(token)
                        .build())
        );
    }
}