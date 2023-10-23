package com.liga.api.method.request.msg;

import com.liga.api.method.request.Pageable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgListRequest implements Pageable {

    /** 消息动态类型,
     *  comment(@我的)
     *  follow(我关注的)
     *  responsible(我负责的)
     *  智能助理automation_station_msg
     *  系统消息sys"
     */
    private List<String> category;

     /** 消息是否已读 */
    private Boolean read;

    private Integer pageNumber;
    private Integer pageSize;
    @NonNull
    private String token;
}
