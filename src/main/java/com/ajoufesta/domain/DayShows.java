package com.ajoufesta.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "shows")
@Builder()
public class DayShows {
    @Id
    private int day;
    private List<Show> shows;
    
    public void updateShowStatus(int showId) {
        if(showId!=0){
            shows.get(showId-1).setStatus(ShowStatus.DONE);
        }
        shows.get(showId).setStatus(ShowStatus.IN_PROGRESS);
    }
}

