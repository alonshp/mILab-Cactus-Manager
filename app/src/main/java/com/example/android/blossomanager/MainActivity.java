package com.example.android.blossomanager;

import android.app.LoaderManager;
import android.content.Loader;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private static final String LOG_TAG = MainActivity.class.getName();

    private String BlynkAuth = "14f620c6c7ac472e82f44bba939e5789";

    private String angle;

    private boolean createLoader = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button angle0 = (Button) findViewById(R.id.angle0);
        Button angle30 = (Button) findViewById(R.id.angle30);
        Button angle50 = (Button) findViewById(R.id.angle50);
        Button angle70 = (Button) findViewById(R.id.angle70);
        Button resetDB = (Button) findViewById(R.id.resetDB);

        final LoaderManager loaderManager = getLoaderManager();

        angle0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle = "0";
                loaderManager.restartLoader(1, null, MainActivity.this);
            }
        });

        angle30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle = "30";
                loaderManager.restartLoader(1, null, MainActivity.this);
            }
        });

        angle50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle = "50";
                loaderManager.restartLoader(1, null, MainActivity.this);
            }
        });

        angle70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle = "70";
                loaderManager.restartLoader(1, null, MainActivity.this);
            }
        });

        resetDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        createLoader = true;
        Uri baseUri = Uri.parse("http://blynk-cloud.com/" + BlynkAuth + "/update/V0?value=" + angle);
        Uri.Builder uriBuilder = baseUri.buildUpon();
        return new BlossomLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        if (createLoader = true){
            createLoader = false;
            Log.e(LOG_TAG, "loader finished");
        }
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
