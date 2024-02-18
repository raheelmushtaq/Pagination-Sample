package com.app.assesmenttest.ui.screens.medicine_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.assesmenttest.R
import com.app.assesmenttest.room.entity.Medicine
import com.app.assesmenttest.ui.components.appheader.AppHeader
import com.app.assesmenttest.ui.components.textfields.LargeText
import com.app.assesmenttest.ui.components.textfields.MediumText
import com.app.assesmenttest.ui.components.textfields.RegularText
import com.app.assesmenttest.ui.theme.Raheel_Assessment_TestTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination()
@Composable
fun MedicineDetailScreen(navigator: DestinationsNavigator, medicine: Medicine) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column {

            AppHeader(
                navHostController = navigator,
                title = stringResource(id = R.string.detail),
                showBackButton = true
            )
            MedicationDetaiLScreenComponent(medicine)
        }
    }
}

@Composable
fun MedicationDetaiLScreenComponent(medicine: Medicine) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            RegularText(
                text = stringResource(id = R.string.name),
                fontWeight = FontWeight.Bold
            )
            LargeText(text = medicine.name)
            Spacer(modifier = Modifier.height(10.dp))
            RegularText(
                text = stringResource(id = R.string.dose),
                fontWeight = FontWeight.Bold
            )
            MediumText(text = medicine.dose)
            Spacer(modifier = Modifier.height(10.dp))
            RegularText(
                text = stringResource(id = R.string.strength),
                fontWeight = FontWeight.Bold
            )
            MediumText(text = medicine.strength)

        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    Raheel_Assessment_TestTheme {
        MedicationDetaiLScreenComponent(Medicine(0, "asdfadf", "asdfasdf", "adfasdf"))
    }
}