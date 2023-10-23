package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.webhook.WebhookAddRequest;
import com.liga.api.method.request.webhook.WebhookIdRequest;
import com.liga.api.method.request.webhook.WebhookPageQueryRequest;
import com.liga.api.method.request.webhook.WebhookUpdateRequest;
import com.liga.api.method.response.webhook.WebhookInfoResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;

class WebhookMethodsClientImplTest extends AbstractLigaWithToken {

    @Test
    void listTypes() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.webhook().listTypes(ProjectIdRequest.builder().token(token).projectId(167019207L).build()));
    }

    @Test
    void listEvents() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.webhook().listEvents(ProjectIdRequest.builder().token(token).projectId(167019207L).build()));
    }

    @Test
    void add() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.webhook().add(WebhookAddRequest.builder()
                .token(token)
                .projectId(167019207L)
                        .eventIds(Collections.singletonList(1L))
                        .name("openAPI新增webhook" + new Date().getTime())
                        .state("enabled")
                        .type("ligaAI")
                        .url("http://www.baidu.com")
                .build()));
    }

    @Test
    void delete() throws LigaApiException, IOException {
        LigaApiResponse<WebhookInfoResponse> webhookInfoResponseLigaApiResponse = liga.webhook().add(WebhookAddRequest.builder()
                .token(token)
                .projectId(167019207L)
                .eventIds(Collections.singletonList(1L))
                .name("openAPI新增webhook" + new Date().getTime())
                .state("enabled")
                .type("ligaAI")
                .url("http://www.baidu.com")
                .build());

        assertLigaApiResponseSuccess(liga.webhook().delete(WebhookIdRequest.builder().token(token).webhookId(webhookInfoResponseLigaApiResponse.getData().getWebhookId()).build()));
    }

    @Test
    void update() throws LigaApiException, IOException {
        LigaApiResponse<WebhookInfoResponse> webhookInfoResponseLigaApiResponse = liga.webhook().add(WebhookAddRequest.builder()
                .token(token)
                .projectId(167019207L)
                .eventIds(Collections.singletonList(1L))
                .name("openAPI新增webhook" + new Date().getTime())
                .state("enabled")
                .type("ligaAI")
                .url("http://www.baidu.com")
                .build());

        assertLigaApiResponseSuccess(liga.webhook().update(WebhookUpdateRequest.builder()
                        .token(token)
                        .webhookId(webhookInfoResponseLigaApiResponse.getData().getWebhookId())
                        .name("openAPI更新webhook" + new Date().getTime())
                        .state("disabled")
                        .type("ligaAI")
                        .url("http://www.baidu.com")
                .build()));
    }

    @Test
    void get() throws LigaApiException, IOException {

        LigaApiResponse<WebhookInfoResponse> webhookInfoResponseLigaApiResponse = liga.webhook().add(WebhookAddRequest.builder()
                .token(token)
                .projectId(167019207L)
                .eventIds(Collections.singletonList(1L))
                .name("openAPI新增webhook" + new Date().getTime())
                .state("enabled")
                .type("ligaAI")
                .url("http://www.baidu.com")
                .build());

        assertLigaApiResponseSuccess(liga.webhook().delete(WebhookIdRequest.builder().token(token).webhookId(webhookInfoResponseLigaApiResponse.getData().getWebhookId()).build()));
    }

    @Test
    void page() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.webhook().page(WebhookPageQueryRequest.builder().token(token).projectId(167019207L).state("enabled").build()));
    }
}