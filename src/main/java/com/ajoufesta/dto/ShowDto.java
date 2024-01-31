package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.*;

@Data
@Builder()
public class ShowDto {
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String showName;

    private boolean isNow;

    @NotNull
    private String teamName;

    @NotNull
    private String startTime;

    private List<@NotNull String> participants; // 리스트의 각 요소에 대한 Null 체크

}
