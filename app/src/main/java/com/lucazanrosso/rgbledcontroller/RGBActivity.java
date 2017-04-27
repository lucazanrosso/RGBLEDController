package com.lucazanrosso.rgbledcontroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import java.io.IOException;
import java.util.Locale;


public class RGBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rgb);

        SeekBar seekBarRed = (SeekBar) findViewById(R.id.seekbar_red);
        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sendMessage('r', progress);
            }
        });

        SeekBar seekBarGreen = (SeekBar) findViewById(R.id.seekbar_green);
        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sendMessage('g', progress);
            }
        });

        SeekBar seekBarBlue = (SeekBar) findViewById(R.id.seekbar_blue);
        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sendMessage('b', progress);
            }
        });
    }

    public void sendMessage(char c, int i) {
        MainActivity.mConnectedThread.write(String.format(Locale.getDefault(), "%03d", i) + c);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (MainActivity.mConnectedThread != null) {
            MainActivity.mConnectedThread.cancel();
            try {
                MainActivity.btSocket.close();
            } catch (IOException e2) {
                finish();
            }
        }
    }
}
