package com.karnwal.decomplier2;

import android.widget.TextView;
import com.google.zxing.Result;

public final class ScanFragmentRun implements Runnable {
    public final TextView textView;
    public final Result result;

    public ScanFragmentRun(TextView textView, Result result) {
        this.textView = textView;
        this.result = result;
    }

    public final void run() {
        ScanFragment.addText(this.textView, this.result);
    }
}
