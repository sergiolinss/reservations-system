package com.hotelsergio.reservationssystem.dto

import com.hotelsergio.reservationssystem.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.hibernate.validator.constraints.br.CPF

class CustomerDto (
    @field:NotEmpty(message = "First name cannot be empty")
    val nome: String,
    @field:NotEmpty(message = "Last name cannot be empty")
    val sobrenome: String,
    @field:CPF(message = "CPF invalid")
    val cpf: String,
    @field:NotEmpty(message = "email cannot be empty")
    val email: String,
    ){
        fun toEntity(): Customer = Customer(
            nome = this.nome,
            sobrenome = this.sobrenome,
            cpf = this.cpf,
            email = this.email
        )

    }