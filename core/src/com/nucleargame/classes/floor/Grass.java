package com.nucleargame.classes.floor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Grass extends Floor{
    public Grass(){
        img = new Texture(Gdx.files.internal("tiles/grass.png"));
        rect.x=10;
        rect.y=0;
    }
}
