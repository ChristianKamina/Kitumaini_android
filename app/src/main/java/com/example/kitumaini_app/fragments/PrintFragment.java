package com.example.kitumaini_app.fragments;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kitumaini_app.R;
import com.example.kitumaini_app.handler.FingerprintHandler;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;

import javax.crypto.KeyGenerator;

public class PrintFragment extends Fragment {

    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;

    ImageView image_fingerprint;
    TextView finger_title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_print, container, false);

        image_fingerprint = view.findViewById(R.id.img_fingerprint);
        finger_title = view.findViewById(R.id.finger_title);

            fingerprintManager = (FingerprintManager) getContext().getSystemService(Context.FINGERPRINT_SERVICE);
            keyguardManager = (KeyguardManager) getContext().getSystemService(Context.KEYGUARD_SERVICE);

            if (!fingerprintManager.isHardwareDetected()){
                finger_title.setText("Fingerprint Scanner not detect in Device");

            }else if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.USE_FINGERPRINT) !=
                    PackageManager.PERMISSION_GRANTED){
                finger_title.setText("Permission not granted to use Fingerprint Scanner");

            }else if (!keyguardManager.isKeyguardSecure()){
                finger_title.setText("Add Look to your Phone in Settings");

            }else if (!fingerprintManager.hasEnrolledFingerprints()){
                finger_title.setText("You should add atleast 1 Fingerprint to use this Feature");

            }else {
                finger_title.setText("Place your Finger on Scanner to Access the App");

                FingerprintHandler fingerprintHandler = new FingerprintHandler(getContext());
                fingerprintHandler.startAuth(fingerprintManager, null);
            }

        return view;
    }
}