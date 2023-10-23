package com.liga.api.method.response.issue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueSubTaskFieldResponse {

    /** 字段编码 */
    private String fieldCode;

    /** 类型编码 */
    private String controlCode;

    /** 选项值列表 */
    private List<IssueFieldOptionVO> options;

}
