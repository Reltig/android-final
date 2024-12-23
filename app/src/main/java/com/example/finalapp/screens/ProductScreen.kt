package com.example.finalapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.finalapp.model.Product
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.ScreenKey
import com.github.terrakok.modo.generateScreenKey
import kotlinx.parcelize.Parcelize
import com.example.finalapp.ui.theme.Typography
import com.example.finalapp.viewModel.ShopViewModel

@Parcelize
class ProductScreen(
    private val product: Product,
    private val addToCart: () -> Unit,
    private val addToFavourite: () -> Unit,
    override val screenKey: ScreenKey = generateScreenKey()
) : Screen {

    @Composable
    override fun Content(modifier: Modifier) {
        Column(
            modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            AsyncImage(
                model = product.iconUrl,
                contentDescription = "Product image",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = product.description,
                    style = Typography.titleMedium,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                )
                Button(onClick = addToCart) {
                    Text(text = "Add to cart")
                }
                Button(onClick = addToFavourite) {
                    Text(text = "Add to favourite")
                }
            }
            Text(
                text = product.description,
                style = Typography.bodySmall
            )
        }
    }
}
