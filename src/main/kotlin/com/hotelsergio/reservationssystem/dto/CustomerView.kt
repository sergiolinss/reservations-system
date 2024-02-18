package com.hotelsergio.reservationssystem.dto

import com.hotelsergio.reservationssystem.entity.Customer
import com.hotelsergio.reservationssystem.entity.Reservations

data class CustomerView (
    val nome: String,
    val sobrenome: String,
    val cpf: String,
    val email: String,
    val allReservation: List<Reservations>
){
    constructor(customer: Customer): this(
        nome = customer.nome,
        sobrenome = customer.sobrenome,
        cpf = customer.cpf,
        email = customer.email,
        allReservation = customer.allReservation
    )
}
