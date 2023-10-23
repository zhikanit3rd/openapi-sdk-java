package com.liga.api.method.client.impl;

import com.liga.api.Liga;
import com.liga.api.LigaConfig;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.authorize.AccessTokenRequest;
import com.liga.api.method.request.msg.MsgListRequest;
import com.liga.api.method.response.authorize.AccessTokenResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MsgMethodsClientImplTest {

    @Test
    void list() throws LigaApiException, IOException {

        LigaConfig ligaConfig = new LigaConfig();
        ligaConfig.setMethodsEndpointUrlPrefix("https://pre.leiga.net/openapi/api/");
        ligaConfig.setLibraryMaintainerMode(true);
        ligaConfig.setPrettyResponseLoggingEnabled(true);
        Liga liga = Liga.getInstance(ligaConfig);

        LigaApiResponse<AccessTokenResponse> ligaTextApiResponse = null;
        try {
            ligaTextApiResponse = liga.authorize().accessToken(AccessTokenRequest.builder()
                    .clientId("TKkGXEADyMMJ")
                    .secretKey("50532c37a46e45e8bec2ee43ebcd68e8")
                    .build());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LigaApiException e) {
            e.printStackTrace();
        }
        String token = ligaTextApiResponse.getData().getAccessToken();

        Assertions.assertEquals(liga.msg().list(MsgListRequest.builder().token(token).build()).getCode(), "0");
    }
}