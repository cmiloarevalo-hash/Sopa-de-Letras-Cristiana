package app.sopadeletras.sync

import android.app.Activity
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential

/**
 * Google's native account chooser. It is not launched until a valid OAuth
 * web client ID has been configured for THIS app and the player taps Sign in.
 *
 * An ID token verifies identity; it MUST NOT be sent to the Drive REST API.
 * Drive requires a separate user-granted access token, see AuthorizationClient.
 */
class GoogleAccountChooser(private val activity: Activity) {
    private val credentials = CredentialManager.create(activity)

    suspend fun choose(webClientId: String): String {
        require(webClientId.endsWith(".apps.googleusercontent.com")) {
            "La configuración de Google todavía no está disponible"
        }
        val option = GetSignInWithGoogleOption.Builder(webClientId).build()
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(option).build()
        val selected = credentials.getCredential(
            context = activity,
            request = request,
        ).credential
        require(
            selected is CustomCredential &&
                selected.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL,
        ) { "No se recibió una cuenta de Google válida" }
        // Stable unique account identifier, not email; do not upload this ID.
        return GoogleIdTokenCredential.createFrom(selected.data).uniqueId
    }

    suspend fun clear() {
        credentials.clearCredentialState(ClearCredentialStateRequest())
    }
}
