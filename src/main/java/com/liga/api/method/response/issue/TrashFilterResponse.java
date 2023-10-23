package com.liga.api.method.response.issue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrashFilterResponse {

    /** 删除人列表*/
    private List<IssueFieldOptionVO> deleteByOptionList;

    /** 项目列表 */
    private List<IssueFieldOptionVO> projectOptionList;
}
