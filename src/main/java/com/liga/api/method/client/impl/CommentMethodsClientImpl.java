package com.liga.api.method.client.impl;

import com.alibaba.fastjson.TypeReference;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.TokenRequest;
import com.liga.api.method.request.comment.CommentAddRequest;
import com.liga.api.method.request.comment.CommentSelectRequest;
import com.liga.api.method.request.comment.CommentUpdateRequest;
import com.liga.api.method.request.comment.StickerUpdateRequest;
import com.liga.api.method.response.IdResponse;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.client.CommentMethodsClient;
import com.liga.api.method.response.comment.CommentResponse;
import com.liga.api.method.response.comment.StickerInfoResponse;
import com.liga.api.util.http.LigaHttpClient;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
public class CommentMethodsClientImpl implements CommentMethodsClient {

    @Setter
    @Getter
    private String endpointUrlPrefix;
    private final LigaHttpClient ligaHttpClient;

    public CommentMethodsClientImpl(LigaHttpClient ligaHttpClient) {
        this.ligaHttpClient = ligaHttpClient;
    }

    public CommentMethodsClientImpl(String endpointUrlPrefix, LigaHttpClient ligaHttpClient) {
        this.endpointUrlPrefix = endpointUrlPrefix;
        this.ligaHttpClient = ligaHttpClient;
    }

    @Override
    public LigaApiResponse<IdResponse> add(CommentAddRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/add", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, IdResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> update(CommentUpdateRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.patchJsonBody(this.endpointUrlPrefix  + PREFIX + "/update", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<SuccessResponse> remove(IdRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.deleteJsonBody(this.endpointUrlPrefix  + PREFIX + "/remove", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<PageDataList<CommentResponse>> page(CommentSelectRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/page", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<PageDataList<CommentResponse>>>(){});
    }

    @Override
    public LigaApiResponse<SuccessResponse> updateStickerStatus(StickerUpdateRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.patchJsonBody(this.endpointUrlPrefix  + PREFIX + "/update-sticker-status", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response, SuccessResponse.class);
    }

    @Override
    public LigaApiResponse<List<StickerInfoResponse>> listSticker(TokenRequest request) throws LigaApiException, IOException {
        Response response = this.ligaHttpClient.postJsonBody(this.endpointUrlPrefix  + PREFIX + "/list-sticker", request);
        return this.ligaHttpClient.parseJsonResponseAndRunListeners(response,
                new TypeReference<LigaApiResponse<List<StickerInfoResponse>>>(){});
    }
}
