package com.ajoufesta.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder()
public class PubDto {
    private  Long pubId;
    private  String pubName;
    private  String teamName;
    private  String phoneNum;
    private  String description;
    private  String menuImageSrc;
    private  String link;
    private  String linkIconId;
    private  String pubLocation;
}
