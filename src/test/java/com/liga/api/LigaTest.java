package com.liga.api;

import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.authorize.AccessTokenRequest;
import com.liga.api.method.response.authorize.AccessTokenResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class LigaTest {

    private static Liga ligaUnderTest;

    @BeforeAll
    static void setUp() {
        LigaConfig ligaConfig = new LigaConfig();
        ligaConfig.setMethodsEndpointUrlPrefix("https://pre.leiga.net/openapi/api/");
        ligaConfig.setLibraryMaintainerMode(true);
        ligaConfig.setPrettyResponseLoggingEnabled(true);
        ligaUnderTest = Liga.getInstance(ligaConfig);
    }

    @Test
    void testGetInstance1() throws LigaApiException, IOException {
        LigaApiResponse<AccessTokenResponse> ligaTextApiResponse = ligaUnderTest.authorize().accessToken(AccessTokenRequest.builder()
                        .clientId("nqAZH7lVyppa")
                        .secretKey("de2aad5c361f4308832d390afa2cc5d5")
                .build());

        System.out.println(ligaTextApiResponse.getData().getAccessToken());
    }
}
