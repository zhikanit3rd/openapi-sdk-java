package com.liga.api.method.response.epic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EpicFilterOptionsResponse {
    /** 状态备选值*/
    List<AttributeVO> status;

    /** 负责人备选值 */
    List<AttributeVO> owner;
}
