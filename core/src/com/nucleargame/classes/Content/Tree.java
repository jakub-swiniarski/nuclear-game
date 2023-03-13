package com.nucleargame.classes.Content;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Tree extends Content {
    public Texture imgCrown,imgTrunk;
    public Tree(){
        id=1;
        img=new Texture(Gdx.files.internal("content/tree.png"));
        imgCrown=new Texture(Gdx.files.internal("content/tree-crown.png"));
        imgTrunk=new Texture(Gdx.files.internal("content/tree-trunk.png")); //COLLISIONS ONLY WITH THE TRUNK, COPY FROM DUNGEON GAME
        rect.width=360;
        rect.height=480;
    }
}
