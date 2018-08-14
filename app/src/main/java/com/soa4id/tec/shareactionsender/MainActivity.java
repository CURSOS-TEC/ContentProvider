package com.soa4id.tec.shareactionsender;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout mCoordinatorLayout;
    private ImageButton mImageButtonCamera;
    private ImageButton mImageButtonChip;
    private ImageButton mImageButtonMicrophone;
    private ImageButton mImageButtonSatellite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCoordinatorLayout = findViewById(R.id.main_activity_coordinator_view);
        mImageButtonCamera = findViewById(R.id.main_activity_camera);
        mImageButtonChip = findViewById(R.id.main_activity_chip);
        mImageButtonMicrophone = findViewById(R.id.main_activity_microphone);
        mImageButtonSatellite = findViewById(R.id.main_activity_satellite);

        mImageButtonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackMessage("Camera is sending to content provider");
            }
        });
        mImageButtonChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackMessage("Chip is sending to content provider");
            }
        });
        mImageButtonSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackMessage("Satellite is sending to content provider");
            }
        });
        mImageButtonMicrophone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackMessage("Microphone is sending to content provider");
            }
        });

    }

    public  void snackMessage (String msg){
        Snackbar snackbar =Snackbar.make(this.mCoordinatorLayout, msg, Snackbar.LENGTH_SHORT);
        snackbar.show();

    }




}
