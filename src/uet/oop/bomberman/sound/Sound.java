package uet.oop.bomberman.sound;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.HashMap;

public class Sound {
    public static Sound instance;

    public static final String bombExplose = "bomb_bang.wav";
    public static final String startStage ="startstage.wav";
    public static final String bomberDie = "bomber_die.wav";
    public static final String item = "item.wav";
    public static final String lose = "lose.mid";
    public static final String menu = "menu.wav";
    public static final String mosterDie = "monster_die.wav";
    public static final String newbomb = "newbomb.wav";
    public static final String win = "win.wav";
    public static final String backgroundGame = "lose.wav";
    public static final String playGame = "playgame.mid";
    public static final String destroy ="destroy.wav";

    private HashMap<String, AudioClip> audio;
    
    public static Sound getInstance(){
        if(instance == null){
            instance = new Sound();
        }
        return instance;
    }
    
    public Sound(){
        audio = new HashMap<>();
        loadAllAudio();
    }
    
    public void loadAllAudio(){
        putAudio(bombExplose);
        putAudio(startStage);
        putAudio(bomberDie);
        putAudio(item);
        putAudio(lose);
        putAudio(menu);
        putAudio(mosterDie);
        putAudio(win);
        putAudio(newbomb);
        putAudio(backgroundGame);
        putAudio(playGame);
        putAudio(destroy);
    }
    
    public void putAudio(String name){
        AudioClip au = Applet.newAudioClip(Sound.class.getResource("/sound/"+name));
        audio.put(name, au);
    } 
    
    public AudioClip getAudio(String name){
        return audio.get(name);
    }
    
    public void stop(){
        getAudio(bombExplose);
        getAudio(startStage);
        getAudio(bomberDie);
        getAudio(item);
        getAudio(lose);
        getAudio(menu);
        getAudio(mosterDie);
        getAudio(win);
        getAudio(newbomb);
        getAudio(backgroundGame);
        getAudio(playGame);
        getAudio(destroy);
    }
}
