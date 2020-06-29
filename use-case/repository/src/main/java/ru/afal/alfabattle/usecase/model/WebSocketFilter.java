package ru.afal.alfabattle.usecase.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class WebSocketFilter {
    String value;
}
