package com.puyo.kapas.feature_kapas.data.source.remote.firebase

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage

class FirebaseService {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseStorage: FirebaseStorage = FirebaseStorage.getInstance()

    // Check logged in status
    fun isLoggedIn(): Boolean = firebaseAuth.currentUser != null

    // Get User
    fun getCurrentUserId() = firebaseAuth.currentUser?.uid

    // Register
    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
    ) = firebaseAuth.createUserWithEmailAndPassword(email, password)

    // Login
    fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ) = firebaseAuth.signInWithEmailAndPassword(email, password)

    // Logout
    fun logout() = firebaseAuth.signOut()

    // Upload image
    fun uploadJobImage(
        jobId: String,
        imageURI: Uri,
    ): String {
        var isUploaded = false
        val reference = firebaseStorage.reference
            .child("picture")
            .child(jobId)

        reference.putFile(imageURI).addOnSuccessListener {
            isUploaded = true
        }

        return if (isUploaded)
            imageURI.toString()
        else ""
    }

    // Upload user image
    fun uploadUserAvatar(
        uid: String,
        imageURI: Uri,
    ): String {
        var isUploaded = false
        val reference = firebaseStorage.reference
            .child("picture")
            .child(uid)

        reference.putFile(imageURI)
            .addOnSuccessListener {
                isUploaded = true
            }

        return if (isUploaded)
            imageURI.toString()
        else ""
    }
}