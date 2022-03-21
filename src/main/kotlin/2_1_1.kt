fun main(args: Array<String>) {

    println("Введите сумму перевода:")
    println("Введите рубли:")
    val rub = readln()
    println("Введите копейки:")
    val kop = readln()
    println("Введите тип карты: (1, 2, 3)")
    println("1. MasterCard и Maestro")
    println("2. Visa и МИР")
    println("3. VK Pay")
    val typeRead = readln()
    println("Введите сумму предыдущих покупок за месяц в рублях:")
    val sumMonthRead = readln()
    var amount = 0
    var sumMonth = 0
    var type = 0

    val triple = enterUser(rub, kop, type, typeRead, sumMonthRead, sumMonth, amount)
    amount = triple.first
    sumMonth = triple.second
    type = triple.third
    sumMonthOut(amount, sumMonth, type)
}

fun enterUser(
    rub: String,
    kop: String,
    type: Int,
    typeRead: String,
    sumMonthRead: String,
    sumMonth: Int,
    amount: Int
): Triple<Int, Int, Int> {
    var type1 = type
    var sumMonth1 = sumMonth
    var amount1 = amount
    try {
        val amount_ru1 = rub.toInt()
        val amount_k1 = kop.toInt()
        type1 = typeRead.toInt()
        val sumMonth_k = sumMonthRead.toInt()
        sumMonth1 = sumMonth_k * 100
        amount1 = amount_ru1 * 100 + amount_k1
        print("Сумма желаемого перевода равна:")
        println("  " + amount_ru1 + " руб. " + amount_k1 + " коп.")
        println("______________________________________________________________")
    } catch (e: Exception) {
        println("Вы ввели не число")
    }
    return Triple(amount1, sumMonth1, type1)
}

fun sumMonthOut(amount: Int, sumMonth: Int, type: Int): String {
    if ((amount > 150_000_00) || (sumMonth > 600_000_00)) {
        println("Превышен Ваш лимит 150000 рублей в сутки или 600000 рублей в месяц")
        return "Превышен Ваш лимит 150000 рублей в сутки или 600000 рублей в месяц"
    } else {
        commission(type, sumMonth, amount)
        // println(commission(type, sumMonth, amount))
    }
    return "В лимиты уложились"
}

fun commission(
    type: Int,
    sumMonth: Int,
    amount: Int
): Double {
    return when (type) {
        1 -> {
            mastercard(amount)
        }
        2 -> {
            visa(amount)
        }
        3 -> {
            vk(amount, sumMonth)
        }
        else -> {
            println("Ошибка перевода!")
            0.0
        }
    }
}

private fun mastercard(amount: Int) = if (amount < 75000_00) {
    val perevod = (amount / 100.00)
    val procent1 = 0.0
    print(perevod, procent1)
    procent1
} else {
    val procent = ((amount * (0.6 / 100)) + 20_00)
    val perevod = (amount + (procent)) / 100
    val procent1 = procent / 100
    print(perevod, procent1)
    procent
}

private fun visa(amount: Int) = if ((35_00 < amount) && (amount < 150_000_00)) {
    var procent = (amount * 0.75 / 100)
    if (procent < 35_00) {
        procent = 35_00.0
    }
    val perevod = ((amount + (procent)) / 100)
    val procent1 = procent / 100
    print(perevod, procent1)
    procent
} else {
    println("Введенная сумма меньше 35 руб или более 150000 руб. перевод невозможен")
    0.0
}

private fun vk(amount: Int, sumMonth: Int) = if ((15000_00 < amount) || (sumMonth > 40000_00)) {
    println("Превышен лимит для VK Pay. Максимальная сумма 15000 руб. за один раз и не боллее 40000 руб. в месяц.")
    0.0
} else {
    val perevod = (amount / 100.00)
    val procent1 = 0.0
    print(perevod, procent1)
    procent1
}


private fun print(perevod: Double, procent1: Double) {
    println("Всего списано за перевод: ${Math.round(perevod * 100.0) / 100.0}")
    println("Сумма комиссии за перевод: ${Math.round(procent1 * 100.0) / 100.0}")
}