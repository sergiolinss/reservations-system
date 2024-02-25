package com.hotelsergio.reservationssystem.exception

data class BusinessException(override val message: String?): RuntimeException(message)
