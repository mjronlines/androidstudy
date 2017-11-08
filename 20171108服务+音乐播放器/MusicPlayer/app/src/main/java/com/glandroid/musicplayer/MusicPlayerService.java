package com.glandroid.musicplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import java.util.List;

public class MusicPlayerService extends Service {

    public static final int PLAYING = 1;
    public static final int MUSIC_STOP = 0;
    public static final int PAUSE = 2;
    public static int playingStatus;
    private SharedPreferences sp;
    private MediaPlayer mediaPlayer;

    public MusicPlayerService() {
    }

    @Override
    public void onCreate() {
        System.out.println("音乐播放服务开启了");
        sp = getSharedPreferences("config", MODE_PRIVATE);
        mediaPlayer = new MediaPlayer();
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    @Override
    public void onDestroy() {
        System.out.println("音乐播放服务关闭了");
        super.onDestroy();
    }

    private class MyBinder extends Binder implements IMusicService{

        @Override
        public void callPlay(List<String> playList, int position) {
            play(playList, position);
        }

        @Override
        public void callStop() {
            stopPlayer();
        }
    }

    private void stopPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancelAll();
    }

    /**
     * 播放音乐
     *
     * @param playList
     *          所有音频列表
     * @param position
     *          当前的位置
     */
    private void play(final List<String> playList, final int position) {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            System.out.println(playList.get(position));
            mediaPlayer.setDataSource(playList.get(position));
            mediaPlayer.prepare();
            mediaPlayer.start();
            String path = playList.get(position);
            showNotification(path.substring(path.lastIndexOf("/") + 1));
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    int mode = sp.getInt("mode", 0);
                    if (mode == SettingActivity.CYCLE) {
                        play(playList, position);
                    } else if (mode == SettingActivity.NEXT){
                        // 播放下一曲
                        int newPosition = position + 1;
                        if (newPosition >= playList.size()) {
                            newPosition = 0;
                        }
                        play(playList, newPosition);
                    } else if (mode == SettingActivity.STOP) {
                        playingStatus = MUSIC_STOP;
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            playingStatus = MUSIC_STOP;
        }
    }

    /**
     * 显示播放音乐的通知提醒
     *
     * @param filename
     */
    private void showNotification(String filename) {
        Notification noti = new Notification.Builder(this).setContentTitle("酷狗音乐正在播放")
                .setContentText(filename)
                .setSmallIcon(R.drawable.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
                .build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(0, noti);
    }


}
