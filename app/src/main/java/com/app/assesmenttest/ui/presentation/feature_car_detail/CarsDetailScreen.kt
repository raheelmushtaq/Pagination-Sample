package com.app.assesmenttest.ui.presentation.feature_car_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.assesmenttest.R
import com.app.assesmenttest.room.entity.Cars
import com.app.assesmenttest.ui.shared_components.appheader.AppHeader
import com.app.assesmenttest.ui.shared_components.textfields.LargeText
import com.app.assesmenttest.ui.shared_components.textfields.MediumText
import com.app.assesmenttest.ui.shared_components.textfields.RegularText
import com.app.assesmenttest.ui.theme.Raheel_Assessment_TestTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun CarsDetailScreen(navigator: DestinationsNavigator, cars: Cars) {
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
            MedicationDetaiLScreenComponent(cars)
        }
    }
}

@Composable
fun MedicationDetaiLScreenComponent(cars: Cars) {

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
            LargeText(text = cars.model ?: "")
            Spacer(modifier = Modifier.height(10.dp))
            RegularText(
                text = stringResource(id = R.string.dose),
                fontWeight = FontWeight.Bold
            )
            MediumText(text = cars.make ?: "")
            Spacer(modifier = Modifier.height(10.dp))
            RegularText(
                text = stringResource(id = R.string.strength),
                fontWeight = FontWeight.Bold
            )
            MediumText(text = cars.createdon ?: "")
            Spacer(modifier = Modifier.width(10.dp))
            RegularText(
                text = stringResource(id = R.string.make),
                fontWeight = FontWeight.Bold
            )
            MediumText(text = cars.make ?: "")
            Spacer(modifier = Modifier.width(10.dp))
            RegularText(
                text = stringResource(id = R.string.date),
                fontWeight = FontWeight.Bold
            )
            MediumText(text = cars.createdon ?: "")

            Spacer(modifier = Modifier.height(10.dp))
            RegularText(
                text = stringResource(id = R.string.cylinders),
                fontWeight = FontWeight.Bold
            )
            MediumText(text = cars.cylinders ?: "")

            Spacer(modifier = Modifier.width(10.dp))
            RegularText(
                text = stringResource(id = R.string.fuleType),
                fontWeight = FontWeight.Bold
            )
            MediumText(text = cars.fueltype ?: "")


        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    Raheel_Assessment_TestTheme {
        MedicationDetaiLScreenComponent(
            Cars(
                "",
                "asdfadf",
                "asdfasdf",
                "adfasdf",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
            )
        )
    }
}