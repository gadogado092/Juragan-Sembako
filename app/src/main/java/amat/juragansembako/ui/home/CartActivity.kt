package amat.juragansembako.ui.home

import amat.juragansembako.currencyFormatterStringViewZero
import amat.juragansembako.data.Dummy
import amat.juragansembako.data.Product
import amat.juragansembako.ui.theme.JuraganSembakoTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JuraganSembakoTheme {
                CartScreenView()
            }
        }
    }
}

@Composable
private fun CartScreenView(modifier: Modifier = Modifier) {

    Column(Modifier.fillMaxSize()) {
        CardCart(modifier = Modifier.weight(1f))
        CardSummaryPayment()
    }
}

@Composable
private fun CardCart(modifier: Modifier = Modifier) {

    Card(
        modifier = modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
                text = "Keranjang Belanja",
                fontWeight = FontWeight.Bold
            )
            ProductList(
                productList = Dummy.loadCart()
            )
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
                    append("${product.qty} ${product.name}")
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
private fun CardSummaryPayment(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = "Ringkasan pembayaran",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    color = Color.Gray,
                    text = "Total Harga"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = "76.000",
                    textAlign = TextAlign.End,
                    color = Color.Gray,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    color = Color.Gray,
                    text = "Diskon"
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    text = "1.000",
                    textAlign = TextAlign.End,
                    color = Color.Gray,
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Card(
                modifier = Modifier
                    .padding(horizontal = 0.dp, vertical = 4.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .clickable {
//                        context.startActivity(Intent(context, CartActivity::class.java))
                    },
                shape = RoundedCornerShape(12.dp),
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Text(
                    text = "Bayar 75.000",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductPreview() {
    JuraganSembakoTheme {
        CartScreenView()
    }
}