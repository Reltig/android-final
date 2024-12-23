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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.finalapp.model.CartProduct
import com.example.finalapp.model.Product
import com.example.finalapp.ui.theme.Typography
import com.example.finalapp.viewModel.CartViewModel
import com.example.finalapp.viewModel.ShopViewModel
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.ScreenKey
import com.github.terrakok.modo.generateScreenKey
import com.github.terrakok.modo.stack.forward
import kotlinx.parcelize.Parcelize
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin

@Parcelize
class CartScreen(
    override val screenKey: ScreenKey = generateScreenKey()
) : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content(modifier: Modifier) {
        val viewModel = getKoin().get<CartViewModel>()
        val state = viewModel.viewState

        if (!state.isAuthentificated) {
            Box(modifier = Modifier
                .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Not authentificated")
            }
        }
        else {
            Column(Modifier.fillMaxSize()) {
                TopAppBar(title = {
                    Text(
                        text = "Cart",
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
                        CartListElement(it)
                    }
                }
            }
        }
    }
}

@Composable
fun CartListElement(product: CartProduct) {
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
        Text(text = " Price: ${product.price} x ${product.count} = ${product.price * product.count}")
    }
}