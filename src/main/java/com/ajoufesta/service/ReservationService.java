package com.ajoufesta.service;

import com.ajoufesta.dao.ReservationDao;
import com.ajoufesta.domain.Reservation;
import com.ajoufesta.dto.CancelReservationDto;
import com.ajoufesta.dto.CreateReservationDto;
import com.ajoufesta.dto.GetReservationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    public String createReservation(CreateReservationDto reservationDto) {
        Reservation reservation = convertToDomain(reservationDto);
        Reservation savedReservation = reservationDao.save(reservation);
        return savedReservation.getReservationId();
    }

    public List<GetReservationDto> getReservationsByPhoneNumber(String phoneNumber) {
        List<GetReservationDto> reservationDtos = reservationDao.findByPhoneNumber(phoneNumber)
                .stream()
                .map(this::convertToGetReservationDto)
                .collect(Collectors.toList());

        return reservationDtos;
    }

    public List<GetReservationDto> getReservationByPubId (String pubId) {
        List<GetReservationDto> reservationDtos = reservationDao.findByPubId(pubId)
                .stream()
                .map(this::convertToGetReservationDto)
                .collect(Collectors.toList());

        return reservationDtos;
    }

    public String cancelReservation(CancelReservationDto cancelReservationDto) {
       Optional<Reservation> optionalReservation = reservationDao.findById(cancelReservationDto.getReservationId());
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            // "cancel"로 상태 변경
            reservation.setStatus("cancel");
            // 변경된 예약 업데이트
            reservationDao.save(reservation);
        } else {
            throw new IllegalArgumentException("Reservation not found with id: " + cancelReservationDto.getReservationId());
        }
        return cancelReservationDto.getReservationId();
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
