package buckpal.account.domain

class ActivityWindow(private val activities: MutableList<Activity>) {
    constructor(vararg activities: Activity): this(mutableListOf(*activities))

    fun calculateBalance(accountId: Account.Companion.AccountId): Money {
        val deposits = this.activities
            .filter { activity -> activity.getTargetAccountId() == accountId }
            .fold(Money(0)) { total, activity -> total.plus(activity.getMoney()) }
        val withdrawals = this.activities
            .filter { activity -> activity.getSourceAccountId() == accountId }
            .fold(Money(0)) { total, activity -> total.plus(activity.getMoney()) }

        return Money.add(deposits, withdrawals.negate())
    }

    fun addActivity(activity: Activity) {
        this.activities.add(activity)
    }
}