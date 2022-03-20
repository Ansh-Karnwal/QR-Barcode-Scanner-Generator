package com.karnwal.decomplier2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.budiyev.android.codescanner.AutoFocusMode;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.ScanMode;
import com.fondesa.kpermissions.extension.PermissionsBuilderKt;
import com.google.zxing.Result;

import kotlin.jvm.internal.Intrinsics;

public final class ScanFragment extends Fragment {
    private CodeScanner codeScanner;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_scan, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_textView);
        PermissionsBuilderKt.permissionsBuilder((Fragment) this, "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA").build().send();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        View scanner_view = inflate.findViewById(R.id.scanner_view);
        if (ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA") == 0) {
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2);
            this.codeScanner = new CodeScanner(getContext(), (CodeScannerView) scanner_view);
            this.codeScanner.setCamera(-1);
            this.codeScanner.setFormats(CodeScanner.ALL_FORMATS);
            this.codeScanner.setAutoFocusMode(AutoFocusMode.SAFE);
            this.codeScanner.setScanMode(ScanMode.CONTINUOUS);
            this.codeScanner.setAutoFocusEnabled(true);
            this.codeScanner.setFlashEnabled(false);
            this.codeScanner.setDecodeCallback(new ScanFragmentOnDecodeListener(this, textView));
            this.codeScanner.setErrorCallback(new ScanFragmentOnError(this));
            scanner_view.setOnClickListener(new ScanFragmentScannerViewListener(this));
        }
        return inflate;
    }

    public static final void runScan(ScanFragment scanFragment, TextView textView, Result result) {
        Intrinsics.checkNotNullParameter(scanFragment, "this$0");
        Intrinsics.checkNotNullParameter(result, "it");
        FragmentActivity activity = scanFragment.getActivity();
        Intrinsics.checkNotNull(activity);
        activity.runOnUiThread(new ScanFragmentRun(textView, result));
    }

    public static final void addText(TextView textView, Result result) {
        Intrinsics.checkNotNullParameter(result, "$it");
        textView.setText(result.getText());
    }

    public static final void run(ScanFragment scanFragment, Exception exc) {
        Intrinsics.checkNotNullParameter(scanFragment, "this$0");
        Intrinsics.checkNotNullParameter(exc, "it");
        FragmentActivity activity = scanFragment.getActivity();
        Intrinsics.checkNotNull(activity);
        activity.runOnUiThread(new ScanFragmentException(exc));
    }

    public static final void getException(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "$it");
        Log.e("Main", Intrinsics.stringPlus("Camera initialization error: ", exc.getMessage()));
    }

    public static final void scanFragmentListener(ScanFragment scanFragment, View view) {
        Intrinsics.checkNotNullParameter(scanFragment, "this$0");
        CodeScanner codeScanner2 = scanFragment.codeScanner;
        if (codeScanner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeScanner");
            codeScanner2 = null;
        }
        codeScanner2.startPreview();
    }

    public void onResume() {
        super.onResume();
        CodeScanner codeScanner2 = this.codeScanner;
        if (codeScanner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeScanner");
            codeScanner2 = null;
        }
        codeScanner2.startPreview();
    }

    public void onPause() {
        CodeScanner codeScanner2 = this.codeScanner;
        if (codeScanner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("codeScanner");
            codeScanner2 = null;
        }
        codeScanner2.releaseResources();
        super.onPause();
    }
}
