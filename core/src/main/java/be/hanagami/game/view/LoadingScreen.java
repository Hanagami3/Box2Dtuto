package be.hanagami.game.view;

import com.badlogic.gdx.Screen;

import be.hanagami.game.Box2DTuto;

public class LoadingScreen implements Screen {

    private Box2DTuto parent;

    public LoadingScreen(Box2DTuto box2DTuto) {
        parent = box2DTuto;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        parent.changeScreen(Box2DTuto.MENU);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
