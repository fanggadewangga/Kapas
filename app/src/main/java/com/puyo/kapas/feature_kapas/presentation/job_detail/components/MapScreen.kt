package com.puyo.kapas.feature_kapas.presentation.job_detail.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import org.osmdroid.views.overlay.Polyline


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapScreen(
    viewModel: JobDetailViewModel
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val polyLine = Polyline()
    val isLocationPermissionGranted = rememberPermissionState(permission = android.Manifest.permission.ACCESS_FINE_LOCATION)

    polyLine.setPoints(viewModel.polylineGeopoints)
}