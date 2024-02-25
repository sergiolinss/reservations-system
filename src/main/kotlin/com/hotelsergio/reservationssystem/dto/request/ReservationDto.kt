package com.hotelsergio.reservationssystem.dto.request

import com.hotelsergio.reservationssystem.entity.Customer
import com.hotelsergio.reservationssystem.entity.Reservations
import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal
import java.time.LocalDate

data class ReservationDto(
    @field:NotNull(message = "Check-in date cannot be null.")
    @field:FutureOrPresent(message = "Check-in Date cannot be in the past.")
    val checkInDate: LocalDate,
    //validação abaixo com o init
    val checkOutDate: LocalDate,
    @field:NotNull(message = "Reservation Value cannot be null.")
    val reservationValue: BigDecimal,
    val customerId: Long,


    ) {
    init {
        require(checkOutDate.isAfter(checkInDate.plusDays(1))) {
            "Check-out date must be at least 1 day after check-in date."
        }
    }

    fun toEntity(): Reservations = Reservations(
        checkInDate = this.checkInDate,
        checkOutDate = this.checkOutDate,
        reservationValue = this.reservationValue,
        customer = Customer(id = this.customerId)
    )

}