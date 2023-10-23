package com.liga.api.util.http.listener;

import com.alibaba.fastjson.JSON;
import com.liga.api.LigaConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Ferry
 * @create: 2023/10/19
 * @description:
 **/
@Slf4j
public class ResponsePrettyPrintingListener extends HttpResponseListener {

    @Override
    public void accept(State state) {
        try{
            LigaConfig config = state.getConfig();
            String body = state.getParsedResponseBody();
            if (config.isPrettyResponseLoggingEnabled() && body != null && body.trim().startsWith("{")) {
                if (log.isDebugEnabled()){
                    log.debug("--- Pretty printing the response ---\n" +
                            JSON.toJSONString(body, true) + "\n" +
                            "-----------------------------------------");
                }
            }
        } catch (Exception e){
            log.error("Failed to pretty print the response because {}", e.getMessage(), e);
        }
    }
}
