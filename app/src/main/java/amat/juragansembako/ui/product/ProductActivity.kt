package amat.juragansembako.ui.product

import amat.juragansembako.ui.theme.JuraganSembakoTheme
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class ProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JuraganSembakoTheme {
                ProductScreenView()
            }
        }
    }
}

@Composable
fun ProductScreenView(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Scaffold(modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                context.startActivity(Intent(context, AddProductActivity::class.java))
            }) {
                Icon(Icons.Filled.Add, "Add Product", tint = Color.White)
            }
        }) {
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductPreview() {
    JuraganSembakoTheme {
        ProductScreenView()
    }
}