package com.nucleargame.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class RadiationWarning extends UI{
    public static boolean visible;
    public RadiationWarning(){
        visible=false;
        img=new Texture(Gdx.files.internal("ui/radiation-warning.png"));
        rect.width=100;
        rect.height=70;
        rect.x=5;
        rect.y=762;
    }
}
