package com.zhezhe.servicepractice.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.zhezhe.servicepractice.R;

import java.util.Objects;


/**
 * 播放音乐Service
 *
 * @author zhengzhou
 */
public class MusicService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopMusic();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getStringExtra("action");
        if ("play".equals(action)) {
            playMusic();
        } else if ("pause".equals(action)) {
            pauseMusic();
        } else if ("stop".equals(action)) {
            stopMusic();
        } else if ("exit".equals(action)) {
            exitMusic();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private MediaPlayer player;

    private void pauseMusic() {
        if (Objects.nonNull(player) && player.isPlaying()) {
            player.pause();
        }
    }

    private void stopMusic() {
        if (Objects.nonNull(player)) {
            player.stop(); // 停止
            player.reset(); // 重置
            player.release(); // 释放加载的音乐资源
            player = null;   // 赋予空
        }
    }

    private void exitMusic() {
        stopMusic();
    }

    private void playMusic() {
        if (Objects.isNull(player)) {
            player = MediaPlayer.create(this, R.raw.shuishou);
        }
        player.start();
    }
}
