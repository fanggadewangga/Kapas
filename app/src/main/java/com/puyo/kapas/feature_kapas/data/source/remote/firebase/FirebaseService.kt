package com.puyo.kapas.feature_kapas.data.source.remote.firebase

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseService @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseStorage: FirebaseStorage,
) {
    // Check logged in status
    fun isLoggedIn(): Boolean = firebaseAuth.currentUser != null

    // Get User
    fun getCurrentUserId() = firebaseAuth.currentUser?.uid

    // Register
    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
    ): Flow<FirebaseResponse<String>> =
        flow {
            val createUser = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val user = createUser.user
            if (user != null) {
                emit(FirebaseResponse.Success(user.uid))
            } else {
                emit(FirebaseResponse.Empty)
            }
        }.catch {
            emit(FirebaseResponse.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO)

    // Login
    fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): Flow<FirebaseResponse<String>> =
        flow {
            val signInUser = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val user = signInUser.user
            if (user != null) {
                emit(FirebaseResponse.Success(user.uid))
            } else {
                emit(FirebaseResponse.Empty)
            }
        }.catch {
            emit(FirebaseResponse.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO)

    // Logout
    fun logout() = firebaseAuth.signOut()

    // Upload image
    fun uploadJobImage(
        jobId: String,
        imageURI: Uri,
    ): Flow<FirebaseResponse<String>> =
        flow {
            var isUploaded = false
            val reference = firebaseStorage.reference
                .child("picture")
                .child(jobId)

            reference.putFile(imageURI)
                .addOnSuccessListener {
                    isUploaded = true
                }

            if (isUploaded) {
                emit(FirebaseResponse.Success(imageURI.toString()))
            }
        }

    // Upload user image
    fun uploadUserAvatar(
        uid: String,
        imageURI: Uri,
    ): Flow<FirebaseResponse<String>> =
        flow {
            var isUploaded = false
            val reference = firebaseStorage.reference
                .child("picture")
                .child(uid)

            reference.putFile(imageURI)
                .addOnSuccessListener {
                    isUploaded = true
                }

            if (isUploaded) {
                emit(FirebaseResponse.Success(imageURI.toString()))
            }
        }
}