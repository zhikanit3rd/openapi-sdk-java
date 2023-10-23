package com.liga.api.util.http;

import com.liga.api.mate.ApiClientLibVersion;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description: 给每个请求带上User-Agent请求头，标识来源的SDK版本信息
 **/
public class UserAgentInterceptor implements Interceptor {

    public static final String USER_AGENT_PREFIX = "Java-Liga-SDK; ";

    private final String userAgent;

    public UserAgentInterceptor(Map<String, String> additionalInfo) {
        this.userAgent = buildDefaultUserAgent(additionalInfo);
    }

    public static String buildDefaultUserAgent(Map<String, String> additionalInfo) {
        String libraryVersion = ApiClientLibVersion.get();
        String library = "liga-api-client/" + libraryVersion + "";
        String jvm = "" + System.getProperty("java.vm.name") + "/" + System.getProperty("java.version") + "";
        String os = "" + System.getProperty("os.name") + "/" + System.getProperty("os.version") + "";
        String lastPart = "";
        for (Map.Entry<String, String> each : additionalInfo.entrySet()) {
            lastPart += " " + each.getKey() + "/" + each.getValue() + ";";
        }
        return USER_AGENT_PREFIX + library + "; " + jvm + "; " + os + ";" + lastPart;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        // Modify "User-Agent" header
        Request request = chain.request().newBuilder().header("User-Agent", userAgent).build();
        return chain.proceed(request);
    }
}
