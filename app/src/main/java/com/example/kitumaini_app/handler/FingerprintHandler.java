package com.example.kitumaini_app.handler;

import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.kitumaini_app.R;

public class FingerprintHandler extends FingerprintManager.AuthenticationCallback{

    private Context context;

    public FingerprintHandler(Context context) {
        this.context = context;
    }

    public void startAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject){

        CancellationSignal cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {

        this.update("There was an Auth Error. " + errString, false);
    }

    @Override
    public void onAuthenticationFailed() {

        this.update("Auth failed", false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {

        this.update("Error: " + helpString, false);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {

        this.update("You can now access the app", true);
    }

    private void update(String s, boolean b) {

        TextView paraLabel = (TextView) ((Activity)context).findViewById(R.id.finger_title);
        ImageView imageView = (ImageView) ((Activity)context).findViewById(R.id.img_fingerprint);

        paraLabel.setText(s);

        if (b == false){
             paraLabel.setTextColor(ContextCompat.getColor(context, R.color.colorRed));
        }else {
            paraLabel.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
            imageView.setImageResource(R.drawable.ic_baseline_fingerprint_actif);
        }
    }
}
