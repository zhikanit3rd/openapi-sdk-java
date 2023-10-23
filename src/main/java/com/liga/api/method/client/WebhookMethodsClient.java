package com.liga.api.method.client;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.webhook.WebhookAddRequest;
import com.liga.api.method.request.webhook.WebhookIdRequest;
import com.liga.api.method.request.webhook.WebhookPageQueryRequest;
import com.liga.api.method.request.webhook.WebhookUpdateRequest;
import com.liga.api.method.response.PageDataList;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.response.webhook.EventResponse;
import com.liga.api.method.response.webhook.WebhookInfoResponse;
import com.liga.api.method.response.webhook.WebhookTypeResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface WebhookMethodsClient {

    String PREFIX = "webhook";

    /**
     * 获取Webhook类型列表
     * @param request
     * @return
     */
    LigaApiResponse<List<WebhookTypeResponse>> listTypes(ProjectIdRequest request) throws LigaApiException, IOException;

    /**
     * 获取Webhook事件监听列表
     * @param request
     * @return
     */
    LigaApiResponse<List<EventResponse>> listEvents(ProjectIdRequest request) throws LigaApiException, IOException;

    /**
     * 新建Webhook
     * @param request
     * @return
     */
    LigaApiResponse<WebhookInfoResponse> add(WebhookAddRequest request) throws LigaApiException, IOException;

    /**
     * 删除Webhook
     * @param request
     * @return
     */
    LigaApiResponse<WebhookInfoResponse> delete(WebhookIdRequest request) throws LigaApiException, IOException;

    /**
     * 更新Webhook配置信息
     * @param request
     * @return
     */
    LigaApiResponse<WebhookInfoResponse> update(WebhookUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 获取Webhook配置信息
     * @param request
     * @return
     */
    LigaApiResponse<WebhookInfoResponse> get(WebhookIdRequest request) throws LigaApiException, IOException;

    /**
     * 分页查询Webhook配置信息
     * @param request
     * @return
     */
    LigaApiResponse<PageDataList<WebhookInfoResponse>> page(WebhookPageQueryRequest request) throws LigaApiException, IOException;
}
