package com.example.musicplayertest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.musicplayer.Musicplayer;

public class MainActivity extends AppCompatActivity {

    public static final String AUDIO_URL = "https://firebasestorage.googleapis.com/v0/b/fir-test-backend.appspot.com/o/music.mp3?alt=media&token=a2516dc0-7157-4a09-b6b4-d7f6d4f7b34e";

    MediaPlayer mediaPlayer;
    Musicplayer musicplay;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playButton = findViewById(R.id.play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio(AUDIO_URL);
                Toast.makeText(getApplicationContext(), "음악 파일 재생 시작 됨", Toast.LENGTH_SHORT).show();
            }
        });

        Button button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicplay = new Musicplayer();
                musicplay.playAudio(AUDIO_URL);
            }
        });

        Button button2 = findViewById(R.id.button6);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicplay.onDestroy();
            }
        });

    }

    private void playAudio(String url) {
        killMediaPlayer();

        try{
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void killMediaPlayer() {
        if(mediaPlayer != null){
            try{
                mediaPlayer.release();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        killMediaPlayer();
    }


}