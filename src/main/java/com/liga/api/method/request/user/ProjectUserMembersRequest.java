package com.liga.api.method.request.user;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectUserMembersRequest implements LigaApiRequest {

    /**用户ID*/
    @NonNull
    private Set<Long> userIds;
    /**项目ID*/
    @NonNull
    private Long projectId;
    @NonNull
    private String token;
}