package com.liga.api.method.request.project;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 如果是业务表，此处强制继承BaseEntity，里面定义了业务表通用的字段
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAddRequest implements LigaApiRequest {

    /** 项目名称, 不能超过50字符 */
    @NonNull
    private String projectName;

    /** 项目组织者ID */
    @NonNull
    private Long leaderId;

    /** 描述, 不能超过100字符 */
    private String description;

    /** 项目模版编码 */
    @NonNull
    private String templateCode;
    private String token;
}