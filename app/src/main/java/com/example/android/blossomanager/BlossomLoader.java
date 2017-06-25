package com.example.android.blossomanager;

import android.content.AsyncTaskLoader;
import android.content.Context;

/**
 * Created by Alon on 25/06/2017.
 */

public class BlossomLoader extends AsyncTaskLoader<String> {
    /** Tag for log messages */
    private static final String LOG_TAG = BlossomLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public BlossomLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        String res = Utils.moveCactus(mUrl);
        return res;
    }
}
