# openAPI SDK For Java

## Maven dependency
```xml
     <dependency>
        <groupId>com.zhikan</groupId>
        <artifactId>openapi-sdk-java</artifactId>    
        <version>1.0.0</version>
    </dependency>
```

## Custom LigaConfig
```java
    LigaConfig ligaConfig = new LigaConfig();
    ligaConfig.setMethodsEndpointUrlPrefix("https://pre.leiga.net/openapi/api/");
    ligaConfig.setLibraryMaintainerMode(false);
    ligaConfig.setPrettyResponseLoggingEnabled(true);
    Liga liga = Liga.getInstance(ligaConfig);

```

## Use Default LigaConfig
```java
    Liga liga = Liga.getInstance();
```

## Simple Demo
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


## openAPI Doc link
https://apifox.com/apidoc/shared-8af53dca-b5fd-4de4-bc89-9a83f5444dae
