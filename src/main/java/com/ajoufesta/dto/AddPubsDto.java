package com.ajoufesta.dto;

import lombok.Data;
import java.util.List;

import com.ajoufesta.domain.DayPubs;

@Data
public class AddPubsDto {
    private List<DayPubs> pubsByDay;
}
