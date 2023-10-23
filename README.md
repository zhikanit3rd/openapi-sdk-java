# Java语言版本的openAPI SDK实现

## 依赖
```xml
     <dependency>
        <groupId>com.zhikan</groupId>
        <artifactId>openapi-sdk-java</artifactId>    
        <version>1.0.0</version>
    </dependency>
```

## 指定配置
```java
    LigaConfig ligaConfig = new LigaConfig();
    ligaConfig.setMethodsEndpointUrlPrefix("https://pre.leiga.net/openapi/api/");
    ligaConfig.setLibraryMaintainerMode(false);
    ligaConfig.setPrettyResponseLoggingEnabled(true);
    Liga liga = Liga.getInstance(ligaConfig);

```

## 默认配置
```java
    Liga liga = Liga.getInstance();
```

## 简单示例
```java
        LigaConfig ligaConfig = new LigaConfig();
        ligaConfig.setLibraryMaintainerMode(false);
        ligaConfig.setPrettyResponseLoggingEnabled(true);
        Liga liga = Liga.getInstance(ligaConfig);

        LigaApiResponse<AccessTokenResponse> ligaTextApiResponse = null;
        try {
            ligaTextApiResponse = liga.authorize().accessToken(AccessTokenRequest.builder()
                    .clientId("clientId")
                    .secretKey("secretKey")
                    .build());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LigaApiException e) {
            e.printStackTrace();
        }
        String token = ligaTextApiResponse.getData().getAccessToken();

```


## openAPI相关接口文档
https://apifox.com/apidoc/shared-8af53dca-b5fd-4de4-bc89-9a83f5444dae