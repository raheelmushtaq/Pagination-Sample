package com.app.assesmenttest.ui.screens.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.app.assesmenttest.room.entity.Medicine
import com.app.assesmenttest.ui.components.textfields.LargeText
import com.app.assesmenttest.ui.components.textfields.MediumText
import com.app.assesmenttest.ui.components.textfields.RegularText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicineListItem(
    modifier: Modifier = Modifier,
    item: Medicine,
    onClick: (Medicine) -> Unit = {}
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
            LargeText(text = item.name)
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    RegularText(
                        text = stringResource(id = R.string.dose),
                        fontWeight = FontWeight.Bold
                    )
                    MediumText(text = item.dose)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    RegularText(
                        text = stringResource(id = R.string.strength),
                        fontWeight = FontWeight.Bold
                    )
                    MediumText(text = item.strength)
                }
            }


        }
    }
}

@Preview
@Composable
fun PreviewMedicineListItem() {
    MedicineListItem(item = Medicine(1, "adsfasdf", "asdfadf", "asdfa"))

}