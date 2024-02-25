package com.hotelsergio.reservationssystem.dto.request

import com.hotelsergio.reservationssystem.entity.Customer

data class CustomerUpdateDto (
    val nome: String,
    val sobrenome: String,
    val email: String


){
    fun toEntity(customer: Customer): Customer{
        customer.nome = this.nome
        customer.sobrenome = this.sobrenome
        customer.email = this.email
        return customer
    }
}


