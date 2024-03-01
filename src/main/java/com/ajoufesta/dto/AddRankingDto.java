package com.ajoufesta.dto;

import lombok.Data;

@Data
public class AddRankingDto {
    private Integer studentId;
    private Integer level;
    private String name;
    private String major;
    private String password;
}
