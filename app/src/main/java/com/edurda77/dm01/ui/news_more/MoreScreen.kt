package com.edurda77.dm01.ui.news_more

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.edurda77.dm01.R
import com.edurda77.dm01.ui.theme.background
import com.edurda77.dm01.ui.theme.black
import com.edurda77.dm01.ui.uikit.NavigationBar

@Composable
fun MoreScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: MoreViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = background,
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable { navController.popBackStack() },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
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
                    text = state.value.title,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = black,
                    )
                )
            }
        },
        bottomBar = {
            NavigationBar(navController = navController)
        }
    ) { paddings ->
        Column(
            modifier = modifier
                .padding(paddings)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 30.dp),
        ) {
            AsyncImage(
                modifier = modifier
                    .fillMaxWidth(),
                model = state.value.image,
                contentDescription = "",
                contentScale = ContentScale.FillWidth)
            Spacer(modifier = modifier.height(20.dp))
            Text(
                text = state.value.content,
                style = TextStyle(
                    fontSize = 11.sp,
                    fontWeight = FontWeight(600),
                    color = black,
                )
            )
        }
    }
}