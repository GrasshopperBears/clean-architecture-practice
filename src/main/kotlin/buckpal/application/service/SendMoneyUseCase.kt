package buckpal.application.service

import buckpal.application.port.`in`.SendMoneyCommand

interface SendMoneyUseCase {
    fun sendMoney(command: SendMoneyCommand): Boolean
}