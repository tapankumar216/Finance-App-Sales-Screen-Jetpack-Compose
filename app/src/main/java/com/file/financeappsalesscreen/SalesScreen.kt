package com.file.financeappsalesscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.file.financeappsalesscreen.ui.theme.CustomCyan
import com.file.financeappsalesscreen.ui.theme.CustomDarkGray
import com.file.financeappsalesscreen.ui.theme.CustomLightGreen
import com.file.financeappsalesscreen.ui.theme.CustomLightOrange
import com.file.financeappsalesscreen.ui.theme.CustomOrange

@Composable
fun SalesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(CustomDarkGray, CustomLightGreen)
                )
            )
            .padding(25.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.more),
                    contentDescription = "More",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        width = 1.dp,
                        color = CustomOrange,
                        shape = RoundedCornerShape(20f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(40.dp),
                    painter = painterResource(R.drawable.david),
                    contentDescription = "Profile Pic"
                )

            }
        }
        LazyRow(
            modifier = Modifier
                .height(250.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            items(year2022Sales) { item ->
                SingleBar(
                    monthlySalesData = item
                )
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            text = "Sales Revenue",
            fontSize = 26.sp,
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.ubuntu))
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {

                InfoCard(
                    modifier = Modifier.weight(8f),
                    icon = painterResource(R.drawable.ic_sales),
                    mainText = "230k",
                    subText = "Sales"
                )
                Spacer(modifier = Modifier.weight(1f))
                InfoCard(
                    modifier = Modifier.weight(11f),
                    icon = painterResource(R.drawable.ic_wallet),
                    mainText = "1.423k",
                    subText = "Products"
                )
                

            }
            Spacer(modifier = Modifier.width(20.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {

                InfoCard(
                    modifier = Modifier.weight(10f),
                    icon = painterResource(R.drawable.ic_user),
                    mainText = "8.549k",
                    subText = "Customers"
                )
                Spacer(modifier = Modifier.weight(1f))
                InfoCard(
                    modifier = Modifier.weight(8f),
                    icon = painterResource(R.drawable.ic_chart),
                    mainText = "$9745",
                    subText = "Revenue"
                )
                Spacer(modifier = Modifier.weight(1f))

            }

        }

    }
}

@Composable
fun InfoCard(
    modifier: Modifier = Modifier,
    icon: Painter,
    mainText: String,
    subText: String
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth()
            .background(Color.White.copy(alpha = 0.1f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Icon(
                painter = icon,
                contentDescription = mainText,
                modifier = Modifier.size(25.dp),
                tint = Color.White
            )

            Text(
                text = mainText,
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.ubuntu)),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 10.dp)

            )

            Text(
                text = subText,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.ubuntu)),
                color = Color.White

            )
        }
    }
}

@Composable
fun SingleBar(
    monthlySalesData: MonthlySalesData
) {

    Column(
       horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${monthlySalesData.salesInThousand}k", color = Color.White, fontFamily = FontFamily(Font(R.font.ubuntu)))
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp
                    )
                )
                .background(
                    if (year2022Sales.indexOf(monthlySalesData) % 2 == 0) {
                        CustomLightOrange
                    } else CustomCyan
                )
                .width(40.dp)
                .height(
                    (200 * monthlySalesData.salesInThousand / largestSalesValue).dp
                )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = monthlySalesData.month, color = Color.White, fontFamily = FontFamily(Font(R.font.ubuntu)))
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    SalesScreen()
}