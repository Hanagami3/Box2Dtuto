package be.hanagami.game.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import be.hanagami.game.Box2DTuto;

public class LoadingScreen implements Screen {

    private Box2DTuto parent;
    private TextureAtlas atlas;
    //private SpriteBatch sb;
    private AtlasRegion title;
    private Animation flameAnimation;

    public final int IMAGE = 0;
    public final int FONT = 1;
    public final int PARTY = 2;
    public final int SOUND = 3;
    public final int MUSIC = 4;

    private int currentLoadingStage = 0;

    public float countDown = 5f;

    private AtlasRegion dash;
    private Stage stage;
    private Table table;
    private Image titleImage;
    private AtlasRegion copyright;
    private Image copyrightImage;
    private Table loadingTable;
    private AtlasRegion background;


    public LoadingScreen(Box2DTuto box2DTuto) {
        parent = box2DTuto;
        stage = new Stage(new ScreenViewport());

        loadAssets();
        parent.assMan.queueAddImages();
        System.out.println("Loading images...");
    }

    @Override
    public void show() {
        titleImage = new Image(title);

        table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        table.setBackground(new TiledDrawable(background));

        loadingTable = new Table();
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));
        loadingTable.add(new LoadingBarPart(dash, flameAnimation));

        table.add(titleImage).align(Align.center).pad(10, 0, 0, 0).colspan(10);
        table.row();
        table.add(loadingTable).width(400);
        table.row();
        table.add(copyrightImage).align(Align.center).pad(200, 0, 0, 0).colspan(10);


        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        parent.changeScreen(Box2DTuto.MENU);

//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        if (parent.assMan.manager.update()) { // Load some, will return true if done loading
//            currentLoadingStage+= 1;
//            if(currentLoadingStage <= 5){
//                loadingTable.getCells().get((currentLoadingStage-1)*2).getActor().setVisible(true);
//                loadingTable.getCells().get((currentLoadingStage-1)*2+1).getActor().setVisible(true);
//            }
//            switch(currentLoadingStage){
//                case FONT:
//                    System.out.println("Loading fonts....");
//                    parent.assMan.queueAddFonts();
//                    break;
//                case PARTY:
//                    System.out.println("Loading Particle Effects....");
//                    parent.assMan.queueAddParticleEffects();
//                    break;
//                case SOUND:
//                    System.out.println("Loading Sounds....");
//                    parent.assMan.queueAddSounds();
//                    break;
//                case MUSIC:
//                    System.out.println("Loading fonts....");
//                    parent.assMan.queueAddMusic();
//                    break;
//                case 5:
//                    System.out.println("Finished");
//                    break;
//            }
//            if (currentLoadingStage >5){
//                countDown -= delta;
//                currentLoadingStage = 5;
//                if(countDown < 0){
//                    parent.changeScreen(Box2DTuto.MENU);
//                }
//            }
//        }

        //stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }

//    private void drawLoadingBar(int stage, TextureRegion currentFlame){
//        for (int i = 0;i < stage;i++){
//            sb.draw(currentFlame, 50 + (i * 50), 150, 50, 50);
//            sb.draw(dash, 35 + (i * 50), 140, 80, 80);
//        }
//    }

    private void loadAssets(){
        parent.assMan.queueAddLoadingImages();
        parent.assMan.manager.finishLoading();

        atlas = parent.assMan.manager.get("images/loading.atlas");
        title = atlas.findRegion("staying-alight-logo");
        dash = atlas.findRegion("loading-dash");
        background = atlas.findRegion("flamebackground");
        copyright = atlas.findRegion("copyright");
        flameAnimation = new Animation(0.07f, atlas.findRegion("flames/flames"), PlayMode.LOOP);
    }
    class LoadingBarPart extends Actor {

        private AtlasRegion image;
        private Animation flameAnimation;
        private float stateTime = 5f;
        private TextureRegion currentFrame;


        public LoadingBarPart(AtlasRegion ar, Animation an){
            super();
            image = ar;
            flameAnimation = an;
            this.setWidth(30);
            this.setHeight(25);
            this.setVisible(false);
        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            super.draw(batch, parentAlpha);
            batch.draw(image, getX(), getY(), 30, 30);
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE);
            batch.draw(currentFrame, getX() - 5, getY(), 40, 40);
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        }

        @Override
        public void act(float delta) {
            super.act(delta);
            stateTime += delta;
            currentFrame = (TextureRegion) flameAnimation.getKeyFrame(stateTime, true);
        }
    }

}
