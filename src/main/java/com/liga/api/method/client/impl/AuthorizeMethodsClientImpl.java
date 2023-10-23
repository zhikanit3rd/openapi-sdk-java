package com.liga.api.method.client.impl;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.authorize.RefreshTokenRequest;
import com.liga.api.method.response.authorize.RefreshTokenResponse;
import com.liga.api.method.client.AuthorizeMethodsClient;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.request.authorize.AccessTokenRequest;
import com.liga.api.method.response.authorize.AccessTokenResponse;
import com.liga.api.util.http.LigaHttpClient;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
public class AuthorizeMethodsClientImpl implements AuthorizeMethodsClient {

    @Setter
    @Getter
    private String endpointUrlPrefix;
    private final LigaHttpClient ligaHttpClient;

    public AuthorizeMethodsClientImpl(LigaHttpClient ligaHttpClient) {
        this.ligaHttpClient = ligaHttpClient;
    }

    public AuthorizeMethodsClientImpl(String endpointUrlPrefix, LigaHttpClient ligaHttpClient) {
        this.endpointUrlPrefix = endpointUrlPrefix;
        this.ligaHttpClient = ligaHttpClient;
    }

    @Override
    public LigaApiResponse<AccessTokenResponse> accessToken(AccessTokenRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix + PREFIX + "/access-token", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, AccessTokenResponse.class);
    }

    @Override
    public LigaApiResponse<AccessTokenResponse> accessPermanentToken(AccessTokenRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/access-permanent-token", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, AccessTokenResponse.class);
    }

    @Override
    public LigaApiResponse<RefreshTokenResponse> refreshToken(RefreshTokenRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/refresh-token", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, RefreshTokenResponse.class);
    }
}
