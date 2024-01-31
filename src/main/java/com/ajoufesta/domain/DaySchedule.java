package com.ajoufesta.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "shows")
@Builder()
public class DaySchedule {
    @Id
    private String id;
    private int day;
    private List<Show> shows;

}