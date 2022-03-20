package com.karnwal.decomplier2;

import android.view.View;

public final class ScanFragmentScannerViewListener implements View.OnClickListener {
    public final ScanFragment scanFragment;

    public ScanFragmentScannerViewListener(ScanFragment scanFragment) {
        this.scanFragment = scanFragment;
    }

    public final void onClick(View view) {
        ScanFragment.scanFragmentListener(this.scanFragment, view);
    }
}
