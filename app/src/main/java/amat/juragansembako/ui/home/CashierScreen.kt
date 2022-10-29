package amat.juragansembako.ui.home

import amat.juragansembako.R
import amat.juragansembako.currencyFormatterStringViewZero
import amat.juragansembako.data.Category
import amat.juragansembako.data.Dummy
import amat.juragansembako.data.Product
import amat.juragansembako.ui.theme.JuraganSembakoTheme
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CashierScreen() {
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.white))
    ) {
        CardBalance()
        CardProduct()
    }
}

@Composable
private fun CardBalance(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                fontSize = 12.sp,
                color = Color.Gray,
                text = "Total Saldo"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = "Rp 2.010.000",
                textAlign = TextAlign.End
            )
        }
    }
}

@Composable
private fun CardProduct(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column(Modifier.fillMaxSize()) {
            Column(modifier = Modifier.weight(1f)) {
                CategoryList(
                    modifier = Modifier.padding(8.dp),
                    categoryList = Dummy.loadCategory()
                )
                ProductList(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    productList = Dummy.loadAllProduct()
                )
            }

            Card(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 2.dp)
                    .clickable {
                        context.startActivity(Intent(context, CartActivity::class.java))
                    },
                shape = RoundedCornerShape(12.dp),
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 8.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .weight(1f),
                        text = "4 item"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Rp 76.000",
                        textAlign = TextAlign.End
                    )
                }
            }

        }
    }
}

@Composable
private fun CategoryList(categoryList: List<Category>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier) {
        items(categoryList) { category ->
            CategoryItem(category = category, isSelected = category.id == "0")
        }
    }
}

@Composable
private fun ProductList(productList: List<Product>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(productList) { product ->
            ProductItem(
                product = product
            )
        }
    }
}

@Composable
private fun ProductItem(product: Product) {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Box(modifier = Modifier.weight(3f)) {
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append(product.name)
                }
                withStyle(style = SpanStyle(color = Color.Gray, fontSize = 12.sp)) {
                    append(" @${product.nameUnit}")
                }
            })
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            modifier = Modifier.weight(2f),
            text = currencyFormatterStringViewZero(product.price.toString()),
            textAlign = TextAlign.End
        )
    }
}

@Composable
private fun CategoryItem(category: Category, isSelected: Boolean = false) {
    Text(
        modifier = Modifier.padding(horizontal = 8.dp),
        text = category.name,
        color = if (isSelected) {
            MaterialTheme.colors.primary
        } else {
            Color.Gray
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CashierScreenPreview() {
    JuraganSembakoTheme {
        CashierScreen()
//        ProductList(productList = Dummy.loadAllProduct())
    }
}