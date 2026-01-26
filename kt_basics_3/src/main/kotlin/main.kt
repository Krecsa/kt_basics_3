fun main() {
    val amountRub = 15000 // сумма покупки
    val regularClient = true

    val finalPrice = calculateFinalPrice(amountRub, regularClient)
    println("Итоговая стоимость покупки: $finalPrice руб.")
}

fun calculateFinalPrice(amount: Int, regularClient: Boolean): Int {
    val baseDiscountedAmount = when {
        amount <= 0 -> 0
        amount <= 1000 -> amount
        amount <= 10000 -> amount - 100 // скидка 100 руб.
        else -> (amount * 0.95).toInt() // 5% скидка
    }

    return if (regularClient) {
        (baseDiscountedAmount * 0.99).toInt()
    } else {
        baseDiscountedAmount
    }
}
