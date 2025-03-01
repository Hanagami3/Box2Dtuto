package be.hanagami.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import javax.sound.sampled.DataLine;

import be.hanagami.game.B2Model;
import be.hanagami.game.Box2DTuto;
import be.hanagami.game.controller.KeyboardController;

public class MainScreen implements Screen {

    private TextureAtlas atlas;
    private SpriteBatch sb;
    private TextureAtlas.AtlasRegion playerTex;
    private KeyboardController controller;
    private Box2DTuto parent;

    private B2Model model;
    private OrthographicCamera cam;
    private Box2DDebugRenderer debugRenderer;

    public MainScreen(Box2DTuto box2DTuto) {
        parent = box2DTuto;
        cam = new OrthographicCamera(32, 24);
        controller = new KeyboardController();
        model = new B2Model(controller, cam, parent.assMan);
        debugRenderer = new Box2DDebugRenderer(true, true, true, true, true, true);

        sb = new SpriteBatch();
        sb.setProjectionMatrix(cam.combined);

        //parent.assMan.queueAddImages();
        //parent.assMan.manager.finishLoading();
        //playerTex = parent.assMan.manager.get("images/player.png");
        atlas = parent.assMan.manager.get("images/game.atlas");
        playerTex = atlas.findRegion("player");
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {
        model.logicStep(delta);
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        debugRenderer.render(model.world, cam.combined);

        sb.begin();
        sb.draw(playerTex, model.player.getPosition().x -1, model.player.getPosition().y - 1, 2, 2);
        sb.end();
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
