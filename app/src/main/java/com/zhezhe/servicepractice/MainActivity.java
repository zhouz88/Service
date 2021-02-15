package com.zhezhe.servicepractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zhezhe.servicepractice.services.MusicService;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_main_play;
    private Button btn_main_stop;
    private Button btn_main_pause;
    private Button btn_main_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btn_main_play = (Button) findViewById(R.id.btn_main_play);
        this.btn_main_stop = (Button) findViewById(R.id.btn_main_stop);
        this.btn_main_pause = (Button) findViewById(R.id.btn_main_pause);
        this.btn_main_exit = (Button) findViewById(R.id.btn_main_exit);


        btn_main_play.setOnClickListener(this);
        btn_main_stop.setOnClickListener(this);
        btn_main_pause.setOnClickListener(this);
        btn_main_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MusicService.class);
        if (v == btn_main_play) {
            intent.putExtra("action", "play");
            startService(intent);
        } else if (v == btn_main_stop) {
            intent.putExtra("action", "stop");
            startService(intent);
        } else if (v == btn_main_pause) {
            intent.putExtra("action", "pause");
            startService(intent);
        } else if (v == btn_main_exit) {
            //停止服务
            stopService(intent);
            finish();
        }
    }
}
