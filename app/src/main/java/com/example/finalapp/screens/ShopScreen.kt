package com.example.finalapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.finalapp.model.Product
import com.example.finalapp.viewModel.ShopViewModel
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.ScreenKey
import com.github.terrakok.modo.generateScreenKey
import com.github.terrakok.modo.stack.LocalStackNavigation
import com.github.terrakok.modo.stack.StackNavContainer
import com.github.terrakok.modo.stack.forward
import kotlinx.parcelize.Parcelize
import org.koin.androidx.compose.koinViewModel
import com.example.finalapp.ui.theme.Typography
import org.koin.compose.getKoin

@Parcelize
class ShopScreen(
    override val screenKey: ScreenKey = generateScreenKey()
) : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(modifier: Modifier) {
        val navigation = LocalStackNavigation.current
        val viewModel = getKoin().get<ShopViewModel>()
        val state = viewModel.viewState

        Column(Modifier.fillMaxSize()) {
            TopAppBar(title = {
                Text(
                    text = "TopText",
                    Modifier
                        .fillMaxWidth()
                        .clickable { throw Exception("Not implemented") })
            })

            val lazyColumnState = rememberSaveable(saver = LazyListState.Saver) {
                LazyListState(
                    0,
                    0
                )
            }

            state.error?.let {
                Text(text = it)
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null,
                    Modifier.clickable { throw Exception("Not implemented") }
                )
            }

            LazyColumn(
                Modifier.fillMaxSize().padding(horizontal = 15.dp),
                lazyColumnState
            ) {
                items(state.items) {
                    ProductListElement(it, viewModel, navigation)
                }
            }
        }
    }
}

@Composable
fun ProductListElement (
    product: Product,
    viewModel: ShopViewModel,
    navigation: StackNavContainer? = null,
) {
    Row(Modifier
        .fillMaxWidth()
        .clickable { navigation?.forward(ProductScreen(
                product,
                { viewModel.addToCart(product.id) },
                { viewModel.addToFavourite(product) })
            )
        }
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            modifier = Modifier.size(30.dp),
            model = product.iconUrl,
            contentDescription = "product description",
        )
        Text(
            text = product.name,
            style = Typography.titleMedium,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}