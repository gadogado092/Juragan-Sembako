package amat.juragansembako

import java.text.DecimalFormat

fun currencyFormatterStringViewZero(num: String): String {
    if (num == "0" || num == "" || num == "null" || num.isEmpty()) {
        return "0"
    }
    try {
        val m = num.toDouble()
        val formatter = DecimalFormat("###,###,###,###,###")
        return formatter.format(m).replace(',', '.')
    } catch (e: Exception) {

    }
    return "0"
}