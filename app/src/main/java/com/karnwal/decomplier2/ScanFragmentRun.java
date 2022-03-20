package com.karnwal.decomplier2;

import android.widget.TextView;
import com.google.zxing.Result;

public final class ScanFragmentRun implements Runnable {
    public final TextView f$0;
    public final Result f$1;

    public ScanFragmentRun(TextView textView, Result result) {
        this.f$0 = textView;
        this.f$1 = result;
    }

    public final void run() {
        ScanFragment.addText(this.f$0, this.f$1);
    }
}
