package com.edurda77.dm01.ui.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.edurda77.dm01.R
import com.edurda77.dm01.ui.logo.LogoEvent
import com.edurda77.dm01.ui.theme.black
import com.edurda77.dm01.ui.theme.grey

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    search: String,
    onSearch: (String) -> Unit,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable (onClick = onClick),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = ImageVector.vectorResource(
                        id = R.drawable.baseline_arrow_back_24
                    ),
                    contentDescription = "",
                    tint = black
                )
            }
            Spacer(modifier = modifier.width(10.dp))
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = black,
                )
            )
        }
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 6.dp),
            shape = RoundedCornerShape(100.dp),
            textStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = black,
            ),
            value = search,
            trailingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_search_24),
                    contentDescription = "",
                    tint = grey
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = grey,
                    )
                )
            },
            onValueChange = {
                onSearch(it)
            })
    }
}


@Composable
fun TopAppBarLogo(
    modifier: Modifier = Modifier,
    search: String,
    event: (LogoEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_machene),
                contentDescription = ""
            )
            Spacer(modifier = modifier.width(10.dp))
            Text(
                text = stringResource(R.string.logo_mash),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = black,
                )
            )
        }
        Spacer(modifier = modifier.height(20.dp))
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 6.dp),
            shape = RoundedCornerShape(100.dp),
            textStyle = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = black,
            ),
            value = search,
            trailingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_search_24),
                    contentDescription = "",
                    tint = grey
                )
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = grey,
                    )
                )
            },
            onValueChange = {
                event(LogoEvent.onSearch(it))
            })
    }
}