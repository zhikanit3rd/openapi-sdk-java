package com.liga.api.method;

import com.liga.api.Liga;
import com.liga.api.LigaConfig;
import com.liga.api.method.request.authorize.AccessTokenRequest;
import com.liga.api.method.response.authorize.AccessTokenResponse;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

/**
 * @author: Ferry
 * @create: 2023/10/19
 * @description:
 **/
public abstract  class AbstractLigaWithToken extends AbstractLiga{

    protected static String token;

    @BeforeAll
    static void setUp() {
        LigaConfig ligaConfig = new LigaConfig();
        ligaConfig.setMethodsEndpointUrlPrefix("https://pre.leiga.net/openapi/api/");
        ligaConfig.setLibraryMaintainerMode(false);
        ligaConfig.setPrettyResponseLoggingEnabled(true);
        liga = Liga.getInstance(ligaConfig);

        LigaApiResponse<AccessTokenResponse> ligaTextApiResponse = null;
        try {
            ligaTextApiResponse = liga.authorize().accessToken(AccessTokenRequest.builder()
                    .clientId("nqAZH7lVyppa")
                    .secretKey("de2aad5c361f4308832d390afa2cc5d5")
                    .build());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LigaApiException e) {
            e.printStackTrace();
        }
        token = ligaTextApiResponse.getData().getAccessToken();
    }
}
