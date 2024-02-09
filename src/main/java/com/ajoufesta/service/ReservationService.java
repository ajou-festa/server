package com.ajoufesta.service;

import com.ajoufesta.dao.ReservationDao;
import com.ajoufesta.domain.Reservation;
import com.ajoufesta.dto.CreateReservationDto;
import com.ajoufesta.dto.GetReservationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    public String createReservation(CreateReservationDto reservationDto) {
        Reservation reservation = convertToDomain(reservationDto);
        Reservation savedReservation = reservationDao.save(reservation);
        return savedReservation.getReservationId();
    }

    public List<GetReservationDto> findReservationsByPhoneNumber(String phoneNumber) {
        List<GetReservationDto> reservationDtos = reservationDao.findByPhoneNumber(phoneNumber)
                .stream()
                .map(this::convertToGetReservationDto)
                .collect(Collectors.toList());

        return reservationDtos;
    }

    private Reservation convertToDomain(CreateReservationDto reservationDto) {
        return Reservation.builder()
                .pubId(reservationDto.getPubId())
                .name(reservationDto.getName())
                .peopleNum(reservationDto.getPeopleNum())
                .phoneNumber(reservationDto.getPhoneNumber())
                .password(reservationDto.getPassword())
                .timestamp(LocalDateTime.now())
                .build();
    }

    private GetReservationDto convertToGetReservationDto(Reservation reservation) {
        return GetReservationDto.builder()
                .pubId(reservation.getPubId())
                .name(reservation.getName())
                .peopleNum(reservation.getPeopleNum())
                .phoneNumber(reservation.getPhoneNumber())
                .turn(1)
                .build();
    }
}
