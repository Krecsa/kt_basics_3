fun main() {
    val amountRub = 15000 // сумма покупки
    val regularClient = true

    val finalPrice = calculateFinalPrice(amountRub, regularClient)
    println("Итоговая стоимость покупки: " + finalPrice + " руб.")
}

fun calculateFinalPrice(amount: Int, regularClient: Boolean): Int {
    var discountedAmount: Int

    if (amount <= 0) {
        discountedAmount = 0
    } else if (amount <= 1000) {
        discountedAmount = amount
    } else if (amount <= 10000) {
        discountedAmount = amount - 100 // скидка 100 руб.
    } else {
        discountedAmount = (amount * 0.95).toInt() // 5% скидка
    }

    if (regularClient) {
        discountedAmount = (discountedAmount * 0.99).toInt()
    }

    return discountedAmount
}