package com.nucleargame.entity;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Entity {
    public Rectangle rect;
    public Texture img;
    public int hp;
    public int movingSpeed;
    public int frameCount;
    public int frameDelay;
    public Texture[] walkingU=new Texture[3],
            walkingD=new Texture[3],
            walkingR=new Texture[3],
            walkingL=new Texture[3];

    public Entity(){
        frameCount=0;
        frameDelay=0;
        rect=new Rectangle();
        rect.x=9999;
        rect.y=9999;
        movingSpeed=0;
    }
}
