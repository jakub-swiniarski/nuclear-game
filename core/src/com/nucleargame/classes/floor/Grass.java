package com.nucleargame.classes.floor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Grass extends Floor{
    public Grass(){
        img = new Texture(Gdx.files.internal("grass.png"));
    }
}
