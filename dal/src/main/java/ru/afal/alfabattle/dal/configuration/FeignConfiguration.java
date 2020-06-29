package ru.afal.alfabattle.dal.configuration;

import java.io.File;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.Client;
import feign.RequestInterceptor;
import lombok.SneakyThrows;

public class FeignConfiguration {

    @Bean
    @SneakyThrows
    public Client feignClient(
        @Value("${server.ssl.key-store}") String keystore, @Value("${server.ssl.key-store-password}") char[] password
    ) {
        SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(new File(keystore), password, password).build();

        return new Client.Default(sslContext.getSocketFactory(), HttpsURLConnection.getDefaultHostnameVerifier());
    }

    @Bean
    public RequestInterceptor requestInterceptor(@Value("${atm.service.client-key}") String clientKey) {
        return template -> template.header("x-ibm-client-id", clientKey);
    }
}
