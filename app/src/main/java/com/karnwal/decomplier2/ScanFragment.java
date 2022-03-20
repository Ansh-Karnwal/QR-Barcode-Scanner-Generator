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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/karnwal/qrcode2/ScanFragment;", "Landroidx/fragment/app/Fragment;", "()V", "codeScanner", "Lcom/budiyev/android/codescanner/CodeScanner;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onResume", "app_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
            this.codeScanner = new CodeScanner(activity2, (CodeScannerView) scanner_view);
            this.codeScanner.setCamera(-1);
            this.codeScanner.setFormats(CodeScanner.ALL_FORMATS);
            this.codeScanner.setAutoFocusMode(AutoFocusMode.SAFE);
            this.codeScanner.setScanMode(ScanMode.CONTINUOUS);
            this.codeScanner.setAutoFocusEnabled(true);
            this.codeScanner.setFlashEnabled(false);
            this.codeScanner.setDecodeCallback(new ScanFragment$$ExternalSyntheticLambda1(this, textView));
            this.codeScanner.setErrorCallback(new ScanFragment$$ExternalSyntheticLambda2(this));
            scanner_view.setOnClickListener(new ScanFragment$$ExternalSyntheticLambda0(this));
        }
        return inflate;
    }

    public static final void m247onCreateView$lambda4$lambda1(ScanFragment scanFragment, TextView textView, Result result) {
        Intrinsics.checkNotNullParameter(scanFragment, "this$0");
        Intrinsics.checkNotNullParameter(result, "it");
        FragmentActivity activity = scanFragment.getActivity();
        Intrinsics.checkNotNull(activity);
        activity.runOnUiThread(new ScanFragment$$ExternalSyntheticLambda3(textView, result));
    }

    public static final void m248onCreateView$lambda4$lambda1$lambda0(TextView textView, Result result) {
        Intrinsics.checkNotNullParameter(result, "$it");
        textView.setText(result.getText());
    }

    public static final void m249onCreateView$lambda4$lambda3(ScanFragment scanFragment, Exception exc) {
        Intrinsics.checkNotNullParameter(scanFragment, "this$0");
        Intrinsics.checkNotNullParameter(exc, "it");
        FragmentActivity activity = scanFragment.getActivity();
        Intrinsics.checkNotNull(activity);
        activity.runOnUiThread(new ScanFragment$$ExternalSyntheticLambda4(exc));
    }

    public static final void m250onCreateView$lambda4$lambda3$lambda2(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "$it");
        Log.e("Main", Intrinsics.stringPlus("Camera initialization error: ", exc.getMessage()));
    }

    public static final void m251onCreateView$lambda5(ScanFragment scanFragment, View view) {
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
