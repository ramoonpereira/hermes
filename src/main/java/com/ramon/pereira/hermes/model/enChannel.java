package com.ramon.pereira.hermes.model;

import lombok.Getter;

@Getter
public enum enChannel {
    EMAIL(1),
    PUSH(2),
    SMS(3),
    WHATSAPP(4);

    private Integer id;

    enChannel(Integer id) {
        this.id = id;
    }
}
