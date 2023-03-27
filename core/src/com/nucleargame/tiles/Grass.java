package com.nucleargame.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.nucleargame.tiles.Tile;

public class Grass extends Tile {
    public Grass(){
        id=1;
        img = new Texture(Gdx.files.internal("tiles/grass/grass"+ random +".png"));
    }
}
