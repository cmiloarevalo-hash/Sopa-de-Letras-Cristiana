package app.sopadeletras.sync

import android.app.Activity
import com.google.android.gms.auth.api.identity.AuthorizationRequest
import com.google.android.gms.auth.api.identity.AuthorizationResult
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.common.api.Scope
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * A Google ID token from Credential Manager is NOT a Drive access token.
 * This requests only drive.appdata when the player opts into account backup.
 *
 * If result.hasResolution() the UI MUST display result.pendingIntent using
 * Android's Activity Result API and complete authorization. Do not upload
 * anything until the returned AuthorizationResult has a real accessToken.
 */
class GoogleDriveAuthorization(private val activity: Activity) {
    suspend fun request(): AuthorizationResult = suspendCancellableCoroutine { continuation ->
        val request = AuthorizationRequest.builder()
            .setRequestedScopes(listOf(Scope(DriveAppDataClient.SCOPE)))
            .build()
        Identity.getAuthorizationClient(activity)
            .authorize(request)
            .addOnSuccessListener { result ->
                if (continuation.isActive) continuation.resume(result)
            }
            .addOnFailureListener { error ->
                if (continuation.isActive) continuation.resumeWithException(error)
            }
    }
}
