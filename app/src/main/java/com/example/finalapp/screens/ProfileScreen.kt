package com.example.finalapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.finalapp.viewModel.ProfileViewModel
import com.example.finalapp.viewModel.ShopViewModel
import com.github.terrakok.modo.Screen
import com.github.terrakok.modo.ScreenKey
import com.github.terrakok.modo.generateScreenKey
import kotlinx.parcelize.Parcelize
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin

@Parcelize
class ProfileScreen(
    override val screenKey: ScreenKey = generateScreenKey()
) : Screen {
    @Composable
    override fun Content(modifier: Modifier) {
        //val viewModel = getKoin().get<ProfileViewModel>()
        val viewModel = koinViewModel<ProfileViewModel>()
        val state = viewModel.viewState

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        if (!state.isAuthentificated) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column{
                    TextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Login") }
                    )
                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") }
                    )
                    Button(onClick = {viewModel.login(email, password)}) {
                        Text(text = "Log In")
                    }
                    Button(onClick = {viewModel.login(email, password)}) {
                        Text(text = "Register")
                    }
                }

            }
        }
        else {
            Column{
                Button(onClick = {viewModel.logout()}) {
                    Text("Logout")
                }
            }
        }
    }
}