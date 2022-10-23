package amat.juragansembako.ui.home

import amat.juragansembako.R
import amat.juragansembako.ui.theme.JuraganSembakoTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OtherScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(state = scrollState)
            .background(colorResource(id = R.color.white))
    ) {
        ItemOtherMenu(title = "Kelola Produk")
        ItemOtherMenu(title = "Kelola Satuan Produk")
    }
}

@Composable
fun ItemOtherMenu(modifier: Modifier = Modifier, title: String) {
    Card(
        modifier = modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 8.dp)
                .fillMaxSize()
        ) {
            Text(
                text = title
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JuraganSembakoTheme {
        OtherScreen()
    }
}