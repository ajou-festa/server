package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
@Builder()
public class RankingDto {
    @Id
    private Integer studentId;
    private Integer level;
    private String name;
}