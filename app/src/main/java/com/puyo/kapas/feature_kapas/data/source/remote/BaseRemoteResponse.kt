package com.puyo.kapas.feature_kapas.data.source.remote

import android.util.Log
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


abstract class BaseRemoteResponse<RequestType> {

    private val value = flow {
        val response = call()
        val data = response.data
        Log.d("Base Remote Response", response.data.toString())
        if (response.status == "200") {
            if(data is List<*>) {
                if (response.count == 0)
                    emit(RemoteResponse.Empty())
                else
                    emit(RemoteResponse.Success(data))
            } else {
                emit(RemoteResponse.Success(data))
            }
        }
    }.catch {
        emit(RemoteResponse.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    abstract suspend fun call(): BaseResponse<RequestType>
    fun asFlow() = value
}