package com.edurda77.dm01.ui.about

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.edurda77.dm01.R
import com.edurda77.dm01.domain.utils.EMAIL
import com.edurda77.dm01.domain.utils.LIZ_LINK
import com.edurda77.dm01.domain.utils.PHONE
import com.edurda77.dm01.domain.utils.TG_LINK
import com.edurda77.dm01.domain.utils.VK_LINK
import com.edurda77.dm01.domain.utils.YOUTUBE_LINK
import com.edurda77.dm01.ui.theme.background
import com.edurda77.dm01.ui.theme.black
import com.edurda77.dm01.ui.uikit.NavigationBar
import com.edurda77.dm01.ui.uikit.ZoomableImage

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val context = LocalContext.current
    val expanded = remember {
        mutableStateOf(false)
    }
    val liz_url = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight(600),
                fontSize = 14.sp,
                color = black
            )
        ) {
            append(stringResource(R.string.tr_1))
        }
        append(" ")
        pushStringAnnotation(
            tag = stringResource(R.string.tr_2), annotation = ""
        )
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight(600),
                fontSize = 14.sp,
                color = black,
                textDecoration = TextDecoration.Underline,
            )
        ) {
            append(stringResource(id = R.string.tr_2))
        }
        pop()
    }
    if (expanded.value) {
        Dialog(onDismissRequest = { expanded.value = false }) {
            Column (
                modifier = modifier
                    .clip(shape = RoundedCornerShape(5.dp))
                    .fillMaxWidth()
                    .background(color = background)
                    .padding(15.dp)
            ) {
                IconButton(
                    modifier = modifier.align(alignment = Alignment.End),
                    onClick = {
                        expanded.value = false
                }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(
                            id = R.drawable.baseline_close_24
                        ),
                        contentDescription = "",
                        tint = black
                    )
                }
                Spacer(modifier = modifier.height(15.dp))
                Text(
                    text = stringResource(R.string.liz_title),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        color = black,
                    )
                )
                Spacer(modifier = modifier.height(21.dp))
                ClickableText(
                    modifier = modifier.fillMaxWidth(),
                    onClick = { offset ->
                        liz_url.getStringAnnotations(
                            tag = "государственной лицензии № Л035−1 271−78/643 885 от 16 марта 2023 года.",
                            offset,
                            offset
                        )
                            .firstOrNull()?.let { annotation ->
                                val uri = Uri.parse(LIZ_LINK)
                                val intent = Intent(Intent.ACTION_VIEW, uri)
                                context.startActivity(intent)
                            }
                    },
                    text = liz_url,
                )
                Spacer(modifier = modifier.height(25.dp))
                Text(
                    text = stringResource(R.string.prof),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = black,
                    )
                )
                Spacer(modifier = modifier.height(25.dp))
                Text(
                    text = stringResource(R.string.prof1),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = black,
                    )
                )
                Spacer(modifier = modifier.height(20.dp))
                LazyRow (
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    item {
                        ZoomableImage(model = R.drawable.diplom)
                    }
                    item {
                        ZoomableImage(model = R.drawable.certificat)
                    }
                    item {
                        ZoomableImage(model = R.drawable.credential)
                    }
                }
                Spacer(modifier = modifier.height(20.dp))
                Image(
                    modifier = modifier.align(alignment = Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.logo_liz),
                    contentDescription = ""
                )
            }
        }
    }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = background,
        topBar = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(30.dp),
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
        },
        bottomBar = {
            NavigationBar(navController = navController)
        }
    ) { paddings ->
        Column(
            modifier = modifier
                .padding(paddings)
                .fillMaxSize()
                .padding(horizontal = 30.dp),
        ) {
            Text(
                text = stringResource(R.string.contacts),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    color = black,
                )
            )
            Spacer(modifier = modifier.height(25.dp))
            ItemContact(
                image = R.drawable.ic_vk,
                title = stringResource(id = R.string.vk_group),
                onClick = {
                    val uri = Uri.parse(VK_LINK)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    context.startActivity(intent)
                }
            )
            Spacer(modifier = modifier.height(25.dp))
            ItemContact(
                image = R.drawable.ic_tg,
                title = stringResource(id = R.string.telegram),
                onClick = {
                    val uri = Uri.parse(TG_LINK)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    context.startActivity(intent)
                }
            )
            Spacer(modifier = modifier.height(25.dp))
            ItemContact(
                image = R.drawable.ic_you_tybe,
                title = stringResource(id = R.string.you_tube),
                onClick = {
                    val uri = Uri.parse(YOUTUBE_LINK)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    context.startActivity(intent)
                }
            )
            Spacer(modifier = modifier.height(25.dp))
            ItemContact(
                image = R.drawable.ic_phone,
                title = stringResource(id = R.string.to_call),
                onClick = {
                    val u = Uri.parse("tel:$PHONE")
                    val i = Intent(Intent.ACTION_DIAL, u)
                    try {
                        context.startActivity(i)
                    } catch (s: SecurityException) {
                        Toast.makeText(context, "An error occurred", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            )
            Spacer(modifier = modifier.height(25.dp))
            ItemContact(
                image = R.drawable.ic_ask,
                title = stringResource(id = R.string.ask),
                onClick = {
                    val emailAddress = arrayOf(EMAIL)
                    val i = Intent(Intent.ACTION_SEND)
                    i.putExtra(Intent.EXTRA_EMAIL,emailAddress)
                    i.putExtra(Intent.EXTRA_SUBJECT,"Спросить")
                    i.setType("message/rfc822")
                    context.startActivity(Intent.createChooser(i,"Выберете почтовый клиент"))
                }
            )
            Spacer(modifier = modifier.height(25.dp))
            ItemContact(
                image = R.drawable.ic_liz,
                title = stringResource(id = R.string.liz),
                onClick = {
                    expanded.value = true
                }
            )
        }
    }
}

@Composable
fun ItemContact(
    modifier: Modifier = Modifier,
    image: Int,
    title: String,
    onClick:()-> Unit, 
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = modifier.size(24.dp),
            painter = painterResource(id = image),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = modifier.width(19.dp))
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                color = black,
            )
        )
        Spacer(modifier = modifier.weight(1f))
        IconButton(onClick = onClick) {
            Icon(
                imageVector = ImageVector.vectorResource(
                    id = R.drawable.baseline_arrow_forward_ios_24
                ),
                contentDescription = "",
                tint = black
            )
        }
    }
}