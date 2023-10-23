package com.liga.api.method.client.impl;

import com.liga.api.method.AbstractLigaWithToken;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.method.request.project.ProjectIdRequest;
import com.liga.api.method.request.workflow.NextStateRequest;
import com.liga.api.method.response.workflow.WorkflowResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class WorkflowMethodsClientImplTest extends AbstractLigaWithToken {

    @Test
    void list() throws LigaApiException, IOException {
        assertLigaApiResponseSuccess(liga.workflow().list(ProjectIdRequest.builder().token(token).projectId(167019207L).build()));
    }

    @Test
    void listNextState() throws LigaApiException, IOException {
        LigaApiResponse<List<WorkflowResponse>>  listLigaApiResponse = liga.workflow().list(ProjectIdRequest.builder().token(token).projectId(167019207L).build());
        WorkflowResponse workflowResponse = listLigaApiResponse.getData().get(0);
        assertLigaApiResponseSuccess(liga.workflow().listNextState(NextStateRequest.builder()
                        .token(token)
                        .defId(workflowResponse.getId())
                        .stateId(workflowResponse.getStates().get(0).getStateId())
                .build()));
    }
}