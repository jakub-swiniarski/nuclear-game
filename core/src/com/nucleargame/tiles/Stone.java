package com.nucleargame.tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Stone extends Tile{
    public Stone(){
        id=3;
        img=new Texture(Gdx.files.internal("tiles/stone.png"));
    }
}
