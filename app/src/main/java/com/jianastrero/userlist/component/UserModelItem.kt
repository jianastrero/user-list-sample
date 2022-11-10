package com.jianastrero.userlist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jianastrero.userlist.model.UserModel

/**
 * Created by jianj on 11/11/2022.
 */

@Composable
fun UserModel.UserModelItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = id,
                color = Color.Gray,
                modifier = Modifier.padding(12.dp)
            )
            Spacer(
                modifier = Modifier
                    .size(1.dp, 24.dp)
                    .background(Color.LightGray)
            )
            AsyncImage(
                model = imageUrl,
                contentDescription = name,
                modifier = Modifier
                    .padding(12.dp)
                    .size(96.dp)
            )
            Spacer(
                modifier = Modifier
                    .size(1.dp, 24.dp)
                    .background(Color.LightGray)
            )
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(12.dp)
                    .weight(1f)
            )
        }
        Spacer(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 4.dp)
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.LightGray)
        )
    }
}

@Preview
@Composable
private fun UserModelItemPreview() {
    UserModel(
        id = "1",
        name = "John",
        imageUrl = "https://www.alchinlong.com/wp-content/uploads/2015/09/sample-profile.png"
    ).UserModelItem()
}