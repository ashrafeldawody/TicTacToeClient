package client.controllers;

import javafx.scene.media.*;
import java.io.File;

public class SoundPlayer {
    MediaPlayer mediaPlayer;
    enum SOUND{
        GAME_START,
        GAME_VICTORY,
        GAME_DEFEAT,
        TICK,
    }
    public SoundPlayer(SOUND type){
        Media media = new Media(getClass().getResource("/audio/" + getAudioSource(type) +".mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
    }
    public void play(){
        mediaPlayer.play();
    }
    private String getAudioSource(SOUND type){
        switch(type){
            case TICK:
                return "tick";
            case GAME_START:
                return "gamestart";
            case GAME_VICTORY:
                return "victory";
            case GAME_DEFEAT:
                return "defeat";
            default:
                return "";
        }
    }
}
