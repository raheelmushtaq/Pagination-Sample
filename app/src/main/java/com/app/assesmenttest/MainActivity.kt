package com.app.assesmenttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.app.assesmenttest.ui.presentation.NavGraphs
import com.app.assesmenttest.ui.theme.Raheel_Assessment_TestTheme
import com.app.assesmenttest.utils.addDelay
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var showSplaah = true
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().setKeepOnScreenCondition {
            showSplaah
        }
        super.onCreate(savedInstanceState)
        addDelay(1000) {
            showSplaah = false
        }
        setContent {
            Raheel_Assessment_TestTheme {
                DestinationsNavHost(
                    navGraph = NavGraphs.root,
                    modifier = Modifier
                        .statusBarsPadding()
                        .background(Color.Black)
                )
            }
        }
    }
}