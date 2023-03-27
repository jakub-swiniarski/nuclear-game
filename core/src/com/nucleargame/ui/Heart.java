package com.nucleargame.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Heart extends UI{
    public Heart(){
        img=new Texture(Gdx.files.internal("ui/heart.png"));
        rect.width=64;
        rect.height=64;
        rect.x=5;
        rect.y=831;
    }
}
