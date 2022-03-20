package com.karnwal.decomplier2;

import androidx.annotation.NonNull;

import com.budiyev.android.codescanner.ErrorCallback;

public final /* synthetic */ class ScanFragment$$ExternalSyntheticLambda2 implements ErrorCallback {
    public final /* synthetic */ ScanFragment f$0;

    public /* synthetic */ ScanFragment$$ExternalSyntheticLambda2(ScanFragment scanFragment) {
        this.f$0 = scanFragment;
    }

    public final void onError(Exception exc) {
        ScanFragment.m249onCreateView$lambda4$lambda3(this.f$0, exc);
    }

    @Override
    public void onError(@NonNull Throwable thrown) {

    }
}
