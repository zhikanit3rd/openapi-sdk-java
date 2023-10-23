package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.TokenRequest;
import com.liga.api.method.request.comment.CommentAddRequest;
import com.liga.api.method.request.comment.CommentSelectRequest;
import com.liga.api.method.request.comment.CommentUpdateRequest;
import com.liga.api.method.request.comment.StickerUpdateRequest;
import com.liga.api.method.response.IdResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CommentMethodsClientImplTest  extends AbstractLigaWithToken {

    @Test
    void add() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.comment().add(
                CommentAddRequest.builder()
                        .token(token)
                        .content("openAPI新增评论")
                        .commentModule("issue")
                        .linkId(209475346L)
                        .build()
        ));
    }

    @Test
    void update() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.comment().add(
                CommentAddRequest.builder()
                        .token(token)
                        .content("openAPI新增评论")
                        .commentModule("issue")
                        .linkId(209475346L)
                        .build()
        );
        assertLigaApiResponseSuccess(liga.comment().update(CommentUpdateRequest.builder()
                        .token(token)
                        .commentId(idResponseLigaApiResponse.getData().getId())
                        .content("openAPI更新评论")
                .build()));
    }

    @Test
    void remove() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.comment().add(
                CommentAddRequest.builder()
                        .token(token)
                        .content("openAPI新增评论")
                        .commentModule("issue")
                        .linkId(209475346L)
                        .build()
        );
        assertLigaApiResponseSuccess(liga.comment().remove(IdRequest.builder().token(token).id(idResponseLigaApiResponse.getData().getId()).build()));
    }

    @Test
    void page() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.comment().page(CommentSelectRequest.builder()
                        .commentModule("issue")
                        .token(token)
                        .linkId(209475346L)
                .build()));
    }

    @Test
    void updateStickerStatus() throws LigaApiException, IOException {
        LigaApiResponse<IdResponse> idResponseLigaApiResponse =  liga.comment().add(
                CommentAddRequest.builder()
                        .token(token)
                        .content("openAPI新增评论")
                        .commentModule("issue")
                        .linkId(209475346L)
                        .build()
        );
        assertLigaApiResponseSuccess(liga.comment().updateStickerStatus(StickerUpdateRequest.builder()
                        .token(token)
                        .stickerCode("liga-OK")
                        .linkEntity("comment")
                        .linkId(idResponseLigaApiResponse.getData().getId())
                        .linkModule("issue")
                        .issueId(209475346L)
                        .deleteFlag((byte) 0)
                .build()));
    }

    @Test
    void listSticker() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.comment().listSticker(TokenRequest.builder().token(token).build()));
    }
}