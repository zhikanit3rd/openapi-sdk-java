package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.field.ProjectFieldEnum;
import com.liga.api.method.request.TokenRequest;
import com.liga.api.method.request.project.ProjectAddRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.project.ProjectKeyRequest;
import com.liga.api.method.request.project.ProjectUpdateRequest;
import com.liga.api.method.request.project.ProjectUserRoleSetRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ProjectMethodsClientImplTest extends AbstractLigaWithToken {

    @Test
    void projectTemplate() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.project().projectTemplate(TokenRequest.builder().token(token).build()));
    }

    @Test
    void list() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.project().list(TokenRequest.builder().token(token).build()));
    }

    @Test
    void projectOverviewScheme() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.project().projectOverviewScheme(ProjectIdRequest.builder().token(token).projectId(209965468L).build()));
    }

    @Test
    void add() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.project().add(ProjectAddRequest.builder()
                        .token(token)
                        .leaderId(12574031L)
                        .templateCode("SCRUM")
                        .projectName("openAPI创建的项目")
                        .description("随便输入点描述")
                .build()));
    }

    @Test
    void update() throws LigaApiException, IOException {
        Map<String, Object> dataMap = new HashMap<>(1);
        dataMap.put(ProjectFieldEnum.PNAME.code, "OpenAPI创建的项目修改了" + Calendar.getInstance().getTime().getTime());
        assertLigaApiResponseSuccess(
                liga.project().update(ProjectUpdateRequest.builder()
                                .token(token)
                                .id(209965468L)
                                .data(dataMap)
                        .build())
        );
    }

    @Test
    void getByProjectKey() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.project().getByProjectKey(ProjectKeyRequest.builder().token(token).projectKey("OPENA").build()));
    }

    @Test
    void get() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.project().get(ProjectIdRequest.builder().token(token).projectId(209965468L).build()));
    }

    @Test
    void roleChange() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.project().roleChange(
                ProjectUserRoleSetRequest.builder().projectId(209965468L).token(token)
                .roleIdList(Collections.singleton(12574038L)).userId(188687189L).build()));
    }

    @Test
    void roleType() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.project().roleType(TokenRequest.builder().token(token).build()));
    }
}