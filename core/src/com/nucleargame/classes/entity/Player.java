package com.nucleargame.classes.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Entity{
    public OrthographicCamera cam;
    public Player(){
        hp=100;
        img = new Texture(Gdx.files.internal("player/playerD.png"));
        rect.width=180;
        rect.height=300;
        rect.x=0;
        rect.y=0;
        movingSpeed=400;
        cam = new OrthographicCamera(1600,900);
    }
    public void checkForInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            rect.x -= movingSpeed * Gdx.graphics.getDeltaTime();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)  && !Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            rect.x += movingSpeed * Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && !Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            rect.y += movingSpeed * Gdx.graphics.getDeltaTime();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)  && !Gdx.input.isKeyPressed(Input.Keys.UP)) {
            rect.y -= movingSpeed * Gdx.graphics.getDeltaTime();
        }
    }
}
