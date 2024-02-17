package com.ajoufesta.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    BOOTH("ROLE_BOOH"),
    PUB("ROLE_PUB");

    private final String value;
}