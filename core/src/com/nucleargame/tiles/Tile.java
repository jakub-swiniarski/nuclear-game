package com.nucleargame.tiles;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Tile {
    public Rectangle rect;
    public Texture img;
    public int id;

    public Tile(){
        id=0;
        rect=new Rectangle();
        rect.width=160;
        rect.height=160;
        rect.x=9999;
        rect.y=9999;
    }
}
