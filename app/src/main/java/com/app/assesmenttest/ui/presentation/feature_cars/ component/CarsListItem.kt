package com.app.assesmenttest.ui.presentation.feature_cars.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.assesmenttest.R
import com.app.assesmenttest.room.entity.Cars
import com.app.assesmenttest.ui.shared_components.textfields.LargeText
import com.app.assesmenttest.ui.shared_components.textfields.MediumText
import com.app.assesmenttest.ui.shared_components.textfields.RegularText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarsListItem(
    modifier: Modifier = Modifier,
    item: Cars,
    onClick: (Cars) -> Unit = {}
) {
    Card(modifier = modifier.fillMaxWidth(), onClick = { onClick(item) }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            RegularText(
                text = stringResource(id = R.string.name),
                fontWeight = FontWeight.Bold
            )
            LargeText(text = item.model?:"")
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    RegularText(
                        text = stringResource(id = R.string.make),
                        fontWeight = FontWeight.Bold
                    )
                    MediumText(text = item.make?:"")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    RegularText(
                        text = stringResource(id = R.string.date),
                        fontWeight = FontWeight.Bold
                    )
                    MediumText(text = item.createdon?:"")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    RegularText(
                        text = stringResource(id = R.string.cylinders),
                        fontWeight = FontWeight.Bold
                    )
                    MediumText(text = item.cylinders?:"")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    RegularText(
                        text = stringResource(id = R.string.fuleType),
                        fontWeight = FontWeight.Bold
                    )
                    MediumText(text = item.fueltype?:"")
                }
            }


        }
    }
}

@Preview
@Composable
fun PreviewMedicineListItem() {
    CarsListItem(
        item = Cars(
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