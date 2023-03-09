package com.nucleargame.classes.entity;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Entity {
    public Rectangle rect;
    public Texture img;
    public int hp;

    public Entity(){
        rect=new Rectangle();
        rect.x=9999;
        rect.y=9999;
    }
    public void walkingAnimation(){

    }
}
