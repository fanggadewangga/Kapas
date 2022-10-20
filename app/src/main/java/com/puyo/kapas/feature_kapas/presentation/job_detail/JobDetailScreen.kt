package com.puyo.kapas.feature_kapas.presentation.job_detail

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.domain.model.job.Job
import com.puyo.kapas.feature_kapas.presentation.jobs.components.DescriptionSection
import com.puyo.kapas.feature_kapas.presentation.jobs.components.JobBottomBar
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Grey
import com.puyo.kapas.ui.theme.Orange

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun JobDetailScreen(navController: NavController, job: Job) {
    val coroutineScope = rememberCoroutineScope()
    val isVisible = mutableStateOf(false)
    val isBookmarked = mutableStateOf(false)

    Scaffold(bottomBar = {
        JobBottomBar(
            wage = 200000.0,
            buttonText = "Melamar",
            paymentDescription = "Jumlah Bayaran",
            navController
        )
    }) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .background(Color.White)
        ) {

            // Top bar (Job image, arrow, title)
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {

                // Job image
                Image(
                    painter = painterResource(id = R.drawable.img_job_bg),
                    contentDescription = "Job Image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.height(197.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_edit_job_background),
                    contentDescription = "Job Background",
                    modifier = Modifier
                        .padding(bottom = 40.dp)
                        .size(height = 16.dp, width = 120.dp)
                        .align(BottomEnd)
                        .clickable {
                            /*TODO*/
                        }
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 56.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "Arrow Back",
                        modifier = Modifier
                            .height(24.dp)
                            .clickable { navController.navigate(Screen.HomeScreen.route) }
                    )
                }

                Text(
                    text = "Detail Pekerjaan",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 56.dp)
                        .align(Alignment.TopCenter)
                )

                // Avatar
                Box(modifier = Modifier
                    .padding(top = 164.dp)
                    .align(Alignment.Center)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_avatar),
                        contentDescription = "User Avatar",
                        modifier = Modifier.size(64.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_verified),
                        contentDescription = "Verified",
                        modifier = Modifier.align(BottomEnd)
                    )
                }

                // Bookmark icon
                Column(modifier = Modifier
                    .align(BottomEnd)
                    .padding(end = 24.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter =
                        if (isBookmarked.value)
                            painterResource(id = R.drawable.ic_bookmark_unselected)
                        else
                            painterResource(id = R.drawable.ic_bookmark_outlined),
                        contentDescription = "Bookmark",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { isBookmarked.value =! isBookmarked.value }
                    )
                }
            }

            // Job Title
            Text(
                text = job.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = 16.dp)
            )

            // Posted by
            Text(
                text = "Diunggah ${job.posterName}",
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = 8.dp)
            )

            // Location and Wage
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(212.dp)
                    .align(CenterHorizontally)
            ) {
                // Location
                Column(horizontalAlignment = CenterHorizontally) {
                    Text(
                        text = "Tempat",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    Text(
                        text = job.location,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                }

                // Line
                Image(
                    painter = painterResource(id = R.drawable.img_vertical_line),
                    contentDescription = "Vertical Line"
                )

                // Wage
                Column(horizontalAlignment = CenterHorizontally) {
                    Text(
                        text = "Jumlah Bayaran",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Rp${job.wage.toString()}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                }
            }

            // Location Detail
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Detail Lokasi",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.img_maps_dummy),
                contentDescription = "Maps",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(160.dp)
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            /* TODO : MAPS API KEY FOR GMS */
            /* GoogleMap(
                 cameraPositionState = cameraPositionState,
                 modifier = Modifier
                     .fillMaxWidth()
                     .height(160.dp)
                     .clip(RoundedCornerShape(8.dp))
             ) {
                 val markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.ic_location)
                 Marker(
                     icon = markerIcon,
                     state = singaporeState
                 )
             }*/

            // Address
            Spacer(modifier = Modifier.height(24.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "Location Marker",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = job.address,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp
                )
            }

            // Divider
            Divider(
                color = Grey,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // Detail
            Text(
                text = "Deskripsi Pekerjaan",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            AnimatedVisibility(
                visible = isVisible.value,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                DescriptionSection(
                    description = job.description
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Lihat Detail",
                fontSize = 14.sp,
                color = Orange,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .clickable {
                        isVisible.value = !isVisible.value
                    }
            )
            Spacer(modifier = Modifier.height(120.dp))
        }
    }
}