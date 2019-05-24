package com.vydth.exe2;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    private Sensor accelerometor;
    private float vibrateThreshold = 0;
    LinearLayout view;
    ImageView imgHinh1;
    ImageView imgHinh2;
    TextView tvDiem;
    Button btnChan, btnLe;
    int diem = 1000;
    int diemx = 0;
    int diemy = 0;
    int diemxx = 0;
    Random rd;

    private float lastX, lastY, lastZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setSensor();
        setEvent();
    }

    public void setControl() {
        view = (LinearLayout) findViewById(R.id.linearLayout);
        imgHinh1 = (ImageView) findViewById(R.id.imageView1);
        imgHinh2 = (ImageView) findViewById(R.id.imageView2);
        tvDiem = (TextView) findViewById(R.id.tvDiem1);
        btnChan = (Button) findViewById(R.id.chan);
        btnLe = (Button) findViewById(R.id.le);
    }

    public void setEvent() {

        btnChan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diemxx % 2 == 0) {
                    diem += 10;
                } else {
                    diem -= 10;
                }
            }
        });
        btnLe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (diemxx % 2 != 0) {
                    diem += 10;
                } else {
                    diem -= 10;
                }
            }
        });


    }

    private void setSensor() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accelerometor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometor, SensorManager.SENSOR_DELAY_NORMAL);
            vibrateThreshold = accelerometor.getMaximumRange() / 20;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            doiHinh(event);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void doiHinh(SensorEvent event) {
        if (diem == 0) {
            btnChan.setEnabled(false);
            btnLe.setEnabled(false);
        }
        float deltaX = Math.abs(lastX - event.values[0]);
        float deltaY = Math.abs(lastY - event.values[1]);
        float deltaZ = Math.abs(lastZ - event.values[2]);

        if (deltaX > vibrateThreshold) {
            rd = new Random();
            int nRD = 1 + rd.nextInt(6);
            diemx = nRD;
            switch (nRD) {
                case 1:
                    imgHinh1.setImageResource(R.drawable.h1);

                    break;
                case 2:
                    imgHinh1.setImageResource(R.drawable.h2);

                    break;
                case 3:
                    imgHinh1.setImageResource(R.drawable.h3);
                    break;
                case 4:
                    imgHinh1.setImageResource(R.drawable.h4);
                    break;
                case 5:
                    imgHinh1.setImageResource(R.drawable.h5);
                    break;
                case 6:
                    imgHinh1.setImageResource(R.drawable.h6);
                    break;
            }
            nRD = 1 + rd.nextInt(6);
            diemy = nRD;
            switch (nRD) {
                case 1:
                    imgHinh2.setImageResource(R.drawable.h1);
                    break;
                case 2:
                    imgHinh2.setImageResource(R.drawable.h2);
                    break;
                case 3:
                    imgHinh2.setImageResource(R.drawable.h3);
                    break;
                case 4:
                    imgHinh2.setImageResource(R.drawable.h4);
                    break;
                case 5:
                    imgHinh2.setImageResource(R.drawable.h5);
                    break;
                case 6:
                    imgHinh2.setImageResource(R.drawable.h6);
                    break;
            }

        }

        if (deltaY > vibrateThreshold) {
            rd = new Random();
            int nRD = 1 + rd.nextInt(6);
            diemx = nRD;
            switch (nRD) {
                case 1:
                    imgHinh1.setImageResource(R.drawable.h1);
                    break;
                case 2:
                    imgHinh1.setImageResource(R.drawable.h2);
                    break;
                case 3:
                    imgHinh1.setImageResource(R.drawable.h3);
                    break;
                case 4:
                    imgHinh1.setImageResource(R.drawable.h4);
                    break;
                case 5:
                    imgHinh1.setImageResource(R.drawable.h5);
                    break;
                case 6:
                    imgHinh1.setImageResource(R.drawable.h6);
                    break;
            }
            nRD = 1 + rd.nextInt(6);
            diemy = nRD;
            switch (nRD) {
                case 1:
                    imgHinh2.setImageResource(R.drawable.h1);
                    break;
                case 2:
                    imgHinh2.setImageResource(R.drawable.h2);
                    break;
                case 3:
                    imgHinh2.setImageResource(R.drawable.h3);
                    break;
                case 4:
                    imgHinh2.setImageResource(R.drawable.h4);
                    break;
                case 5:
                    imgHinh2.setImageResource(R.drawable.h5);
                    break;
                case 6:
                    imgHinh2.setImageResource(R.drawable.h6);
                    break;
            }

        }

        if (deltaZ > vibrateThreshold) {
            rd = new Random();
            int nRD = 1 + rd.nextInt(6);
            diemx = nRD;
            switch (nRD) {
                case 1:
                    imgHinh1.setImageResource(R.drawable.h1);
                    break;
                case 2:
                    imgHinh1.setImageResource(R.drawable.h2);
                    break;
                case 3:
                    imgHinh1.setImageResource(R.drawable.h3);
                    break;
                case 4:
                    imgHinh1.setImageResource(R.drawable.h4);
                    break;
                case 5:
                    imgHinh1.setImageResource(R.drawable.h5);
                    break;
                case 6:
                    imgHinh1.setImageResource(R.drawable.h6);
                    break;
            }
            nRD = 1 + rd.nextInt(6);
            diemy = nRD;
            switch (nRD) {
                case 1:
                    imgHinh2.setImageResource(R.drawable.h1);
                    break;
                case 2:
                    imgHinh2.setImageResource(R.drawable.h2);
                    break;
                case 3:
                    imgHinh2.setImageResource(R.drawable.h3);
                    break;
                case 4:
                    imgHinh2.setImageResource(R.drawable.h4);
                    break;
                case 5:
                    imgHinh2.setImageResource(R.drawable.h5);
                    break;
                case 6:
                    imgHinh2.setImageResource(R.drawable.h6);
                    break;
            }

        }

        lastX = event.values[0];
        lastY = event.values[1];
        lastZ = event.values[2];
         diemxx= diemx + diemy;
        tvDiem.setText("điểm của bạn là: " + diem);
    }
}