package com.ajoufesta.dao;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajoufesta.domain.Reservation;
import java.util.List;

public interface ReservationDao extends MongoRepository<Reservation, String> {
    List<Reservation> findByPhoneNumber(String phoneNumber);
}
