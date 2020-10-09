package com.example.musicplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.Log;

public class NativePlayer {

        public MediaPlayer mediaPlayer;

        public void StreamMedia(String URL) {
            Log.d("Unity",URL);
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDataSource(URL);
                mediaPlayer.prepareAsync();

            } catch (Exception eX) {
                String error;
                error = eX.toString();
                Log.d("Unity",error);

            }
            mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        }


}
