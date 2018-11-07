package br.com.steventos.security;

import java.io.IOException;
import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

public class FirebaseAdminSDK {

	private static final String STEVENTOS_FIREBASE_ADMINSDK_JSON = "steventos-firebase-adminsdk.json";

	public FirebaseAdminSDK() throws IOException {
		InputStream serviceAccount = this.getClass().getClassLoader()
				.getResourceAsStream(STEVENTOS_FIREBASE_ADMINSDK_JSON);

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://steventos-30d2c.firebaseio.com").build();

		FirebaseApp.initializeApp(options);
	}

	public String validToken(String token) throws FirebaseAuthException {
		FirebaseToken idToken = FirebaseAuth.getInstance().verifyIdToken(token);
		return idToken.getEmail();
	}
}
