package be.hanagami.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class AppPreferences {

    private static final String PREF_MUSIC_VOLUME = "volume";
    private static final String PREF_MUSIC_ENABLE = "music.enabled";
    private static final String PREF_SOUND_VOL = "sound";
    private static final String PREF_SOUND_ENABLE = "sound.enabled";
    private static final String PREFS_NAME = "b2dtut";

    protected Preferences getPrefs(){
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    public float getMusicVolume(){
        return getPrefs().getFloat(PREF_MUSIC_VOLUME, 0.5f);
    }

    public void setMusicVolume(float volume) {
        getPrefs().putFloat(PREF_MUSIC_VOLUME, volume);
        getPrefs().flush();
    }

    public boolean isMusicEnabled(){
        return getPrefs().getBoolean(PREF_MUSIC_ENABLE, true);
    }

    public void setMusicEnabled(boolean musicEnable) {
        getPrefs().putBoolean(PREF_MUSIC_ENABLE, musicEnable);
        getPrefs().flush();
    }

    public float getSoundVolume(){
        return getPrefs().getFloat(PREF_SOUND_VOL, 0.5f);
    }

    public void setSoundVolume(float volume) {
        getPrefs().putFloat(PREF_SOUND_VOL, volume);
        getPrefs().flush();
    }

    public boolean isSoundEffectsEnabled(){
        return getPrefs().getBoolean(PREF_SOUND_ENABLE, true);
    }

    public void setSoundEffectsEnabled(boolean soundEffectsEnable) {
        getPrefs().putBoolean(PREF_SOUND_ENABLE, soundEffectsEnable);
        getPrefs().flush();
    }
}
