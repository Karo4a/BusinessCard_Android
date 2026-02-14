package karo4a.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import karo4a.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        fullName = stringResource(R.string.fullName),
                        title = stringResource(R.string.title),
                        phone = stringResource(R.string.phone),
                        social = stringResource(R.string.social),
                        email = stringResource(R.string.email),
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun MainInformation(fullName: String, title: String, modifier: Modifier = Modifier) {
    val imageSize = 200.dp
    val imageOffset = -imageSize*0.7F
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(R.drawable.personphoto),
            contentDescription = null,
            modifier = Modifier
                .size(imageSize)
                .offset(y = imageOffset)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = fullName,
                fontSize = 60.sp,
            )
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
    }
    }


@Composable
fun ContactInformation(phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    val imageSize = 24.dp
    val rowPadding = 4.dp
    val rowSpacedBy = 8.dp
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(rowSpacedBy),
                modifier = Modifier
                    .padding(rowPadding)
            ) {
                Image(
                    painter = painterResource(R.drawable.phone),
                    contentDescription = null,
                    modifier = Modifier.size(imageSize)
                )
                Text(
                    text = phone,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(rowSpacedBy),
                modifier = Modifier
                    .padding(rowPadding)
            ) {
                Image(
                    painter = painterResource(R.drawable.social),
                    contentDescription = null,
                    modifier = Modifier.size(imageSize)
                )
                Text(
                    text = social,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(rowSpacedBy),
                modifier = Modifier
                    .padding(rowPadding)
            ) {
                Image(
                    painter = painterResource(R.drawable.email),
                    contentDescription = null,
                    modifier = Modifier.size(imageSize)
                )
                Text(
                    text = email,
                )
            }
        }

    }
}

@Composable
fun BusinessCard(fullName: String, title: String,
                 phone: String, social: String, email: String,
                 modifier: Modifier = Modifier) {
    Box(modifier) {
        MainInformation(
            fullName = fullName,
            title = title,
            modifier = Modifier
                .fillMaxSize()
        )
        ContactInformation(
            phone = phone,
            social = social,
            email = email,
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            fullName = stringResource(R.string.fullName),
            title = stringResource(R.string.title),
            phone = stringResource(R.string.phone),
            social = stringResource(R.string.social),
            email = stringResource(R.string.email),
        )
    }
}