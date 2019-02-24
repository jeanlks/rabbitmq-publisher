package com.rabbit.publish.rabbitpublisher;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public final class CustomMessage implements Serializable {

    private String text;

    public CustomMessage(@JsonProperty("text") String text) {
        this.text = text;
    }
}