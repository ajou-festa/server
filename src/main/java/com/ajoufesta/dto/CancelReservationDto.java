package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class CancelReservationDto {
    private String reservationId;
    private String password;
}
