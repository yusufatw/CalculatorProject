package id.cathode.androidactivitylogtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: method is running");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: method is running");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: method is running");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: method is running");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: is running");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: is running");
    }
}
