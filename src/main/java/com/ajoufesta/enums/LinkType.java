package com.ajoufesta.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum LinkType {
    @JsonProperty("instagram")
    INSTAGRAM,
    @JsonProperty("picture")
    PICTURE,
    @JsonProperty("default")
    DEFAULT
}