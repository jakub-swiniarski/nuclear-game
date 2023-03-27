package com.nucleargame.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Sand extends Tile{
    public Sand(){
        id=2;
        img = new Texture(Gdx.files.internal("tiles/sand.png"));
    }
}
