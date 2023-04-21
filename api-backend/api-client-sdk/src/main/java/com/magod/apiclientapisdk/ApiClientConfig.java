package com.magod.apiclientapisdk;

import com.magod.apiclientapisdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: api-client-sdk
 * @description:
 * @author: ma
 * @create: 2023-04-12 09:50
 */
@Configuration
@ConfigurationProperties("api.client")
@Data
@ComponentScan
public class ApiClientConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public ApiClient getApiClient(){
        return new ApiClient(accessKey,secretKey);
    }
}
