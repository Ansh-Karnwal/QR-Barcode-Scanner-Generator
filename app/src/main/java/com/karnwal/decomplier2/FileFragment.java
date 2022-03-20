package com.karnwal.decomplier2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public final class FileFragment extends Fragment {
    private Button fileButton;
    private TextView formattedText;
    private TextView rawText;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_file, viewGroup, false);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        this.fileButton = inflate.findViewById(R.id.fileButton);
        View findViewById2 = inflate.findViewById(R.id.rawText);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.rawText)");
        this.rawText = inflate.findViewById(R.id.rawText);
        View findViewById3 = inflate.findViewById(R.id.formattedText);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.formattedText)");
        this.formattedText = (TextView) findViewById3;
        this.fileButton.setOnClickListener(new FileFragmentButtonListener(this, intent));
        startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
        return inflate;
    }

    public static final void fileButtonListener(FileFragment fileFragment, Intent intent, View view) {
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        fileFragment.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        TextView textView = this.formattedText;
        Uri uri = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formattedText");
            textView = null;
        }
        textView.setText("");
        if (i == 111 && i2 == -1) {
            if (intent != null) {
                uri = intent.getData();
            }
            Intrinsics.checkNotNullExpressionValue(new BarcodeScannerOptions.Builder().setBarcodeFormats(0, new int[0]).build(), "Builder()\n              …\n                .build()");
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            Intrinsics.checkNotNull(uri);
            InputImage fromFilePath = null;
            try {
                fromFilePath = InputImage.fromFilePath(activity, uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Intrinsics.checkNotNullExpressionValue(fromFilePath, "fromFilePath(activity!!, selected_file!!)");
            BarcodeScanner client = BarcodeScanning.getClient();
            Intrinsics.checkNotNullExpressionValue(client, "getClient()");
            Intrinsics.checkNotNullExpressionValue(client.process(fromFilePath).addOnSuccessListener(new FileFragmentOnSuccessListener(this)).addOnFailureListener(new FileFragmentOnFailureListener(this)), "scanner.process(image)\n ….show()\n                }");
        }
    }

    public static final void decodeFile(FileFragment fileFragment, List list) {
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Barcode barcode = (Barcode) it.next();
            barcode.getBoundingBox();
            barcode.getCornerPoints();
            String rawValue = barcode.getRawValue();
            TextView textView = fileFragment.rawText;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rawText");
                textView = null;
            }
            textView.setText(rawValue);
            if (barcode.getValueType() == 9) {
                Barcode.WiFi wifi = barcode.getWifi();
                Intrinsics.checkNotNull(wifi);
                String ssid = wifi.getSsid();
                Barcode.WiFi wifi2 = barcode.getWifi();
                Intrinsics.checkNotNull(wifi2);
                String password = wifi2.getPassword();
                Barcode.WiFi wifi3 = barcode.getWifi();
                Intrinsics.checkNotNull(wifi3);
                int encryptionType = wifi3.getEncryptionType();
                TextView textView3 = fileFragment.formattedText;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("formattedText");
                } else {
                    textView2 = textView3;
                }
                textView2.setText("SSID: " + ssid + "\nPassword: " + password + "\nType: " + encryptionType);
            }
        }
    }

    public static final void resultOfFile(FileFragment fileFragment, Exception exc) {
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        Intrinsics.checkNotNullParameter(exc, "it");
        FragmentActivity activity = fileFragment.getActivity();
        Intrinsics.checkNotNull(activity);
        Toast.makeText(activity, "Scanning Failed", Toast.LENGTH_SHORT).show();
    }
}
