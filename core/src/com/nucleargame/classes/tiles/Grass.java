package com.nucleargame.classes.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Grass extends Tile {
    public Grass(){
        id=1;
        img = new Texture(Gdx.files.internal("tiles/grass.png"));
        rect.x=0;
        rect.y=0;
    }
}
