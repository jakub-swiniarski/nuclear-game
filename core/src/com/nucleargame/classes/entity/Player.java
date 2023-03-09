package com.nucleargame.classes.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Entity{
    public Player(){
        hp=100;
        img = new Texture(Gdx.files.internal("player.png"));
        rect.width=180;
        rect.height=300;
        rect.x=100;
        rect.y=100;
    }
}
