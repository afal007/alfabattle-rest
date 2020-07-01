package ru.afal.alfabattle.dal.atm;

import lombok.Value;

@Value(staticConstructor = "of")
public class WebSocketFilter {
    String value;
}
