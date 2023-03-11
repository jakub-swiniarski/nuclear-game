package com.nucleargame.classes.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Grass extends Floor{
    public Grass(){
        img = new Texture(Gdx.files.internal("tiles/grass.png"));
        rect.x=0;
        rect.y=0;
    }
}
