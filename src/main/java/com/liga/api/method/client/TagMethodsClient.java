package com.liga.api.method.client;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.tag.TagAddRequest;
import com.liga.api.method.request.tag.TagUpdateRequest;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.response.tag.TagResponse;
import com.liga.api.method.LigaApiException;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface TagMethodsClient {
    String PREFIX = "tag";

    /**
     *新建标签
     * @param request
     * @return
     */
    LigaApiResponse<TagResponse> add(TagAddRequest request) throws LigaApiException, IOException;

    /**
     *更新标签
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> update(TagUpdateRequest request) throws LigaApiException, IOException;

    /**
     *删除标签
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> remove(IdRequest request) throws LigaApiException, IOException;

    /**
     * 获取标签列表
     * @param request
     * @return
     */
    LigaApiResponse<List<TagResponse>> list(ProjectIdRequest request) throws LigaApiException, IOException;
}
