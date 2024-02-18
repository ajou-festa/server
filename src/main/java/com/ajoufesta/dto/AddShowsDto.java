package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

import com.ajoufesta.domain.DayShows;

@Data
@Builder()
public class AddShowsDto {
    private List<DayShows> showsByDay;
}
