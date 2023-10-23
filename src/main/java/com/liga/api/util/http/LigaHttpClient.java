package com.liga.api.util.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.liga.api.LigaConfig;
import com.liga.api.method.LigaApiException;
import com.liga.api.method.LigaApiRequest;
import com.liga.api.method.LigaApiResponse;
import com.liga.api.util.http.listener.HttpResponseListener;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
@Slf4j
public class LigaHttpClient implements AutoCloseable{

    private static final String ACCESS_TOKEN_HEADER_NAME = "accessToken";
    private static final String TOKEN = "token";
    private static final MediaType MEDIA_TYPE_APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");

    private final OkHttpClient okHttpClient;

    private LigaConfig config = LigaConfig.DEFAULT;

    public static LigaHttpClient buildLigaHttpClient(LigaConfig config) {
        return buildLigaHttpClient(config, Collections.emptyMap());
    }

    public static LigaHttpClient buildLigaHttpClient(LigaConfig config, Map<String, String> userAgentCustomInfo) {
        LigaHttpClient httpClient = new LigaHttpClient(buildOkHttpClient(config, userAgentCustomInfo));
        httpClient.setConfig(config);
        return httpClient;
    }

    public static OkHttpClient buildOkHttpClient(LigaConfig config) {
        return buildOkHttpClient(config, Collections.emptyMap());
    }

