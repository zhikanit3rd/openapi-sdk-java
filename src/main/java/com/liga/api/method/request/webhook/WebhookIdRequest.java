package com.liga.api.method.request.webhook;

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
public class WebhookIdRequest implements LigaApiRequest {
    private String token;

    @NonNull
    private Long webhookId;
}
