package com.liga.api.method.response.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {
    
    /**主键id*/
    private Long id;

    /**角色编码，自定义角色为空 */
    private String roleCode;

    /**角色名称  */
    private String roleName;

    /**是否默认角色，默认用色用于添加项目成员*/
    private Byte defaultFlag;

    /**权限类别，0=企业和项目均有，1=公司，2=项目*/
    private Integer authType;
}