    public static OkHttpClient buildOkHttpClient(LigaConfig config, Map<String, String> userAgentCustomInfo) {
        final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new UserAgentInterceptor(userAgentCustomInfo));
        if (config.getHttpClientReadTimeoutMillis() != null) {
            okHttpClient.readTimeout(config.getHttpClientReadTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
        if (config.getHttpClientWriteTimeoutMillis() != null) {
            okHttpClient.writeTimeout(config.getHttpClientWriteTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
        if (config.getHttpClientCallTimeoutMillis() != null) {
            okHttpClient.callTimeout(config.getHttpClientCallTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
        return okHttpClient.build();
    }

    public LigaHttpClient() {
        this(Collections.emptyMap());
    }

    public LigaHttpClient(Map<String, String> userAgentCustomInfo) {
        this(LigaConfig.DEFAULT, userAgentCustomInfo);
    }

    public LigaHttpClient(LigaConfig config, Map<String, String> userAgentCustomInfo) {
        this.okHttpClient = buildOkHttpClient(config, userAgentCustomInfo);
    }

    public LigaHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public void close() throws Exception {
        this.okHttpClient.dispatcher().executorService().shutdown();
        this.okHttpClient.connectionPool().evictAll();
        if (this.okHttpClient.cache() != null) {
            this.okHttpClient.cache().close();
        }
    }

    public LigaConfig getConfig() {
        return config;
    }

    public void setConfig(LigaConfig config) {
        this.config = config;
    }

    /**
     * 发起get请求
     * @param url
     * @param queryRequest
     * @return
     * @throws IOException
     */
    public Response get(String url, LigaApiRequest queryRequest) throws IOException {
        String token = null;
        if (queryRequest != null) {
            HttpUrl.Builder u = HttpUrl.parse(url).newBuilder();
            JSONObject query = JSON.parseObject(JSON.toJSONString(queryRequest));
            for (Map.Entry<String, Object> each : query.entrySet()) {
                if (TOKEN.equals(each.getKey())){
                    token = Objects.nonNull(each.getValue()) ? each.getValue().toString() : null;
                    continue;
                }
                if (Objects.nonNull(each.getValue())) {
                    u = u.addQueryParameter(each.getKey(), each.getValue().toString());
                }
            }
            url = u.build().toString();
        }
        final Request request;
        if (token != null) {
            Request.Builder rb = new Request.Builder().url(url).header(ACCESS_TOKEN_HEADER_NAME, token).get();
            request = rb.build();
            return okHttpClient.newCall(request).execute();
        } else {
            request = new Request.Builder().url(url).get().build();
        }
        return okHttpClient.newCall(request).execute();
    }

    /**
     * 上传文件
     * @param url
     * @param token
     * @param file
     * @return
     * @throws IOException
     */
    public Response postMultipart(String url, @NonNull String token, @NonNull File file) throws IOException {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), RequestBody.create(file, MediaType.parse("multipart/form-data")))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader(ACCESS_TOKEN_HEADER_NAME, token)
                .build();
        return okHttpClient.newCall(request).execute();
    }


    /**
     * 发起Post请求
     * @param url
     * @param request
     * @return
     * @throws IOException
     */
    public Response postJsonBody(String url, LigaApiRequest request) throws IOException {
        RequestBody body = RequestBody.create(toJsonString(request), MEDIA_TYPE_APPLICATION_JSON);
        Request.Builder requestBuilder = new Request.Builder()
                .header("Content-Type", "application/json")
                .url(url).post(body);
        if (Objects.nonNull(request) && Objects.nonNull(request.getToken()) && !request.getToken().trim().isEmpty()){
            requestBuilder.header(ACCESS_TOKEN_HEADER_NAME, request.getToken());
        }
        return okHttpClient.newCall(requestBuilder.build()).execute();
    }

    /**
     * 发起delete请求
     * @param url
     * @param request
     * @return
     * @throws IOException
     */
    public Response deleteJsonBody(String url,  LigaApiRequest request) throws IOException {
        RequestBody body = RequestBody.create(toJsonString(request), MEDIA_TYPE_APPLICATION_JSON);
        Request.Builder requestBuilder = new Request.Builder()
                .header("Content-Type", "application/json")
                .url(url).delete(body);
        if (Objects.nonNull(request) && Objects.nonNull(request.getToken()) && !request.getToken().trim().isEmpty()){
            requestBuilder.header(ACCESS_TOKEN_HEADER_NAME, request.getToken());
        }
        return okHttpClient.newCall(requestBuilder.build()).execute();
    }

    /**
     * 发起patch请求
     * @param url
     * @param request
     * @return
     * @throws IOException
     */
    public Response patchJsonBody(String url,  LigaApiRequest request) throws IOException {
        RequestBody body = RequestBody.create(toJsonString(request), MEDIA_TYPE_APPLICATION_JSON);
        Request.Builder requestBuilder = new Request.Builder()
                .header("Content-Type", "application/json")
                .url(url).patch(body);
        if (Objects.nonNull(request) && Objects.nonNull(request.getToken()) && !request.getToken().trim().isEmpty()){
            requestBuilder.header(ACCESS_TOKEN_HEADER_NAME, request.getToken());
        }
        return okHttpClient.newCall(requestBuilder.build()).execute();
    }

    /**
     * 解析结果，指定泛型的类型
     * @param response
     * @param t
     * @param <T>
     * @return
     * @throws IOException
     * @throws LigaApiException
     */
    public <T> LigaApiResponse<T> parseJsonResponseAndRunListeners(
            Response response, Class<T> t) throws IOException, LigaApiException {
        String body = response.body().string();
        if (!response.isSuccessful()) {
            throw new LigaApiException(response, body);
        }
        try{
            TypeReference<LigaApiResponse<T>> typeReference = new TypeReference<LigaApiResponse<T>>(t) {};
            return JSON.parseObject(body, typeReference);
        } finally {
            runHttpResponseListeners(response, body);
        }
    }

    /**
     * 解析结果，指定TypeReference
     * @param response
     * @param typeReference
     * @param <T>
     * @return
     * @throws IOException
     * @throws LigaApiException
     */
    public <T> LigaApiResponse<T> parseJsonResponseAndRunListeners(
            Response response, TypeReference<LigaApiResponse<T>> typeReference) throws IOException, LigaApiException {
        String body = response.body().string();
        if (!response.isSuccessful()) {
            throw new LigaApiException(response, body);
        }
        try{
            return JSON.parseObject(body, typeReference);
        } finally {
            runHttpResponseListeners(response, body);
        }
    }

    /**
     * 返回结果体的流
     * @param response
     * @return
     * @throws IOException
     * @throws LigaApiException
     */
    public InputStream parseStreamResponseAndRunListeners(Response response) throws IOException, LigaApiException {
        if (!response.isSuccessful()) {
            throw new LigaApiException(response, response.body().string());
        }
        return response.body().byteStream();
    }

    /**
     * 请求参数对象转JSON
     * @param obj
     * @return
     */
    private String toJsonString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        } else {
           return JSON.toJSONString(obj);
        }
    }

    /**
     * 执行结果监听
     * @param response
     * @param body
     */
    public void runHttpResponseListeners(Response response, String body) {
        HttpResponseListener.State state = new HttpResponseListener.State(config, response, body);
        for (HttpResponseListener responseListener : config.getHttpClientResponseHandlers()) {
            responseListener.accept(state);
        }
    }
}
