package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

import com.ajoufesta.domain.DayBoothes;

@Data
@Builder()
public class AddBoothesDto {
    private List<DayBoothes> boothessByDay;
}
