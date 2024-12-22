package com.example.finalapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
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
    override val screenKey: ScreenKey = generateScreenKey()
) : Screen {

    @Composable
    override fun Content(modifier: Modifier) {
        Row(Modifier
            .fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.Unspecified, CircleShape)
                    .border(1.dp, Color.Black, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = product.name, style = Typography.titleMedium)
            }
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
        }
    }
}
