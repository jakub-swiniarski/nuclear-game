package com.nucleargame.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Item {
    public Rectangle rect;
    public Texture img;

    public Item(){
        rect = new Rectangle();
        rect.x=9999;
        rect.y=9999;
    }
}
