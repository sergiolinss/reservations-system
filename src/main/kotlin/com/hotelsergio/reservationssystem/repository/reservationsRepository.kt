package com.hotelsergio.reservationssystem.repository

import com.hotelsergio.reservationssystem.entity.Reservations
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface reservationsRepository: JpaRepository<Reservations,Long >