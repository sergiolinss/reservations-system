package com.hotelsergio.reservationssystem.service

import com.hotelsergio.reservationssystem.entity.Reservations

interface IReservationsService {
    fun save(resevations: Reservations): Reservations
    fun findAllByCustomer(customerId: Int): List<Reservations>
    fun findByReservationsCode(customerId: Int, reservationCode: Long): Reservations
}