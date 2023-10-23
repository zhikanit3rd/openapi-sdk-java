package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLiga;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.authorize.AccessTokenRequest;
import com.liga.api.method.request.authorize.RefreshTokenRequest;
import com.liga.api.method.response.authorize.AccessTokenResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class AuthorizeMethodsClientImplTest extends AbstractLiga {

    AccessTokenRequest accessTokenRequest = AccessTokenRequest.builder()
            .clientId("nqAZH7lVyppa")
            .secretKey("de2aad5c361f4308832d390afa2cc5d5")
            .build();

    @Test
    void accessToken() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.authorize().accessToken(accessTokenRequest));
    }

    @Test
    void accessPermanentToken() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.authorize().accessPermanentToken(accessTokenRequest));
    }

    @Test
    void refreshToken() throws LigaApiException, IOException {
        LigaApiResponse<AccessTokenResponse> ligaApiResponse = liga.authorize().accessToken(accessTokenRequest);
        assertLigaApiResponseSuccess(ligaApiResponse);
        assertLigaApiResponseSuccess(
            liga.authorize().refreshToken(RefreshTokenRequest.builder()
                    .clientId(accessTokenRequest.getClientId())
                    .secretKey(accessTokenRequest.getSecretKey())
                    .refreshToken(ligaApiResponse.getData().getAccessToken()).build()
            )
        );
    }
}