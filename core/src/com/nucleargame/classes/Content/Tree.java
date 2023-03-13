package com.nucleargame.classes.Content;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Tree extends Content {
    public Tree(){
        id=1;
        img=new Texture(Gdx.files.internal("content/tree.png")); //trzeba bedzie rozdzielic sprite na dwie czesci zeby gracz
        //byl pod gorna czescia ale nad dolna
        rect.width=360;
        rect.height=480;
    }
}
