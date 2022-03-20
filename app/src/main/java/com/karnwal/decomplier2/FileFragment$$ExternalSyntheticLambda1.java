package com.karnwal.decomplier2;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class FileFragment$$ExternalSyntheticLambda1 implements OnFailureListener {
    public final /* synthetic */ FileFragment f$0;

    public /* synthetic */ FileFragment$$ExternalSyntheticLambda1(FileFragment fileFragment) {
        this.f$0 = fileFragment;
    }

    public final void onFailure(Exception exc) {
        FileFragment.m243onActivityResult$lambda2(this.f$0, exc);
    }
}
