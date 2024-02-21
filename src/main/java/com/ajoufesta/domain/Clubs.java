package com.ajoufesta.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "clubs")
@Builder()
public class Clubs {
    @Id
    private int day;
    private List<Club> clubs;
}