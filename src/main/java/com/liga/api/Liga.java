package com.liga.api;

import com.liga.api.method.client.AuthorizeMethodsClient;
import com.liga.api.method.client.CommentMethodsClient;
import com.liga.api.method.client.EpicMethodsClient;
import com.liga.api.method.client.FileMethodsClient;
import com.liga.api.method.client.IssueMethodsClient;
import com.liga.api.method.client.MsgMethodsClient;
import com.liga.api.method.client.OrgMethodsClient;
import com.liga.api.method.client.ProjectMethodsClient;
import com.liga.api.method.client.SprintMethodsClient;
import com.liga.api.method.client.TagMethodsClient;
import com.liga.api.method.client.UserMethodsClient;
import com.liga.api.method.client.VersionMethodsClient;
import com.liga.api.method.client.WebhookMethodsClient;
import com.liga.api.method.client.WorkflowMethodsClient;
import com.liga.api.method.client.impl.AuthorizeMethodsClientImpl;
import com.liga.api.method.client.impl.CommentMethodsClientImpl;
import com.liga.api.method.client.impl.EpicMethodsClientImpl;
import com.liga.api.method.client.impl.FileMethodsClientImpl;
import com.liga.api.method.client.impl.IssueMethodsClientImpl;
import com.liga.api.method.client.impl.MsgMethodsClientImpl;
import com.liga.api.method.client.impl.OrgMethodsClientImpl;
import com.liga.api.method.client.impl.ProjectMethodsClientImpl;
import com.liga.api.method.client.impl.SprintMethodsClientImpl;
import com.liga.api.method.client.impl.TagMethodsClientImpl;
import com.liga.api.method.client.impl.UserMethodsClientImpl;
import com.liga.api.method.client.impl.VersionMethodsClientImpl;
import com.liga.api.method.client.impl.WebhookMethodsClientImpl;
import com.liga.api.method.client.impl.WorkflowMethodsClientImpl;
import com.liga.api.util.http.LigaHttpClient;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description: API主类，建议单例使用
 **/
@Slf4j
public class Liga implements AutoCloseable{

    private final LigaHttpClient httpClient;
    private final LigaConfig config;
    private static final Liga SINGLETON;

    public Liga() {
        this(LigaConfig.DEFAULT);
    }

    private Liga(LigaConfig config) {
        this(config, LigaHttpClient.buildLigaHttpClient(config));
    }

    private Liga(LigaConfig config, LigaHttpClient httpClient) {
        this.httpClient = httpClient;
        this.config = config;
    }

    @Override
    public void close() throws Exception {
        this.httpClient.close();
    }
    public static Liga getInstance() {
        return SINGLETON;
    }

    public static Liga getInstance(LigaConfig config) {
        return new Liga(config);
    }

    public static Liga getInstance(LigaConfig config, LigaHttpClient httpClient) {
        return new Liga(config, httpClient);
    }

    public static Liga getInstance(LigaHttpClient httpClient) {
        return new Liga(LigaConfig.DEFAULT, httpClient);
    }

    public LigaHttpClient getHttpClient() {
        return httpClient;
    }

    public LigaConfig getConfig() {
        return config;
    }

    /**
     * 登录授权模块
     * @return
     */
    public AuthorizeMethodsClient authorize() {
        return new AuthorizeMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 用户模块
     * @return
     */
    public UserMethodsClient user() {
        return new UserMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 组织模块
     * @return
     */
    public OrgMethodsClient org(){
        return new OrgMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 项目模块
     * @return
     */
    public ProjectMethodsClient project(){
        return new ProjectMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 问题模块
     * @return
     */
    public IssueMethodsClient issue(){
        return new IssueMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 冲刺模块
     * @return
     */
    public SprintMethodsClient sprint(){
        return new SprintMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 工作流模块
     * @return
     */
    public WorkflowMethodsClient workflow(){
        return new WorkflowMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 标签模块
     * @return
     */
    public TagMethodsClient tag(){
        return new TagMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 史诗模块
     * @return
     */
    public EpicMethodsClient epic(){
        return new EpicMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 版本模块
     * @return
     */
    public VersionMethodsClient version(){
        return new VersionMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * webhook模块
     * @return
     */
    public WebhookMethodsClient webhook(){
        return new WebhookMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 评论模块
     * @return
     */
    public CommentMethodsClient comment(){
        return new CommentMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 文件模块
     * @return
     */
    public FileMethodsClient file(){
        return new FileMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    /**
     * 个人消息模块
     * @return
     */
    public MsgMethodsClient msg() {
        return new MsgMethodsClientImpl(this.config.getMethodsEndpointUrlPrefix(), this.httpClient);
    }

    static {
        SINGLETON = new Liga(LigaConfig.DEFAULT, new LigaHttpClient());
    }
}
