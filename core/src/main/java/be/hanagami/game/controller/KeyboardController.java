package be.hanagami.game.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class KeyboardController implements InputProcessor {

    public boolean left, right, up, down;
    public boolean isMouse1Down, isMouse2Down, isMouse3Down;
    public boolean isDragged;
    public Vector2 mouseLocation = new Vector2(0, 0);

    @Override
    public boolean keyDown(int keycode) {
        boolean keyProcessed = false;
        switch(keycode){
            case Input.Keys.LEFT:
                left = true;
                keyProcessed = true;
                break;
            case Input.Keys.RIGHT:
                right = true;
                keyProcessed = true;
                break;
            case Input.Keys.UP:
                up = true;
                keyProcessed = true;
                break;
            case Input.Keys.DOWN:
                down = true;
                keyProcessed = true;
        }
        return keyProcessed;
    }

    @Override
    public boolean keyUp(int keycode) {
        boolean keyProcessed = false;
        switch(keycode){
            case Input.Keys.LEFT:
                left = false;
                keyProcessed = true;
                break;
            case Input.Keys.RIGHT:
                right = false;
                keyProcessed = true;
                break;
            case Input.Keys.UP:
                up = false;
                keyProcessed = true;
                break;
            case Input.Keys.DOWN:
                down = false;
                keyProcessed = true;
        }
        return keyProcessed;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == 0){
            isMouse1Down = true;
        } else if (button == 1) {
            isMouse2Down = true;
        } else if (button == 2) {
            isMouse3Down = true;
        }
        mouseLocation.x = screenX;
        mouseLocation.y = screenY;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        isDragged = false;
        if (button == 0){
            isMouse1Down = false;
        } else if (button == 1) {
            isMouse2Down = false;
        } else if (button == 2) {
            isMouse3Down = false;
        }
        mouseLocation.x = screenX;
        mouseLocation.y = screenY;
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        isDragged = true;
        mouseLocation.x = screenX;
        mouseLocation.y = screenY;
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mouseLocation.x = screenX;
        mouseLocation.y = screenY;
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
