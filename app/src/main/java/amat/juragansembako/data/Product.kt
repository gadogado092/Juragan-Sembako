package amat.juragansembako.data

data class Product(
    val id: String,
    val name: String,
    val qty: Int = 0,
    val price: Int,
    val nameUnit: String
)
