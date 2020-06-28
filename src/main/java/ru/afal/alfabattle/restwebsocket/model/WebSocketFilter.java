package ru.afal.alfabattle.restwebsocket.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class WebSocketFilter {
  String value;
}
