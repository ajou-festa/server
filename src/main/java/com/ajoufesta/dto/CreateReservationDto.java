package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class CreateReservationDto {
    
    private Long pubId;
    private String name;
    private String peopleNum;
    private String phoneNumber;
    private String password;
}