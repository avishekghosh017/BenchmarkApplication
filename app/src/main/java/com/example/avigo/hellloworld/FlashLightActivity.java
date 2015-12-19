package com.example.avigo.hellloworld;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;

public class FlashLightActivity extends AppCompatActivity {

    private Camera camera;
    private ToggleButton button;
    private final Context context = this;

    @Override
    protected void onStop() {
        super.onStop();
        if (camera != null) {
            camera.release();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);
        button = (ToggleButton) findViewById(R.id.togglebutton);

        final PackageManager pm = context.getPackageManager();
        if(!isCameraSupported(pm)){
            AlertDialog alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("No Camera");
            alertDialog.setMessage("The device's doesn't support camera.");
            alertDialog.setButton(RESULT_OK, "OK", new DialogInterface.OnClickListener() {
                public void onClick(final DialogInterface dialog, final int which) {
                    Log.e("err", "The device's doesn't support camera.");
                }
            });
            alertDialog.show();
        }
        camera = Camera.open();
    }
    public void onToggleClicked(View view) {
        PackageManager pm=context.getPackageManager();
        final Camera.Parameters p = camera.getParameters();
        if(isFlashSupported(pm)){
            boolean on = ((ToggleButton) view).isChecked();
            if (on) {
                Log.i("info", "torch is turn on!");
                p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(p);
                camera.startPreview();
            } else {
                Log.i("info", "torch is turn off!");
                p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(p);
                camera.stopPreview();
            }
        }else{
            button.setChecked(false);
            AlertDialog alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("No Camera Flash");
            alertDialog.setMessage("The device's camera doesn't support flash.");
            alertDialog.setButton(RESULT_OK, "OK", new DialogInterface.OnClickListener() {
                public void onClick(final DialogInterface dialog, final int which) {
                    Log.e("err", "The device's camera doesn't support flash.");
                }
            });
            alertDialog.show();
        }
    }

    private boolean isFlashSupported(PackageManager packageManager){
        // if device support camera flash?
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            return true;
        }
        return false;
    }

    private boolean isCameraSupported(PackageManager packageManager){
        // if device support camera?
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        }
        return false;
    }
}
