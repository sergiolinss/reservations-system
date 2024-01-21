package com.hotelsergio.reservationssystem.entity

import jakarta.persistence.*


@Entity
data class Customer(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(nullable = false) var id: Int? = null,
    @Column(nullable = false) var nome: String = "",
    @Column(nullable = true) var sobrenome: String = "",
    @Column(nullable = false) var email: String = ""



    )
