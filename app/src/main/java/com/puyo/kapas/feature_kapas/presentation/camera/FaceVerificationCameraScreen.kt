package com.puyo.kapas.feature_kapas.presentation.camera

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.core.UseCase
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.components.TopBar
import java.io.File

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun FaceVerificationCameraScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    cameraSelector: CameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA,
    onImageFile: (File) -> Unit = { },
) {
    val context = LocalContext.current
    CameraPermission(
        permission = Manifest.permission.CAMERA,
        rationale = "Izinkan penggunaan kamera untuk verifikasi indentitas Anda.",
        permissionNotAvailableContent = {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text("O noes! No Camera!")
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    context.startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                        data = Uri.fromParts("package", context.packageName, null)
                    }
                    )
                }
                ) {
                    Text("Open Settings")
                }
            }
        }
    ) {
        Column(modifier = modifier) {
            val lifecycleOwner = LocalLifecycleOwner.current
            val coroutineScope = rememberCoroutineScope()
            var previewUseCase by remember { mutableStateOf<UseCase>(Preview.Builder().build()) }
            val imageCaptureUseCase by remember {
                mutableStateOf(
                    ImageCapture.Builder()
                        .setCaptureMode(ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY)
                        .build()
                )
            }

            // Content
            Row {
                TopBar(text = "Verifikasi Wajah")
            }

            Box(modifier = Modifier.fillMaxWidth().background(Color.White)) {
                CameraPreview(
                    modifier = Modifier.fillMaxWidth(),
                    onUseCase = {
                        previewUseCase = it
                    }
                )

                Card(
                    backgroundColor = Color.Transparent,
                    border = BorderStroke(1.dp, Color.White),
                    shape = CircleShape,
                    modifier = Modifier
                        .size(320.dp)
                        .align(Alignment.Center)
                ) {

                }

                Text(
                    text = "Tempatkan wajah Anda di dalam bingkai",
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 340.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.img_camera_button),
                    contentDescription = "Camera Button",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 80.dp)
                        .size(64.dp)
                        .clickable {
                            /*coroutineScope.launch {
                                imageCaptureUseCase.takePicture(context.executor).let {
                                    onImageFile(it)
                                }
                            }*/
                            navController.navigate(Screen.IdentityVerificationScreen.route)
                        }
                )

                LaunchedEffect(previewUseCase) {
                    val cameraProvider = context.getCameraProvider()
                    try {
                        // Must unbind the use-cases before rebinding them.
                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(
                            lifecycleOwner, cameraSelector, previewUseCase, imageCaptureUseCase
                        )
                    } catch (e: Exception) {
                        Log.e("CameraCapture", "Failed to bind camera use cases", e)
                    }
                }

            }
        }
    }
}