package ru.afal.alfabattle.restwebsocket.configuration;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Client;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.SneakyThrows;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

public class FeignConfiguration {

  @Bean
  @SneakyThrows
  public Client feignClient(
    @Value("${server.ssl.key-store}") String keystore,
    @Value("${server.ssl.key-store-password}") char[] password
  ) {
    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
    InputStream jksInputStream = new FileInputStream(new File(keystore));
    keyStore.load(jksInputStream, password);
    SSLContext sslContext = SSLContexts.custom()
      .loadKeyMaterial(keyStore, password)
//      .loadTrustMaterial(keystoreFile, password)
      .build();

    return new Client.Default(sslContext.getSocketFactory(), HttpsURLConnection.getDefaultHostnameVerifier());
  }

  @Bean
  public RequestInterceptor requestInterceptor() {
    return template -> template.header("x-ibm-client-id", "c5510d3c-ea4a-4b30-8d58-6377d44bc369");
  }

}
