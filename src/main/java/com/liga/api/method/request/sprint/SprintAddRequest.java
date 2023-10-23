package com.liga.api.method.request.sprint;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SprintAddRequest implements LigaApiRequest {

    private String token;

        /**迭代名称*/
    @NonNull
    private String name;

    /**开始日期*/
    private Date startDate;

    /**结束日期*/
    private Date endDate;

    /**目标*/
    private String goal;

    /**指派人id*/
    private Long assignee;

    /**项目id*/
    @NonNull
    private Long projectId;
}
