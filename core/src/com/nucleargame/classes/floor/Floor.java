package com.nucleargame.classes.floor;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Floor {
    public Rectangle rect;
    public Texture img;

    public Floor(){
        rect=new Rectangle();
        rect.width=100;
        rect.height=100;
        rect.x=9999;
        rect.y=9999;
    }
}
