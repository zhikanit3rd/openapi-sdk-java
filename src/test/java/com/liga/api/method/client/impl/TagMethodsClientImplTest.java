package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.tag.TagAddRequest;
import com.liga.api.method.request.tag.TagUpdateRequest;
import com.liga.api.method.response.tag.TagResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

class TagMethodsClientImplTest  extends AbstractLigaWithToken {

    @Test
    void add() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.tag().add(TagAddRequest.builder()
                .token(token)
                        .projectId(167019207L)
                        .tagName("o" + new Date().getTime())
                .build()));
    }

    @Test
    void update() throws LigaApiException, IOException {
        LigaApiResponse<TagResponse>  tagResponseLigaApiResponse = liga.tag().add(TagAddRequest.builder()
                .token(token)
                .projectId(167019207L)
                .tagName("o" + new Date().getTime())
                .build());
        assertLigaApiResponseSuccess(liga.tag().update(TagUpdateRequest.builder()
                .token(token)
                .tagName("o" + new Date().getTime())
                .id(tagResponseLigaApiResponse.getData().getId())
                .build()));
    }

    @Test
    void remove() throws LigaApiException, IOException {
        LigaApiResponse<TagResponse>  tagResponseLigaApiResponse = liga.tag().add(TagAddRequest.builder()
                .token(token)
                .projectId(167019207L)
                .tagName("o" + new Date().getTime())
                .build());
        assertLigaApiResponseSuccess(liga.tag().remove(IdRequest.builder().token(token).id(tagResponseLigaApiResponse.getData().getId()).build()));
    }

    @Test
    void list() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.tag().list(ProjectIdRequest.builder().token(token).projectId(167019207L).build()));
    }
}