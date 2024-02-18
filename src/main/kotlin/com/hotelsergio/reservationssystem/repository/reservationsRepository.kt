package com.hotelsergio.reservationssystem.repository

import com.hotelsergio.reservationssystem.entity.Reservations
import jakarta.persistence.Id
import org.hibernate.validator.constraints.CreditCardNumber
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface reservationsRepository: JpaRepository<Reservations,Long >{
    fun findByReservationsCode(reservationsCode: Long): Reservations?

    @Query(value = "SELECT * FROM RESERVATIONS WHERE RESERVATIONS_ID = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Int): List<Reservations>


}