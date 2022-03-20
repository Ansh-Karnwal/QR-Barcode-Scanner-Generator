package com.karnwal.decomplier2;

import android.widget.TextView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public final /* synthetic */ class ScanFragment$$ExternalSyntheticLambda1 implements DecodeCallback {
    public final /* synthetic */ ScanFragment f$0;
    public final /* synthetic */ TextView f$1;

    public /* synthetic */ ScanFragment$$ExternalSyntheticLambda1(ScanFragment scanFragment, TextView textView) {
        this.f$0 = scanFragment;
        this.f$1 = textView;
    }

    public final void onDecoded(Result result) {
        ScanFragment.m247onCreateView$lambda4$lambda1(this.f$0, this.f$1, result);
    }
}
