
package br.ol.frogger;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundClass {

    private MediaPlayer player;

    public enum Music {
        PLAYING, MENU
    }

    public enum Sound {
         HIT, FOOTSTEB, WIN, GAMEOVER, REST
    }

    private String getMediaURL(Music music) {
        switch (music) {
            case PLAYING:
                return "/res/happy.mp3";
            case MENU:
                return "/res/MENU.wav";
        }
        return "";
    }

    private String getMediaURL(Sound sound) {
        switch (sound) {
            case HIT:
                return "/res/diesound.mp3";
            case FOOTSTEB:
                return "/res/footsteb.wav";
            case WIN:
                return "/res/winsound.mp3";
            case GAMEOVER:
                return "/res/gameover.wav";
            case REST:
                return "/res/rest.wav";
        }
        return "";
    }

    public void playMusic(Music music) {
        if (player != null) {
            player.dispose();
        }
        Media media = new Media(getClass().getResource(getMediaURL(music)).toExternalForm());
        player = new MediaPlayer(media);
        player.setAutoPlay(true);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.setVolume(0.5);
    }

    public void setMusicRate(double rate) {
        player.setRate(rate);
    }

    public void stopMusic() {
        player.stop();
    }

    public void playSound(Sound sound) {
        AudioClip ac = new AudioClip(getClass().getResource(getMediaURL(sound)).toExternalForm());
        ac.play();
    }
    
    public void playSound(Sound sound,double rate) {
        AudioClip ac = new AudioClip(getClass().getResource(getMediaURL(sound)).toExternalForm());
        ac.setRate(rate);
        ac.play();
    }
}
