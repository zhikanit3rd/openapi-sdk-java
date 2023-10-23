package com.liga.api.method.client;

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
import com.liga.api.method.response.comment.CommentResponse;
import com.liga.api.method.response.comment.StickerInfoResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface CommentMethodsClient {
    String PREFIX = "comment";

    /**
     * 添加评论
     * @param request
     * @return
     */
    LigaApiResponse<IdResponse> add(CommentAddRequest request) throws LigaApiException, IOException;

    /**
     * 更新评论
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> update(CommentUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 删除评论
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> remove(IdRequest request) throws LigaApiException, IOException;

    /**
     * 评论列表
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<CommentResponse>> page(CommentSelectRequest request) throws LigaApiException, IOException;

    /**
     * 更新表情
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> updateStickerStatus(StickerUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 获取表情列表
     * @param request
     * @return
     */
    LigaApiResponse<List<StickerInfoResponse>> listSticker(TokenRequest request) throws LigaApiException, IOException;

}
