package com.nucleargame.classes.items;

import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class RawUranium extends Item {
    public PointLight light;
    public RawUranium(){
        rect.width=160;
        rect.height=160;
        img=new Texture(Gdx.files.internal("items/raw-uranium.png"));
    }
}
