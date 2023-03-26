package com.nucleargame.classes.tiles;

import java.io.Console;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Grass extends Tile {
    public Grass(){
        id=1;
        //set random number for random grass
        int random = MathUtils.random.nextInt(3);
        //if 0 generate again
        if(random == 0)
        {
            random = 1;
        }
        
        img = new Texture(Gdx.files.internal("tiles/grass/grass"+ random +".png"));
        rect.x=0;
        rect.y=0;
    }
}
