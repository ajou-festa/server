package com.ajoufesta.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Builder
@Document(collection = "vote_results")
public class VoteResult {
    @Id
    private String id;
    private Integer selectedId;
}
