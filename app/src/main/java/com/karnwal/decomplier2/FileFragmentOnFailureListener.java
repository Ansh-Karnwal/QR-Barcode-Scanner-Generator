package com.karnwal.decomplier2;

import com.google.android.gms.tasks.OnFailureListener;

public final class FileFragmentOnFailureListener implements OnFailureListener {
    public final FileFragment fileFragment;

    public FileFragmentOnFailureListener(FileFragment fileFragment) {
        this.fileFragment = fileFragment;
    }

    public final void onFailure(Exception exc) {
        FileFragment.resultOfFile(this.fileFragment, exc);
    }
}
