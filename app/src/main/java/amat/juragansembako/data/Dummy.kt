package amat.juragansembako.data

object Dummy {

    private val allProducts = listOf(
        Product(id = "1", name = "Telur", price = 3000, nameUnit = "pcs"),
        Product(id = "2", name = "Telur", price = 40000, nameUnit = "rak"),
        Product(id = "3", name = "Indomie goreng putih", price = 3500, nameUnit = "pcs"),
        Product(id = "4", name = "Indomie goreng putih", price = 50000, nameUnit = "dus"),
        Product(id = "5", name = "Terigu biasa", price = 8000, nameUnit = "kg"),
        Product(id = "6", name = "Beras", price = 8000, nameUnit = "kg"),
        Product(id = "7", name = "Beras super", price = 8000, nameUnit = "liter"),
        Product(id = "8", name = "Bimoli", price = 30000, nameUnit = "liter"),
        Product(id = "9", name = "Minyak curah", price = 20000, nameUnit = "liter"),
        Product(id = "10", name = "Teh gelas", price = 1000, nameUnit = "pcs"),
        Product(id = "11", name = "Mountea", price = 1000, nameUnit = "pcs"),
        Product(id = "12", name = "Lea Mineral", price = 3000, nameUnit = "pcs"),
        Product(id = "13", name = "Aqua", price = 4000, nameUnit = "pcs"),
        Product(id = "14", name = "Sunlight 200 ml", price = 4000, nameUnit = "pcs"),
        Product(id = "15", name = "Sunlight 500 ml", price = 7000, nameUnit = "pcs"),
        Product(id = "16", name = "Daia 500gr", price = 10000, nameUnit = "pcs"),
        Product(id = "17", name = "Daia 900gr", price = 17000, nameUnit = "pcs"),
        Product(id = "18", name = "Momogi", price = 1000, nameUnit = "pcs"),
        Product(id = "19", name = "Momogi", price = 8500, nameUnit = "pack"),
        Product(id = "20", name = "Chocolatos", price = 1000, nameUnit = "pcs"),
        Product(id = "21", name = "Chocolatos", price = 9000, nameUnit = "pack"),
    )

    fun loadAllProduct(): List<Product> {
        return allProducts
    }

    fun loadCart(): List<Product> {
        return listOf(
            Product(id = "21", name = "Chocolatos", price = 9000, nameUnit = "pack", qty = 2),
            Product(id = "17", name = "Daia 900gr", price = 17000, nameUnit = "pcs", qty = 1),
            Product(
                id = "4",
                name = "Indomie goreng putih",
                price = 50000,
                nameUnit = "dus",
                qty = 1
            ),
        )
    }

    fun getProductById(productId: String): Product {
        return allProducts.firstOrNull { it.id == productId }
            ?: Product(id = "-1", name = "", price = 0, nameUnit = "")
    }

    private val allUnit = listOf(
        Unit(id = "1", name = "pcs"),
        Unit(id = "2", name = "kg"),
        Unit(id = "3", name = "liter"),
        Unit(id = "4", name = "rak"),
        Unit(id = "5", name = "dus"),
    )

    fun loadUnit(): List<Unit> {
        return allUnit
    }

    private val allCategory = listOf(
        Category(id = "0", name = "Semua"),
        Category(id = "1", name = "Makanan"),
        Category(id = "2", name = "Minuman"),
        Category(id = "3", name = "Bumbu dapur"),
        Category(id = "4", name = "Atk"),
        Category(id = "5", name = "Bersih - bersih"),
        Category(id = "10", name = "Lainnya"),
    )

    fun loadCategory(): List<Category> {
        return allCategory
    }
}