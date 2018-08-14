package com.soa4id.tec.shareactionsender;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.util.Log;

import java.util.concurrent.ExecutionException;

import static java.security.AccessController.getContext;

public class DataBaseAssistant {
    private String mDataBaseName;
    private SQLiteDatabase mDb;
    private String mTableName;
    private Context mContext;
    private static final String KEY_IMAGE_DATA = "image_data";
    private static final String KEY_RECORD_ID = "record_id";

    /**
     *
     */
    public DataBaseAssistant(Context context) {
        this.mDataBaseName = "soadb";
        this.mTableName = "soaimages";
        this.mContext = context;
        this.initializeDataBase();
    }


    /**
     *
     *
     */
    public void initializeDataBase (){
        try{
            this.mDb = this.mContext.openOrCreateDatabase(this.mDataBaseName,Context.MODE_PRIVATE,null);
            String init_table_query = "CREATE TABLE IF NOT EXISTS " + this.mTableName + " (" +
                    KEY_RECORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_IMAGE_DATA +  " BLOB )";
            mDb.execSQL(init_table_query);
            Log.i("soasql", this.mDb.getPath());
        }catch (SQLException e){
            Log.i("soasql", e.getMessage());
        }

    }

    /**
     *
     * @param image
     */
    public void addImageToDB (Bitmap image){
        byte[] imageByteArray = SOAUtils.bitmapToByte(image);
        ContentValues value = new ContentValues();
        value.put(DataBaseAssistant.KEY_IMAGE_DATA,imageByteArray);
        try {
            //this.mDb.insertOrThrow(this.mTableName,null,value);
            this.mDb.insert(this.mTableName,null,value);
        }catch (SQLException e){
            Log.d("soa.sql", e.toString());
        }
    }

    /**
     *
     */
    public void deleteAll (){
        try {
            this.mDb.delete(this.mTableName,null,null);
        }catch (SQLException e) {
            Log.d("soa.sql", e.toString());
        }
    }

    /**
     *
     * @return
     */
    public Cursor getAll () {
        try {
            String sql_query = "SELECT * FROM "+ this.mTableName;
            Cursor cursor = this.mDb.rawQuery(sql_query,null);
            if (cursor == null){
                Log.d("soa.sql", "Cursor is null");
                return  null;
            }
            return  cursor;
        }catch (SQLException e) {
            Log.d("soa.sql", e.toString());
        }
        return null;
    }
}
