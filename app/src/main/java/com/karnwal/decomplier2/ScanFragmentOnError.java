package com.karnwal.decomplier2;

import androidx.annotation.NonNull;

import com.budiyev.android.codescanner.ErrorCallback;

public final class ScanFragmentOnError implements ErrorCallback {
    public final ScanFragment scanFragment;

    public ScanFragmentOnError(ScanFragment scanFragment) {
        this.scanFragment = scanFragment;
    }

    public final void onError(Exception exc) {
        ScanFragment.run(this.scanFragment, exc);
    }

    @Override
    public void onError(@NonNull Throwable thrown) {

    }
}
