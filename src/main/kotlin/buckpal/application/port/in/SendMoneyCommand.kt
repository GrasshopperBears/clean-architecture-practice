package buckpal.application.port.`in`

import buckpal.account.domain.Account.Companion.AccountId
import buckpal.account.domain.Money

data class SendMoneyCommand(
    val sourceAccountId: AccountId,
    val targetAccountId: AccountId,
    val money: Money) {

    init {
        require(money.isPositive())
    }
}