package com.hotelsergio.reservationssystem.controller

import com.hotelsergio.reservationssystem.dto.ReservationDto
import com.hotelsergio.reservationssystem.dto.ReservationView
import com.hotelsergio.reservationssystem.dto.ReservationViewList
import com.hotelsergio.reservationssystem.entity.Reservations
import com.hotelsergio.reservationssystem.service.Implemented.ReservatiosService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/reservations")
class ReservationsResource(private val reservatiosService: ReservatiosService) {
    @PostMapping
    fun saveReservation(@RequestBody @Valid reservationDto: ReservationDto): ResponseEntity<String> {
        val reservations: Reservations = this.reservatiosService.save(reservationDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Reservation ${reservations.reservationsCode} - Customer ${reservations.customer?.nome} saved!")
    }

    @GetMapping
    fun findAllByCustomer(@RequestParam(value = "customerId") customerId: Int): ResponseEntity<List<ReservationViewList>> {
        val reservationViewList: List<ReservationViewList> =
            this.reservatiosService.findAllByCustomer(customerId).stream().map { reservations: Reservations
                ->
                ReservationViewList(reservations)
            }.collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(reservationViewList)
    }
    @GetMapping("/{reservationsCode}")
    fun findByReservationsCode(@RequestParam(value = "customerId") customerId: Int, @PathVariable reservationsCode: Long):
            ResponseEntity<ReservationView>{
        val reservations: Reservations = this.reservatiosService.findByReservationsCode(customerId, reservationsCode)
        return ResponseEntity.status(HttpStatus.OK).body(ReservationView(reservations))
    }
}
