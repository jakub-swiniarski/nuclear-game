package com.nucleargame.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Water extends Tile{
    public Water(){
        id=0;
        //add animations later
        img = new Texture(Gdx.files.internal("tiles/water/water1.png"));
    }
}
