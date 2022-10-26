package com.puyo.kapas.feature_kapas.presentation.job_detail

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.jobs.components.DescriptionSection
import com.puyo.kapas.feature_kapas.presentation.jobs.components.JobBottomBar
import com.puyo.kapas.feature_kapas.presentation.post_job.components.PostJobDialog
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Grey
import com.puyo.kapas.ui.theme.Orange
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun JobDetailScreen(navController: NavController, jobId: String) {
    val viewModel = getViewModel<JobDetailViewModel>()
    val coroutineScope = rememberCoroutineScope()
    val isVisible = mutableStateOf(false)
    val isBookmarked = mutableStateOf(false)
    val dialogState = remember {
        mutableStateOf(false)
    }
    val searchResult = viewModel.fetchJobDetail(jobId)
    val job = viewModel.job.value
    val jobLocation = LatLng(job?.latitude ?: -7.983908, job?.longitude ?: 112.621391)
    val jobLocationState = MarkerState(position = jobLocation)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(jobLocation, 10f)
    }

    Scaffold(bottomBar = {
        JobBottomBar(
            wage = job?.wage,
            buttonText = "Melamar",
            paymentDescription = "Jumlah Bayaran"
        ) {
            dialogState.value = true
        }
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
                GlideImage(
                    imageModel = {
                        job?.imageUrl
                    },
                    previewPlaceholder = R.drawable.img_job_bg,
                    imageOptions = ImageOptions(contentScale = ContentScale.FillWidth, contentDescription = "Job Background"),
                    modifier = Modifier.height(197.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_edit_job_background),
                    contentDescription = "Edit Job Image",
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
                    GlideImage(
                        imageModel = {
                            job?.posterAvatarUrl
                        },
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(64.dp)
                        ,
                        previewPlaceholder = R.drawable.img_avatar
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
                            .clickable { isBookmarked.value = !isBookmarked.value }
                    )
                }
            }

            // Job Title
            job?.title?.let { it1 ->
                Text(
                    text = it1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(top = 16.dp)
                )
            }

            // Posted by
            if (job != null) {
                Text(
                    text = "Diunggah ${job.posterName}",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(top = 8.dp)
                )
            }

            // Location and Wage
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(240.dp)
                    .align(CenterHorizontally)
            ) {
                // Location
                Column(horizontalAlignment = CenterHorizontally) {
                    Text(
                        text = "Tempat",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    if (job != null) {
                        Text(
                            text = job.location,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

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
                    if (job != null) {
                        Text(
                            text = "Rp${job.wage}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

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
             GoogleMap(
                 cameraPositionState = cameraPositionState,
                 modifier = Modifier
                     .height(160.dp)
                     .padding(horizontal = 16.dp)
                     .clip(RoundedCornerShape(8.dp))
             ) {
                 val markerIcon = BitmapDescriptorFactory.defaultMarker(
                     BitmapDescriptorFactory.HUE_ORANGE
                 )
                 Marker(
                     state = jobLocationState,
                     icon = markerIcon
                 )
             }

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
                job?.let { it1 ->
                    Text(
                        text = it1.address,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 12.sp
                    )
                }
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
                job?.let { it1 ->
                    DescriptionSection(
                        description = it1.description
                    )
                }
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

            // Dialog
            if (dialogState.value)
                PostJobDialog(navController = navController)
        }
    }
}