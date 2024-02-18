package com.ajoufesta.dto;


import lombok.Data;


import java.util.List;

import com.ajoufesta.domain.DayBoothes;


@Data
public class AddBoothesDto {
    private List<DayBoothes> boothessByDay;
}
