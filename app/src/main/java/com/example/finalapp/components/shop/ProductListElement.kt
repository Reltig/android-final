package com.example.finalapp.components.shop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalapp.model.Product
import com.example.finalapp.screens.ProductScreen
import com.github.terrakok.modo.stack.LocalStackNavigation
import com.github.terrakok.modo.stack.StackNavContainer
import com.github.terrakok.modo.stack.forward

@Composable
fun sProductListElement (
    product: Product,
    navigation: StackNavContainer? = LocalStackNavigation.current,
) {
    Box(modifier = Modifier
        .height(30.dp)
        .clickable { navigation?.forward(ProductScreen(product)) }
    ) {
        Text(text = product.name)
    }
}