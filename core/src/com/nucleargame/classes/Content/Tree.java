package com.nucleargame.classes.Content;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Tree extends WorldContent{
    public Tree(){
        id=1;
        img=new Texture(Gdx.files.internal("content/tree.png"));
        rect.width=360;
        rect.height=480;
    }
}
