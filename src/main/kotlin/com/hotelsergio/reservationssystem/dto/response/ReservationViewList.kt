package com.hotelsergio.reservationssystem.dto.response

import com.hotelsergio.reservationssystem.entity.Reservations
import java.math.BigDecimal
import java.time.LocalDate

data class ReservationViewList (
    val reservationCode: Long?,
    val checkInDate: LocalDate,
    val checkOutDate: LocalDate,
    val reservationValue: BigDecimal
    ) {
    constructor(reservations: Reservations): this(
        reservationCode = reservations.reservationsCode,
        reservationValue = reservations.reservationValue,
        checkInDate = reservations.checkInDate,
        checkOutDate = reservations.checkOutDate

    )

}
