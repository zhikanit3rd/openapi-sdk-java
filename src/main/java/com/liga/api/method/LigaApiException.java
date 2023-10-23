package com.liga.api.method;

import lombok.Getter;
import lombok.Setter;
import okhttp3.Response;

import java.util.Objects;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
@Setter
@Getter
public class LigaApiException extends Exception{

    private Response response;
    private String  responseBody;

    public LigaApiException(Response response, String responseBody) {
        super(buildErrorMessage(response, null));
        this.response = response;
        this.responseBody = responseBody;
    }

    private static String buildErrorMessage(Response response, String responseBody) {
        String message = "status: " + response.code();
        String bodyString = "body: " +  (Objects.nonNull(responseBody) ? responseBody : "no response body");
        return message + ", " + bodyString;
    }
}
