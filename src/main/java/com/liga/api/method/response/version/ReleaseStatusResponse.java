package com.liga.api.method.response.version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseStatusResponse {

   /**状态*/
    private String status;

   /**状态名称*/
    private String statusName;
}
