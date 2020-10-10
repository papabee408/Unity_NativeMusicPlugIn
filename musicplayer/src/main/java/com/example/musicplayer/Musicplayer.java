package com.example.musicplayer;

import android.media.MediaPlayer;
import android.widget.Toast;

public class Musicplayer {

    MediaPlayer mediaPlayer;
    int position = 0;

    public void playAudio(String url) {
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

    public void onDestroy() {
        killMediaPlayer();
    }

    public void pauseAudio(){
        mediaPlayer.pause();
        position = mediaPlayer.getCurrentPosition();
    }

    public void restart(){
        mediaPlayer.start();
        mediaPlayer.seekTo(position);
    }

    public int getDuration(){
        return mediaPlayer.getDuration();
    }

    public int getCurrentPosition(){
        return mediaPlayer.getCurrentPosition();
    }

    public void fastForward(){
        if(mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition() > 10000){
            mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+10000);
        }
    }

    public void rewind(){
        if(mediaPlayer.getCurrentPosition() > 10000){
            mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-10000);
        }
    }

    public void moveToPoint(float progressSliderValue){
        int movingPoint = (int) (mediaPlayer.getDuration() * progressSliderValue);
        mediaPlayer.seekTo(movingPoint);
    }

    public boolean isPlaying(){

        if(mediaPlayer == null){
            return false;
        }else{
            return mediaPlayer.isPlaying();
        }
    }



}
