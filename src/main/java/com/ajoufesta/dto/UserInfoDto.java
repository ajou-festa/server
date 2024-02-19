package com.ajoufesta.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {
    private String code;
    private String memberRole;
}
