package com.nucleargame.classes.tiles;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Floor {
    public Rectangle rect;
    public Texture img;

    public Floor(){
        rect=new Rectangle();
        rect.width=160;
        rect.height=160;
        rect.x=9999;
        rect.y=9999;
    }
}
