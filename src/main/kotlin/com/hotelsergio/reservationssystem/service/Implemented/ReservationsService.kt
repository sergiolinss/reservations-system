package com.hotelsergio.reservationssystem.service.Implemented

import com.hotelsergio.reservationssystem.entity.Reservations
import com.hotelsergio.reservationssystem.repository.reservationsRepository
import com.hotelsergio.reservationssystem.service.IReservationsService
import org.springframework.stereotype.Service

@Service
class ReservatiosService(
    private val reservationsRepository: reservationsRepository,
    private val customerService: CustomerService
) : IReservationsService {
    override fun save(resevations: Reservations): Reservations {
        resevations.apply { customer = customerService.findbyId(resevations.customer?.id!!) }
        return this.reservationsRepository.save(resevations)
    }

    override fun findAllByCustomer(customerId: Int): List<Reservations> =
        this.reservationsRepository.findAllByCustomerId(customerId)

    override fun findByReservationsCode(customerId: Int, reservationCode: Long): Reservations {
        val reservations: Reservations = (this.reservationsRepository.findByReservationsCode(reservationCode)
            ?: throw RuntimeException("Reservations Code $reservationCode not found"))
        return if (reservations.customer?.id?.toInt() == customerId) reservations else throw RuntimeException("Contact admin")
    }
}