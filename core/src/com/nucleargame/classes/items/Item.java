package com.nucleargame.classes.items;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Item {
    public Rectangle rect;
    public Texture img;

    public Item(){
        rect = new Rectangle();
        rect.x=9999;
        rect.y=9999;
    }
}
