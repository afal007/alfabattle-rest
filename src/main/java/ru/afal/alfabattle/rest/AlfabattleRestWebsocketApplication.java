package ru.afal.alfabattle.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("ru.afal.alfabattle")
@SpringBootApplication(scanBasePackages = "ru.afal.alfabattle")
public class AlfabattleRestWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlfabattleRestWebsocketApplication.class, args);
    }

}
