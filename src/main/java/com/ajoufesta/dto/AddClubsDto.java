package com.ajoufesta.dto;


import com.ajoufesta.domain.Clubs;
import lombok.Data;

import java.util.List;


@Data
public class AddClubsDto {
    private List<Clubs> clubsByDay;
}
