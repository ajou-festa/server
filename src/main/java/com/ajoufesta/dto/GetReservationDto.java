package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class GetReservationDto {
    
    private Long pubId;
    private String name;
    private String peopleNum;
    private String phoneNumber;
    private Integer turn;
}
