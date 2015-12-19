package com.example.avigo.hellloworld;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageProcesActivity extends AppCompatActivity {

    private ImageView ivDefault;
    private static final int CAMERA_IMAGE = 123;
    private ImageView ivResult;
    private Uri fileUri;

    public void getImageFromCamera(View view){
        startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), CAMERA_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.i("bitsnsweets","in side onActivityResult");
        super.onActivityResult(requestCode, resultCode, intent);
        Uri uri = intent.getData();
        Log.i("bitsnsweets", ""+uri.toString());
        ivResult.setImageURI(uri);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageprocess_layout);
        ivDefault = (ImageView)findViewById(R.id.ivDefault);
    }

    @Override
    protected void onStart() {
        super.onStart();
        try{

            Intent incomingIntent = getIntent();
            Uri imageUri=(Uri) incomingIntent.getExtras().get(Intent.EXTRA_STREAM);
            ivDefault.setImageURI(imageUri);
        }catch(Exception e){
            Log.i("log  i inside try catch"," enteering");
        }
    }

    public void imageEffects(View view){
        switch (view.getId()){
            case R.id.btnGreyscale:
                ivDefault.buildDrawingCache();
                Bitmap bitmapOriginal= ivDefault.getDrawingCache();
                Bitmap bitmapGreyscale = toGreyscale(bitmapOriginal);
                ivDefault.setImageBitmap(bitmapGreyscale);
                break;
            case R.id.btnInvert:
                ivDefault.buildDrawingCache();
                Bitmap bitmapOriginal1= ivDefault.getDrawingCache();
                Bitmap bitmapInvert = toInvert(bitmapOriginal1);
                ivDefault.setImageBitmap(bitmapInvert);
                break;
            case R.id.btnSepia: ivDefault.buildDrawingCache();
                Bitmap bitmapOriginal2= ivDefault.getDrawingCache();
                Bitmap bitmapSepia = toSepia(bitmapOriginal2);
                ivDefault.setImageBitmap(bitmapSepia);
                break;
        }
    }

    private Bitmap toSepia(Bitmap bitmapOriginal2) {
        int width, height;
        height = bitmapOriginal2.getHeight();
        width = bitmapOriginal2.getWidth();
        Bitmap bmpSepia = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpSepia);
        Paint paint = new Paint();
        ColorMatrix cm1 = new ColorMatrix();
        ColorMatrix cm2 = new ColorMatrix();
        cm2.setScale(1f, .90f, .80f, 1.0f);
        cm1.setSaturation(20);
        cm1.setConcat(cm2,cm1);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm1);
        paint.setColorFilter(f);
        c.drawBitmap(bitmapOriginal2, 0, 0, paint);
        return bmpSepia;
    }

    private Bitmap toInvert(Bitmap bitmapOriginal1) {
        Bitmap bmOut = Bitmap.createBitmap(bitmapOriginal1.getWidth(), bitmapOriginal1.getHeight(), bitmapOriginal1.getConfig());
        // color info
        int A, R, G, B;
        int pixelColor;
        // image size
        int height = bitmapOriginal1.getHeight();
        int width = bitmapOriginal1.getWidth();

        // scan through every pixel
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                // get one pixel
                pixelColor = bitmapOriginal1.getPixel(x, y);
                // saving alpha channel
                A = Color.alpha(pixelColor);
                // inverting byte for each R/G/B channel
                R = 255 - Color.red(pixelColor);
                G = 255 - Color.green(pixelColor);
                B = 255 - Color.blue(pixelColor);
                // set newly-inverted pixel to output image
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        // return final bitmap
        return bmOut;
    }

    public Bitmap toGreyscale(Bitmap bitmapOriginal) {
        int width, height;
        height = bitmapOriginal.getHeight();
        width = bitmapOriginal.getWidth();
        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bitmapOriginal, 0, 0, paint);
        return bmpGrayscale;
    }
}
