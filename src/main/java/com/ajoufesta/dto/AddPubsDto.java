package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

import com.ajoufesta.domain.DayPubs;

@Data
@Builder()
public class AddPubsDto {
    private List<DayPubs> pubsByDay;
}
