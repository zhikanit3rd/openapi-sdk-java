package com.liga.api.method.request.version;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseUpdateRequest implements LigaApiRequest {
    private String token;

    /**版本id*/
    @NonNull
    private Long id;

    /**版本名称*/
    @NonNull
    private String name;

    /**负责人 */
    @NonNull
    private Long ownerId;

    /**开始日期*/
    private Date startDate;

    /**预计发布日期*/
    private Date planDate;

    /**描述*/
    private String description;
}