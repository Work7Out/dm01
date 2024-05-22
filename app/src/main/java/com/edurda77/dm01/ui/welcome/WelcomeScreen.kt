package com.edurda77.dm01.ui.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.edurda77.dm01.R
import com.edurda77.dm01.domain.model.tabs
import com.edurda77.dm01.domain.utils.LOGO_SCREEN
import com.edurda77.dm01.ui.theme.background
import com.edurda77.dm01.ui.theme.black
import com.edurda77.dm01.ui.theme.grey
import com.edurda77.dm01.ui.theme.yellow
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    navController: NavHostController
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        pageCount = {
            tabs.size
        },
        initialPage = 0
    )
    HorizontalPager(
        state = pagerState
    ) {
        ItemPager(
            image = tabs[it].image,
            slider = tabs[it].slider,
            title = tabs[it].title,
            description = tabs[it].description,
            onClickNext = {
                coroutineScope.launch {
                    if (it< tabs.size-1) {
                        pagerState.scrollToPage(it + 1)
                    } else {
                        navController.navigate(LOGO_SCREEN)
                    }
                }
            },
            isLast = it >= tabs.size-1,
            onClickSkip = {
                navController.navigate(LOGO_SCREEN)
            })
    }
}

@Composable
fun ItemPager(
    modifier: Modifier = Modifier,
    image: Int,
    slider: Int?,
    title: Int,
    isLast: Boolean,
    description: Int,
    onClickNext: () -> Unit,
    onClickSkip: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = background)
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = modifier.size(270.dp),
            painter = painterResource(id = image),
            contentDescription = "",
            contentScale = ContentScale.FillHeight,
        )
        Spacer(modifier = modifier.height(36.dp))
        Text(
            modifier = modifier.fillMaxWidth(),
            text = stringResource(id = title),
            style = TextStyle(
                fontSize = 29.sp,
                fontWeight = FontWeight(700),
                color = black,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = modifier.height(36.dp))
        Text(
            modifier = modifier.fillMaxWidth(),
            text = stringResource(id = description),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = grey,
                textAlign = TextAlign.Center
            )
        )
        if (slider != null) {
            Spacer(modifier = modifier.height(16.dp))
            Image(
                painter = painterResource(id = slider),
                contentDescription = "",
            )
        }
        Spacer(modifier = modifier.height(40.dp))
        Button(
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = yellow
            ),
            contentPadding = PaddingValues(
                vertical = 15.dp,
                horizontal = 45.dp
            ),
            onClick = onClickNext
        ) {
            Text(
                text = if (isLast) stringResource(R.string.teach) else stringResource(R.string.next),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = black,
                )
            )
        }
        if (!isLast){
            Spacer(modifier = modifier.height(23.dp))
            TextButton(onClick = onClickSkip) {
                Text(
                    text = stringResource(R.string.skip),
                    style = TextStyle(
                        textDecoration = TextDecoration.Underline,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = black,
                    )
                )
            }
        }
    }
}
