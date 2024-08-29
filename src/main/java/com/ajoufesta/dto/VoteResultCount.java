package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoteResultCount {
    private Integer selectedId;
    private long count;
}
