package com.liga.api.method.response.workflow;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StateAssociateResponse {
    
    /**状态主键*/
    private Long stateId;

    /**状态名称*/
    private String stateName;

    /**状态描述*/
    private String stateDesc;

    /**状态类别(2 未开始, 3 进行中, 4 已完成)", example = "2*/
    private Integer stateCategory;

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    public Integer getStateCategory() {
        return stateCategory;
    }

    public void setStateCategory(Integer stateCategory) {
        this.stateCategory = stateCategory;
    }
}
