package com.liga.api.method.response.comment;

import com.liga.api.method.response.user.UserSimpleVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiStickerVO  {
    
    /**表情编码*/
    private String stickerCode;

    /**是否包括自己*/
    private Boolean containsSelf;

    /**回复此表情的用户列表*/
    private List<UserSimpleVO> replyUserList;
}
