package com.ajoufesta.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder()
public class Show {

    private final Long id;
    private final String showName;
    private final String teamName;
    private final String startTime;
    private final List<String> participants;
    private final boolean isNow;
}