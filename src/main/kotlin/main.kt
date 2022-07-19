var vkCard = "VK Pay";
var masterCard = "Mastercard";
var visaCard = "Visa";

fun main(){
    val cardType = vkCard;
    val prevSum = 0;
    val sum = 2600101 * 100;
    println("Комисcия по переводу ${sum / 100} рублей составит ${commis(cardType, prevSum, sum)} копеек");
}

fun commis(cardType : String, prevSum : Int, sum : Int) : Int {
    val commisSum = 0;
    when(cardType){
        vkCard -> return limitVkPay(sum, prevSum);
        masterCard -> return limitMasterCard(sum, prevSum);
        visaCard -> return limitVisaCard(sum, prevSum);
    }
    return commisSum;
}

fun limitVkPay(sum: Int, prevSum: Int) : Int {
    var commisSum = 0;
    when {
        sum <= 15_000 * 100 && prevSum + sum <= 40_000 * 100 -> commisSum = 0
        sum > 15_000 * 100 -> println("Перевод не отправлен, превышена максимальная сумма перевода со счета VK Pay за один раз!");
        prevSum + sum > 40_000 * 100 -> println("Перевод не отправлен, превышена максимальная сумма переводов в этом месяце!");
    }

    return commisSum;
}

fun limitMasterCard(sum: Int, prevSum: Int) : Int {
    var commisSum = 0;
    when {
        sum <= 150_000 * 100 && prevSum + sum <= 600_000 * 100 -> commisSum =
            if (sum * 75 / 10_000 <= 3500) 3500 else sum * 75 / 10_000
        sum > 150_000 * 100 -> println("Перевод не отправлен, превышена максимальная сумма перевода по одной карте!");
        prevSum + sum > 600_000 * 100 -> println("Перевод не отправлен, превышена максимальная сумма переводов в этом месяце!");
    }

    return commisSum;
}

fun limitVisaCard(sum: Int, prevSum: Int) : Int {
    var commisSum = 0;
    when {
        sum <= 150_000 * 100 && prevSum + sum <= 600_000 * 100 -> commisSum =
            if (sum * 75 / 10_000 <= 3500) 3500 else sum * 75 / 10_000
        sum > 150_000 * 100 -> println("Перевод не отправлен, превышена максимальная сумма перевода по одной карте!");
        prevSum + sum > 600_000 * 100 -> println("Перевод не отправлен, превышена максимальная сумма переводов в этом месяце!");
    }

    return commisSum;
}