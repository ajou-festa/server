package com.ajoufesta.dto;

import lombok.Data;
import java.util.List;

import com.ajoufesta.domain.DayShows;

@Data
public class AddShowsDto {
    private List<DayShows> showsByDay;
}
