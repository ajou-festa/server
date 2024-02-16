package com.ajoufesta.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder()
@Document(collection = "reservations")
@Data
public class Reservation { 
    @Id
    private final String reservationId;
    private final String pubId;
    private final String name;

    @Setter
    private String status;
    private final String peopleNum;
    private final String phoneNumber;
    private final String password;
    private final LocalDateTime timestamp;
}