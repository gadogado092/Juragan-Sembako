package amat.juragansembako.ui.product

import amat.juragansembako.ui.theme.JuraganSembakoTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class AddProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JuraganSembakoTheme {
                AddProductScreenView()
            }
        }
    }
}

@Composable
fun AddProductScreenView(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddProductPreview() {
    JuraganSembakoTheme {
        AddProductScreenView()
    }
}