package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.request.org.AllMemberListRequest;
import com.liga.api.method.request.org.UserIdRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrgMethodsClientImplTest extends AbstractLigaWithToken {

    @Test
    void allMemberList() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(
                liga.org().allMemberList(AllMemberListRequest.builder()
                                .token(token)
                        .build())
        );

        assertLigaApiResponseSuccess(
                liga.org().allMemberList(AllMemberListRequest.builder()
                        .token(token)
                                .key("zhaohui")
                        .build())
        );
    }

    @Test
    void enableOrgUser() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(
                liga.org().enableOrgUser(UserIdRequest.builder().userId(188687189L).token(token).build())
        );
    }

    @Test
    void disableOrgUser() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.org().disableOrgUser(UserIdRequest.builder().userId(188687189L).token(token).build()));
    }

    @Test
    void removeOrgUser() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.org().removeOrgUser(UserIdRequest.builder().userId(188687189L).token(token).build()));
    }
}