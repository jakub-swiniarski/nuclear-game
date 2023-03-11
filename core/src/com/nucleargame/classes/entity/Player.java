package com.nucleargame.classes.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Entity{
    public OrthographicCamera cam;
    public Player(){
        hp=100;
        img = new Texture(Gdx.files.internal("player/walkingD/0.png"));
        for(int i=0; i<3; i++){
            walkingR[i]=new Texture(Gdx.files.internal("player/walkingR/"+i+".png"));
            walkingL[i]=new Texture(Gdx.files.internal("player/walkingL/"+i+".png"));
            walkingU[i]=new Texture(Gdx.files.internal("player/walkingU/"+i+".png"));
            walkingD[i]=new Texture(Gdx.files.internal("player/walkingD/"+i+".png"));
        }
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
            frameDelay++;
            if(frameDelay%5==0) {
                frameCount++;
                if(frameCount>=3) frameCount=0;
                img=walkingL[frameCount];
            }
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)  && !Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            rect.x += movingSpeed * Gdx.graphics.getDeltaTime();
            frameDelay++;
            if(frameDelay%5==0) {
                frameCount++;
                if(frameCount>=3) frameCount=0;
                img=walkingR[frameCount];
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && !Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            rect.y += movingSpeed * Gdx.graphics.getDeltaTime();
            if(!(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.RIGHT))) {
                frameDelay++;
                if(frameDelay%5==0) {
                    frameCount++;
                    if(frameCount>=3) frameCount=0;
                    img=walkingU[frameCount];
                }
            }
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)  && !Gdx.input.isKeyPressed(Input.Keys.UP)) {
            rect.y -= movingSpeed * Gdx.graphics.getDeltaTime();
            if(!(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.RIGHT))){
                frameDelay++;
                if(frameDelay%5==0) {
                    frameCount++;
                    if(frameCount>=3) frameCount=0;
                    img=walkingD[frameCount];
                }
            }
        }
    }
}
