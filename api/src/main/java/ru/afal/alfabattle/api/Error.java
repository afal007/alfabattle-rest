package ru.afal.alfabattle.api;

import lombok.Value;

@Value(staticConstructor = "withStatus")
public class Error {
    String status;
}
