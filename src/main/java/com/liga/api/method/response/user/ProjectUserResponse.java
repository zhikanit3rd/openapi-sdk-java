package com.liga.api.method.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectUserResponse {

    /**用户编号*/
    private Long userId;

    /**公司用户名称*/
    private String userName;

    /**头像", example = "https://xxx/1.jpg*/
    private String head;

    /**email", example = "xxx@xxx.net*/
    private String orgEmail;

    /**角色列表*/
    private List<RoleSimpleVO> roleVOList;

    /**分组列表*/
    private List<DepartmentVO> departmentVOList;


    @Data
    public static class RoleSimpleVO{
        /** 角色id*/
        private Long id;

         /** 角色名称 */
        private String roleName;

         /** 角色编码 */
        private String roleCode;
    }

    @Data
    public static class DepartmentVO{
        /** 分组编号 */
        private Long id;
        /** 分组名称 */
        private String deptName;
    }
}