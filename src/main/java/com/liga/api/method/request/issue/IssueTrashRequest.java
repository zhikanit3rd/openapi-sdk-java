package com.liga.api.method.request.issue;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueTrashRequest implements LigaApiRequest {

    private String token;

    /**项目id列表*/
    private List<Long> projectIds;

    /**标题*/
    private String summary;

    /**删除人id列表*/
    private Set<Long> deleteBys;

    /**删除开始时间*/
    private Date startDeleteTime;

    /**删除结束时间*/
    private Date endDeleteTime;

    /**删除时间排序规则（ASC=正序；DESC=倒序）*/
    private String deleteTimeOrderBy = "DESC";

}
