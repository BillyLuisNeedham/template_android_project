package com.billyluisneedham.multiple_module_detekt_prototype

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.billyluisneedham.multiple_module_detekt_prototype.ui.theme.MultiplemoduledetektprototypeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiplemoduledetektprototypeTheme {
                App()
            }
        }
    }
}
