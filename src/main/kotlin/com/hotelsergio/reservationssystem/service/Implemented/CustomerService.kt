package com.hotelsergio.reservationssystem.service.Implemented

import com.hotelsergio.reservationssystem.entity.Customer
import com.hotelsergio.reservationssystem.repository.customerRepository
import com.hotelsergio.reservationssystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: customerRepository) : ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun findbyId(id: Int): Customer =
        this.customerRepository.findById(id.toInt()).orElseThrow {
            throw RuntimeException("id $id not found")

        }

    override fun delete(id: Long) = this.customerRepository.deleteById(id.toInt())}