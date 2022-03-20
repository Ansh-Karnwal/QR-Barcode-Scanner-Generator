package com.karnwal.decomplier2;

import android.widget.TextView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public final class ScanFragmentOnDecodeListener implements DecodeCallback {
    public final ScanFragment scanFragment;
    public final TextView textView;

    public ScanFragmentOnDecodeListener(ScanFragment scanFragment, TextView textView) {
        this.scanFragment = scanFragment;
        this.textView = textView;
    }

    public final void onDecoded(Result result) {
        ScanFragment.runScan(this.scanFragment, this.textView, result);
    }
}
