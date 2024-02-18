package com.hotelsergio.reservationssystem.service

import com.hotelsergio.reservationssystem.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findbyId(id: Int): Customer
    fun delete(id: Long)

}