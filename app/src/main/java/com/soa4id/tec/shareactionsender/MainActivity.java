package com.soa4id.tec.shareactionsender;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private ImageButton mDelete;
    private ImageButton mSearch;

    private DataBaseAssistant mDataBaseAssistant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        this.mDataBaseAssistant = new DataBaseAssistant(getApplicationContext());

        setContentView(R.layout.activity_main);
        mCoordinatorLayout = findViewById(R.id.main_activity_coordinator_view);
        mImageButtonCamera = findViewById(R.id.main_activity_camera);
        mImageButtonChip = findViewById(R.id.main_activity_chip);
        mImageButtonMicrophone = findViewById(R.id.main_activity_microphone);
        mImageButtonSatellite = findViewById(R.id.main_activity_satellite);
        mDelete = findViewById(R.id.main_activity_delete);
        mSearch= findViewById(R.id.main_activity_search);

        mImageButtonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_camera, null);
                mDataBaseAssistant.addImageToDB(bitmap);
                snackMessage("Camera is saved on DATA BASE");
            }
        });
        mImageButtonChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_chip, null);
                mDataBaseAssistant.addImageToDB(bitmap);
                snackMessage("Chip is saved on DATA BASE");
            }
        });
        mImageButtonSatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_satellite, null);
                mDataBaseAssistant.addImageToDB(bitmap);
                snackMessage("Satellite is saved on DATA BASE");
            }
        });
        mImageButtonMicrophone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_microphone, null);
                mDataBaseAssistant.addImageToDB(bitmap);
                snackMessage("Microphone is saved on DATA BASE");
            }
        });

        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataBaseAssistant.deleteAll();
                snackMessage("Deleting data");
            }
        });
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = mDataBaseAssistant.getAll();
                snackMessage(" Cursor count: " +Integer.toString(cursor.getCount()));
            }
        });

    }

    public  void snackMessage (String msg){
        Snackbar snackbar =Snackbar.make(this.mCoordinatorLayout, msg, Snackbar.LENGTH_SHORT);
        snackbar.show();

    }




}
