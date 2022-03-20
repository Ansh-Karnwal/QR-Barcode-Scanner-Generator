package com.karnwal.decomplier2;

public final class ScanFragmentException implements Runnable {
    public final Exception exception;

    public ScanFragmentException(Exception exc) {
        this.exception = exc;
    }

    public final void run() {
        ScanFragment.getException(this.exception);
    }
}
