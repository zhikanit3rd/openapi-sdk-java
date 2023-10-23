package com.liga.api.method.client.impl;

import com.alibaba.fastjson.TypeReference;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.msg.MsgListRequest;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.response.msg.MsgListResponse;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.client.MsgMethodsClient;
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
public class MsgMethodsClientImpl implements MsgMethodsClient {

    @Setter
    @Getter
    private String endpointUrlPrefix;
    private final LigaHttpClient ligaHttpClient;

    public MsgMethodsClientImpl(LigaHttpClient ligaHttpClient) {
        this.ligaHttpClient = ligaHttpClient;
    }

    public MsgMethodsClientImpl(String endpointUrlPrefix, LigaHttpClient ligaHttpClient) {
        this.endpointUrlPrefix = endpointUrlPrefix;
        this.ligaHttpClient = ligaHttpClient;
    }

    @Override
    public LigaApiResponse<PageDataList<MsgListResponse>> list(MsgListRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/list", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, new TypeReference<LigaApiResponse<PageDataList<MsgListResponse>>>(){});
    }
}
