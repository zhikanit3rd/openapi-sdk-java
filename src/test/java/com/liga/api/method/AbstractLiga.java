package com.liga.api.method;

import com.liga.api.Liga;
import com.liga.api.LigaConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

/**
 * @author: Ferry
 * @create: 2023/10/19
 * @description:
 **/
public abstract  class AbstractLiga {
    protected static Liga liga;

    @BeforeAll
    static void setUp() {
        LigaConfig ligaConfig = new LigaConfig();
        ligaConfig.setMethodsEndpointUrlPrefix("https://pre.leiga.net/openapi/api/");
        ligaConfig.setLibraryMaintainerMode(true);
        ligaConfig.setPrettyResponseLoggingEnabled(true);
        liga = Liga.getInstance(ligaConfig);
    }

    public static void assertLigaApiResponseSuccess(LigaApiResponse<?> response){
        Assertions.assertEquals(response.getCode(), "0");
    }
}
