/**
 * <pre>
 *  Copyright © 2015~2019 智看科技
 * </pre>
 */
package com.liga.api.method.request.org;


import com.liga.api.method.request.Pageable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 *  @description:
 *  @author: Allen
 *  @email: Allen@zhikan.com
 *  @date: 2019/9/11 11:14
 *  @project: agile-pms
 *  </pre>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllMemberListRequest implements Pageable {

    /** 搜索关键字 */
    private String key;
    private Integer pageNumber;
    private Integer pageSize;
    private String token;
}
