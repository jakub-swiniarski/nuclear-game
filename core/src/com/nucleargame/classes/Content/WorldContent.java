package com.nucleargame.classes.Content;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class WorldContent {
    public Rectangle rect;
    public Texture img;
    public int id;

    public WorldContent(){
        id=0;
        rect=new Rectangle();
        rect.x=9999;
        rect.y=9999;
    }
    public void interaction(){

    }
}
