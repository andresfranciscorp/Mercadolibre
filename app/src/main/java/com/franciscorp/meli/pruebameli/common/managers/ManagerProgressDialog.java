package com.franciscorp.meli.pruebameli.common.managers;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.franciscorp.meli.pruebameli.R;

public class ManagerProgressDialog {
    private String TAG = ManagerProgressDialog.class.getSimpleName();

    private Context context;
    private ProgressDialog progress;

    public ManagerProgressDialog(Context context) {
        try {
            this.context = context;
            progress = new ProgressDialog(context);
            progress.setMessage(context.getString(R.string.loading));
            progress.setCancelable(false);
        } catch (Exception e) {
            if (e != null && !TextUtils.isEmpty(e.getLocalizedMessage())) {
                Log.e(TAG, e.getLocalizedMessage());
            }
        }
    }

    public synchronized void showProgress() {
        showProgress(null);
    }

    public synchronized void showProgress(String message) {
        if (message != null && progress != null) {
            progress.setMessage(message);
        }
        try {
            progress.show();
        } catch (Exception e) {
            if (e != null && !TextUtils.isEmpty(e.getLocalizedMessage())) {
                Log.e(TAG, e.getLocalizedMessage());
            }
        }
    }

    public synchronized void dismissProgress() {
        if (progress != null && progress.isShowing()) {
            try {
                progress.dismiss();
            } catch (Exception e) {
                if (e != null && !TextUtils.isEmpty(e.getLocalizedMessage())) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
            }
        }
    }
}
