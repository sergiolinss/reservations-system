package com.hotelsergio.reservationssystem.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.Date
import kotlin.random.Random

@Entity
data class Reservations(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @Column(unique = true, nullable = false) val reservationCode: Long = Random.nextLong(),
    @Column(nullable = false) val checkInDate: LocalDate,
    @Column(nullable = false) val checkOutDate: LocalDate,
    @Column(nullable = false) var reservationValue: BigDecimal = BigDecimal.ZERO
)