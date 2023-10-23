package com.liga.api.method.client;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.msg.MsgListRequest;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.response.msg.MsgListResponse;
import com.liga.api.method.LigaApiException;

import java.io.IOException;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface MsgMethodsClient {

    String PREFIX = "msg";

    /**
     * 获取个人消息列表
     * @param msgList
     * @return
     * @throws LigaApiException
     * @throws IOException
     */
    LigaApiResponse<PageDataList<MsgListResponse>> list(MsgListRequest msgList) throws LigaApiException, IOException;
}
