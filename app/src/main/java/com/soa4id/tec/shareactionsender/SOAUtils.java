package com.soa4id.tec.shareactionsender;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;


public class SOAUtils {
    /** Creates a byte array from a image, the bit map must be a png file **/
    public byte[] bitmapToByte(Bitmap bitmap){
        try{
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
            byte[] ouputByteArray = stream.toByteArray();
            return  ouputByteArray;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /** Returns the bitmap related to some imageDate in byte[] format **/
    public Bitmap getBitMap (byte[] imageData){
        return BitmapFactory.decodeByteArray(imageData,0,imageData.length);
    }

}
