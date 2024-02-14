package com.hotelsergio.reservationssystem.repository

import com.hotelsergio.reservationssystem.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface customerRepository: JpaRepository<Customer, Int> 