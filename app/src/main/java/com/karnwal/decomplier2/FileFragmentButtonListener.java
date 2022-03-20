package com.karnwal.decomplier2;

import android.content.Intent;
import android.view.View;

public final class FileFragmentButtonListener implements View.OnClickListener {
    public final FileFragment fileFragment;
    public final Intent intent;

    public FileFragmentButtonListener(FileFragment fileFragment, Intent intent) {
        this.fileFragment = fileFragment;
        this.intent = intent;
    }

    public final void onClick(View view) {
        FileFragment.fileButtonListener(this.fileFragment, this.intent, view);
    }
}
