package com.puyo.kapas.feature_kapas.presentation.job_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.puyo.kapas.feature_kapas.data.repository.Repository
import kotlinx.coroutines.launch
import org.osmdroid.util.GeoPoint


class JobDetailViewModel(private val repository: Repository) : ViewModel() {

    private var _userCurrentLongitude = mutableStateOf(0.0)
    var userCurrentLongitude: MutableState<Double> = _userCurrentLongitude

    private var _userCurrentLatitude = mutableStateOf(0.0)
    var userCurrentLatitude: MutableState<Double> = _userCurrentLatitude

    var userLocation = LatLng(userCurrentLatitude.value, userCurrentLongitude.value)

    private var _isLocationPermissionGranted = MutableLiveData(false)
    var isLocationPermissionGranted: LiveData<Boolean> = _isLocationPermissionGranted

    val polylineGeopoints = mutableStateListOf<GeoPoint>()

    fun updateUserLocation(latLng: LatLng) {
        _userCurrentLatitude.value = latLng.latitude
        _userCurrentLongitude.value = latLng.longitude
    }

    fun updateLocationPermission(isGranted: Boolean) {
        _isLocationPermissionGranted.value = isGranted
    }

    fun fetchJobDetail(jobId: String) {
        viewModelScope.launch {

        }
    }
}