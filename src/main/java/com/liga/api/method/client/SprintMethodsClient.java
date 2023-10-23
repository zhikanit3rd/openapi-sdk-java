package com.liga.api.method.client;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.IdRequest;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.sprint.SprintAddRequest;
import com.liga.api.method.request.sprint.SprintIdRequest;
import com.liga.api.method.request.sprint.SprintUpdateRequest;
import com.liga.api.method.response.SuccessResponse;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.response.sprint.SprintCountResponse;
import com.liga.api.method.response.sprint.SprintResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface SprintMethodsClient {

    String PREFIX = "sprint";

    /**
     * 新建迭代
     * @param request
     * @return
     */
    LigaApiResponse<SprintResponse> add(SprintAddRequest request) throws LigaApiException, IOException;

    /**
     * 更新迭代
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> update(SprintUpdateRequest request) throws LigaApiException, IOException;

    /**
     * 删除迭代
     * @param request
     * @return
     */
    LigaApiResponse<SuccessResponse> remove(SprintIdRequest request) throws LigaApiException, IOException;

    /**
     * 获取迭代信息
     * @param request
     * @return
     */
    LigaApiResponse<SprintResponse> get(IdRequest request) throws LigaApiException, IOException;

    /**
     * 获取迭代列表
     * @param request
     * @return
     */
    LigaApiResponse<List<SprintCountResponse>> listWithCount(ProjectIdRequest request) throws LigaApiException, IOException;
}
