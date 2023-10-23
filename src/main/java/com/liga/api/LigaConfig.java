package com.liga.api;

import com.liga.api.util.http.listener.DetailedLoggingListener;
import com.liga.api.util.http.listener.HttpResponseListener;
import com.liga.api.util.http.listener.ResponsePrettyPrintingListener;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
@Data
public class LigaConfig {

    /**
     * The underlying HTTP client's read timeout (in milliseconds). The default is 10 seconds.
     * https://square.github.io/okhttp/4.x/okhttp/okhttp3/-ok-http-client/read-timeout-millis/
     */
    private Integer httpClientReadTimeoutMillis;

    /**
     * The underlying HTTP client's write timeout (in milliseconds). The default is 10 seconds.
     * https://square.github.io/okhttp/4.x/okhttp/okhttp3/-ok-http-client/write-timeout-millis/
     */
    private Integer httpClientWriteTimeoutMillis;

    /**
     * The underlying HTTP client's call timeout (in milliseconds).
     * By default there is no timeout for complete calls,
     * but there is for the connect, write, and read actions within a call.
     * https://square.github.io/okhttp/4.x/okhttp/okhttp3/-ok-http-client/call-timeout-millis/
     */
    private Integer httpClientCallTimeoutMillis;

    /**
     * Don't enable this flag in production. This flag enables some validation features for development.
     */
    private boolean libraryMaintainerMode = false;

    private boolean prettyResponseLoggingEnabled = false;

    private List<HttpResponseListener> httpClientResponseHandlers = new ArrayList<>();

    private String methodsEndpointUrlPrefix = "https://ligai.cn/openapi/api/";

    public LigaConfig(){
        this.httpClientResponseHandlers.add(new DetailedLoggingListener());
        this.httpClientResponseHandlers.add(new ResponsePrettyPrintingListener());
    }

    public static final LigaConfig DEFAULT = new LigaConfig(){

        void throwException() {
            throw new UnsupportedOperationException("This config is immutable");
        }

        @Override
        public void setHttpClientReadTimeoutMillis(Integer httpClientReadTimeoutMillis) {
            throwException();
        }

        @Override
        public void setHttpClientWriteTimeoutMillis(Integer httpClientWriteTimeoutMillis) {
            throwException();
        }

        @Override
        public void setHttpClientCallTimeoutMillis(Integer httpClientCallTimeoutMillis) {
            throwException();
        }

        @Override
        public void setMethodsEndpointUrlPrefix(String methodsEndpointUrlPrefix) {
            throwException();
        }

        @Override
        public void setLibraryMaintainerMode(boolean libraryMaintainerMode) {
            throwException();
        }

        @Override
        public void setHttpClientResponseHandlers(List<HttpResponseListener> httpClientResponseHandlers) {
            throwException();
        }
    };
}
