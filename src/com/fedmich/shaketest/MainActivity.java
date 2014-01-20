package com.fedmich.shaketest;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.fedmich.shaketest.ShakeDetectActivity;
import com.fedmich.shaketest.ShakeDetectActivityListener;

public class MainActivity extends Activity {

	ShakeDetectActivity shakeDetectActivity;
	
	private int num = 0;
	private TextView txtShake;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.d("Fed", "onCreate");
        txtShake = (TextView) findViewById(R.id.txtShake);
        
        shakeDetectActivity = new ShakeDetectActivity(this);
        shakeDetectActivity.addListener(
        new ShakeDetectActivityListener() {
            @Override
            public void shakeDetected() {
                MainActivity.this.handleShakeEvent();
            }
        });
        
    }
    
    void handleShakeEvent( ){
    	Log.d("Fed", "handShake");
    	
    	num += 1;
    	Log.d("Fed", "handShake");
    	Log.d("Fed", "" + num);
    	txtShake.setText( "" + num );
    }
    
    @Override
	public void onResume() {
		Log.d("Fed", "/onResume");
		
		shakeDetectActivity.onResume();		//Required, resume listening on the sensor
		super.onResume();
	}

	@Override
	public void onPause() {
		Log.d("Fed", "/onPause");
		
		shakeDetectActivity.onPause();	//Required, unregister the sensor
		super.onPause();
	}
	
	


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
