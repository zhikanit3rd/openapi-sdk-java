package com.liga.api.method.request.issue;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueRelationshipRequest implements LigaApiRequest {

    private String token;

    /** 事项id */
    @NonNull
    protected Long issueId;

    /** linkedIssueId */
    @NonNull
    protected Long linkedIssueId;

    /** 关联类型,
     * RELATES_TO(普通关联)
     * ,PARENT(父级是),
     * CHILD(子级是),
     * BLOCKS(阻碍了),
     * IS_BLOCKS_BY(受阻于),
     * CAUSES前因是,
     * IS_CAUSED_BY(后续是),
     * REPEAT(重复),
     * DUPLICATES(复制),
     * IS_DUPLICATES_BY(复制自)
     * */
    @NonNull
    protected String type;
}
