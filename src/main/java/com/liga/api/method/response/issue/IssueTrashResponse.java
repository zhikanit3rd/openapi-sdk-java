package com.liga.api.method.response.issue;

import com.liga.api.method.response.user.UserSimpleVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueTrashResponse {
    
    /**id*/
    private Long id;

    /**标题*/
    private String summary;

    /**项目编号*/
    private Long projectId;

    /**项目名称*/
    private String projectName;

    /**事项类型*/
    private IssueTypeSimpleVO issueType;

    /**事项删除人*/
    private UserSimpleVO deleteBy;

    /**事项删除时间*/
    private Date deleteTime;
}
