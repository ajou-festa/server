package com.ajoufesta.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "boothes")
@Builder()
public class DayBoothes {
    @Id
    private int day;
    private List<Booth> boothes;
}