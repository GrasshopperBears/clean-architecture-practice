package buckpal.application.service

import buckpal.application.port.`in`.SendMoneyCommand

class SendMoneyService(): SendMoneyUseCase {
    override fun sendMoney(command: SendMoneyCommand): Boolean {
        requireNotNull(command.sourceAccountId.id)
        requireNotNull(command.targetAccountId.id)

        TODO("validate business rules & change model state")
    }
}