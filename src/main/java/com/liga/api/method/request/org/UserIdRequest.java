package com.liga.api.method.request.org;


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
public class UserIdRequest implements LigaApiRequest {
    private String token;
    /** 用户id */
    @NonNull
    private Long userId;
}