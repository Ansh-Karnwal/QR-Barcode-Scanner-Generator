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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/karnwal/qrcode2/FileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "fileButton", "Landroid/widget/Button;", "formattedText", "Landroid/widget/TextView;", "rawText", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        this.rawText = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.formattedText);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.formattedText)");
        this.formattedText = (TextView) findViewById3;
        this.fileButton.setOnClickListener(new FileFragment$$ExternalSyntheticLambda0(this, intent));
        startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
        return inflate;
    }

    public static final void m244onCreateView$lambda0(FileFragment fileFragment, Intent intent, View view) {
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
            Intrinsics.checkNotNullExpressionValue(client.process(fromFilePath).addOnSuccessListener(new FileFragment$$ExternalSyntheticLambda2(this)).addOnFailureListener(new FileFragment$$ExternalSyntheticLambda1(this)), "scanner.process(image)\n ….show()\n                }");
        }
    }

    public static final void m242onActivityResult$lambda1(FileFragment fileFragment, List list) {
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

    public static final void m243onActivityResult$lambda2(FileFragment fileFragment, Exception exc) {
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        Intrinsics.checkNotNullParameter(exc, "it");
        FragmentActivity activity = fileFragment.getActivity();
        Intrinsics.checkNotNull(activity);
        Toast.makeText(activity, "Scanning Failed", Toast.LENGTH_SHORT).show();
    }
}
