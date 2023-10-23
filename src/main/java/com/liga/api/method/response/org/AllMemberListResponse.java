package com.liga.api.method.response.org;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllMemberListResponse {

    /** 用户编号 */
    private Long userId;
    /** 用户名称 */
    private String userName;
    /** 头像 */
    private String head;
    /** email */
    private String orgEmail;
    /** 角色列表 */
    private List<RoleSimpleVO> roleVOList;

    @Data
    public static class RoleSimpleVO {
         /** 角色id */
        private Long id;

        /**角色名称 */
        private String roleName;

        /**角色编码 */
        private String roleCode;
    }
}