package com.ramon.pereira.hermes.model;

import lombok.Getter;

@Getter
public enum enEvent {
    SCHEDULED(1),
    SENT(2),
    CANCELED(3);

    private Integer id;

    enEvent(Integer id) {
        this.id = id;
    }
}
