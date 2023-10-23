package com.liga.api.method.client;

import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.workflow.NextStateRequest;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.response.workflow.StateAssociateResponse;
import com.liga.api.method.response.workflow.WorkflowResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface WorkflowMethodsClient {

    String PREFIX = "workflow";

    /**
     * 查询项目工作流列表
     * @param request
     * @return
     */
    LigaApiResponse<List<WorkflowResponse>> list(ProjectIdRequest request) throws LigaApiException, IOException;

    /**
     * 查询可流转状态列表
     * @param request
     * @return
     */
    LigaApiResponse<List<StateAssociateResponse>> listNextState(NextStateRequest request) throws LigaApiException, IOException;
}
