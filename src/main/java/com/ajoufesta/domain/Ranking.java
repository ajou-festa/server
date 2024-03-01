package com.ajoufesta.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "rankings")
@Builder()
public class Ranking {
    @Id
    private final Integer studentId;

    @Indexed
    private Integer level;
    
    private String name;
    private String major;
}