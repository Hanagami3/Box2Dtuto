package be.hanagami.game;

import com.badlogic.gdx.Game;

import be.hanagami.game.view.EndScreen;
import be.hanagami.game.view.LoadingScreen;
import be.hanagami.game.view.MainScreen;
import be.hanagami.game.view.MenuScreen;
import be.hanagami.game.view.PreferencesScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Box2DTuto extends Game {


    private LoadingScreen loadingScreen;
    private PreferencesScreen preferencesScreen;
    private MenuScreen menuScreen;
    private MainScreen mainScreen;
    private EndScreen endScreen;

    private AppPreferences preferences;



    public final static int MENU = 0;
    public final static int PREFERENCES = 1;
    public final static int APPLICATION = 2;
    public final static int ENDGAME = 3;

    public void changeScreen(int screen){
        switch (screen){
            case MENU:
                if (menuScreen == null) menuScreen = new MenuScreen(this);
                this.setScreen(menuScreen);
                break;
            case PREFERENCES:
                if (preferencesScreen == null) preferencesScreen = new PreferencesScreen(this);
                this.setScreen(preferencesScreen);
                break;
            case APPLICATION:
                if (mainScreen == null) mainScreen = new MainScreen(this);
                this.setScreen(mainScreen);
                break;
            case ENDGAME:
                if (endScreen == null) endScreen = new EndScreen(this);
                this.setScreen(endScreen);
                break;
        }
    }
    public AppPreferences getPreferences() {
        return this.preferences;
    }



    @Override
    public void create() {
        loadingScreen = new LoadingScreen(this);
        preferences = new AppPreferences();
        setScreen(loadingScreen);
    }

//    @Override
//    public void render() {
//        super.render();
//    }

//    @Override
//    public void dispose() {
//        super.dispose();
//    }

}
