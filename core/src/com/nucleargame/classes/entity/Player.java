package com.nucleargame.classes.entity;

import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Player extends Entity{
    public static Rectangle rect;
    public static Texture img;
    public OrthographicCamera cam;
    public float camZoom;
    public static Sound geigerCounterSound;
    public static PointLight light;
    public Player(){
        geigerCounterSound = Gdx.audio.newSound(Gdx.files.internal("sounds/geiger-counter.mp3"));
        camZoom=1;
        hp=100;
        rect=new Rectangle();
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
        cam = new OrthographicCamera(1920*camZoom,1080*camZoom);
    }
    public void resetCamResolution(){
        if(camZoom<0.3f) camZoom=0.3f;
        if(camZoom>3f) camZoom=3f;
        cam.viewportWidth=1920*camZoom;
        cam.viewportHeight=1080*camZoom;
    }
    public void checkForInput(){
        //movement
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

        //camera zoom
        if(Gdx.input.isKeyPressed(Input.Keys.I)) {
            camZoom-=0.05f;
            resetCamResolution();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.O)) {
            camZoom+=0.05f;
            resetCamResolution();
        }
        light.setPosition(rect.x+rect.width/2,rect.y+rect.height/2);
    }
}
