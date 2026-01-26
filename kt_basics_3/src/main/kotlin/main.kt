fun main() {
    val transferAmount = 43579
    val cardType = "visa" // выбор карты
    val monthlySpent = 100000 // потрачено в этом месяце
    val dailySpent = 10000   // потрачено сегодня

    calculateCommission(transferAmount, cardType, monthlySpent, dailySpent)
}

fun calculateCommission(
    amount: Int,
    cardType: String,
    monthlySpent: Int,
    dailySpent: Int
) {
    if (amount > 150000) {
        throw IllegalArgumentException("Превышен дневной лимит")
    }
    if (monthlySpent + amount > 600000) {
        throw IllegalArgumentException("Превышен месячный лимит")
    }

    val dailyTotal = dailySpent + amount
    val monthlyTotal = monthlySpent + amount

    if (dailyTotal > 150000) {
        println("Ошибка: превышен дневной лимит $dailyTotal руб.")
        return
    }
    if (monthlyTotal > 600000) {
        println("Ошибка: превышен месячный лимит $monthlyTotal руб.")
        return
    }

    var commission = 0

    if (cardType == "mir") {
        commission = 0 // комиссия не взимается
    } else if (cardType == "mastercard") {
        val monthlyLimit = 75000
        if (monthlySpent>= monthlyLimit) {
            commission = (amount * 0.006).toInt() + 20
        } else {
            if (monthlyTotal <= monthlyLimit) {
                commission = 0
            } else {
                val excessAmount = monthlyTotal - monthlyLimit
                commission = (excessAmount * 0.006).toInt() + 20
            }
        }
    } else if (cardType == "visa") {
        val calculated = (amount * 0.0075).toInt()
        if (calculated < 35) {
            commission = 35
        } else {
            commission = calculated
        }
    }

    val totalAmount = amount + commission
    println("С карты $cardType был осуществлен перевод на сумму $amount руб. ")
    println("Комиссия составляет: $commission руб.")
    println("Итого к списанию: $totalAmount руб.")
}
