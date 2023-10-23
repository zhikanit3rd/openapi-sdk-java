package com.liga.api.method.client;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.authorize.RefreshTokenRequest;
import com.liga.api.method.response.authorize.RefreshTokenResponse;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.request.authorize.AccessTokenRequest;
import com.liga.api.method.response.authorize.AccessTokenResponse;

import java.io.IOException;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
public interface AuthorizeMethodsClient {

    String PREFIX = "authorize";

    /**
     * 获取 accessToken
     * @param request
     * @return
     * @throws IOException
     * @throws LigaApiException
     */
    LigaApiResponse<AccessTokenResponse> accessToken(AccessTokenRequest request) throws IOException, LigaApiException;

    /**
     * 获取永久 accessToken
     * @param request
     * @return
     * @throws IOException
     * @throws LigaApiException
     */
    LigaApiResponse<AccessTokenResponse> accessPermanentToken(AccessTokenRequest request) throws IOException, LigaApiException;

    /**
     * 刷新accessToken
     * @param request
     * @return
     * @throws IOException
     * @throws LigaApiException
     */
    LigaApiResponse<RefreshTokenResponse> refreshToken(RefreshTokenRequest request) throws IOException, LigaApiException;
}
