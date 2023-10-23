package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.sprint.SprintAddRequest;
import com.liga.api.method.request.sprint.SprintIdRequest;
import com.liga.api.method.request.sprint.SprintUpdateRequest;
import com.liga.api.method.response.sprint.SprintResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

class SprintMethodsClientImplTest extends AbstractLigaWithToken {

    @Test
    void add() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.sprint().add(SprintAddRequest.builder()
                        .token(token)
                        .name("Sprint 1" + new Date().getTime())
                        .projectId(167019207L)
                .build()));
    }

    @Test
    void update() throws LigaApiException, IOException {
        LigaApiResponse<SprintResponse> sprintResponseLigaApiResponse = liga.sprint().add(SprintAddRequest.builder()
                .token(token)
                .name("Sprint 1" + new Date().getTime())
                .projectId(167019207L)
                .build());
        assertLigaApiResponseSuccess(liga.sprint().update(SprintUpdateRequest.builder()
                .token(token)
                .name("Sprint 2" + new Date().getTime())
                .id(sprintResponseLigaApiResponse.getData().getId())
                .build()));
    }

    @Test
    void remove() throws LigaApiException, IOException {
        LigaApiResponse<SprintResponse> sprintResponseLigaApiResponse = liga.sprint().add(SprintAddRequest.builder()
                .token(token)
                .name("Sprint 1" + new Date().getTime())
                .projectId(167019207L)
                .build());
        assertLigaApiResponseSuccess(liga.sprint().remove(SprintIdRequest.builder().token(token)
                .sprintId(sprintResponseLigaApiResponse.getData().getId()).build()));
    }

    @Test
    void get() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.sprint().get(IdRequest.builder().token(token).id(190198649L).build()));
    }

    @Test
    void listWithCount() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.sprint().listWithCount(ProjectIdRequest.builder().token(token).projectId(167019207L).build()));
    }
}