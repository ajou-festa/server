package com.ajoufesta.domain;

import com.ajoufesta.enums.LinkType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Builder()
@Data
public class Club {
    
    @Id
    private Long clubId;
    private String clubName;
    private String clubDetail;
    private String[] clubActivities;
    private String link;
    private LinkType linkIconId;
    private String section;
}