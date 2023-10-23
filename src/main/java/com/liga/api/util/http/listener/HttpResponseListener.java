package com.liga.api.util.http.listener;

import com.liga.api.LigaConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import okhttp3.Response;

import java.util.function.Consumer;

/**
 * @author: Ferry
 * @create: 2023/10/19
 * @description:
 **/
public abstract class HttpResponseListener implements Consumer<HttpResponseListener.State> {

    @Override
    public abstract void accept(State state);

    @AllArgsConstructor
    @Data
    public static class State {
        private LigaConfig config;
        private Response response;
        private String parsedResponseBody;
    }

}
