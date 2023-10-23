package com.liga.api.method.request.project;

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
public class ProjectUserRoleSetRequest implements LigaApiRequest {

    /** 项目编号 */
    @NonNull
    private Long projectId;
    /** 用户编号 */
    @NonNull
    private Long userId;
    /** 项目角色编号 */
    @NonNull
    private Set<Long> roleIdList;
    private String token;
}