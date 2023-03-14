package com.nucleargame.classes.Content;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.nucleargame.classes.entity.Player;

public class Tree extends Content {
    public static Texture imgCrown,imgTrunk;
    public Tree(){
        id=1;
        img=new Texture(Gdx.files.internal("content/tree.png"));
        imgCrown=new Texture(Gdx.files.internal("content/tree-crown.png"));
        imgTrunk=new Texture(Gdx.files.internal("content/tree-trunk.png")); //COLLISIONS ONLY WITH THE TRUNK, COPY FROM DUNGEON GAME
        rect.width=360;
        rect.height=480;
    }

    public void collisionCheck(){   //glitchy 💀
        if(Player.rect.y+ Player.rect.height>=rect.y && Player.rect.y<=rect.y+rect.height-240){
            if(Player.rect.x<=rect.x+rect.width-140 && Player.rect.x>=rect.x+(rect.width-140)/2){
                Player.rect.x=rect.x+rect.width-140;
            }
            if(Player.rect.x+Player.rect.width>=rect.x+120 && Player.rect.x+Player.rect.width<=rect.x+(rect.width+120)/2){
                Player.rect.x=rect.x-Player.rect.width+120;
            }
        }
        if(Player.rect.x+Player.rect.width>=rect.x+120 && Player.rect.x<=rect.x+rect.width-140){
            if(Player.rect.y<=rect.y+rect.height-240 && Player.rect.y>=rect.y+(rect.height-240)/2){
                Player.rect.y=rect.y+rect.height-240;
            }
            if(Player.rect.y+Player.rect.height>=rect.y && Player.rect.y+Player.rect.height<=rect.y+(rect.height-240)/2){
                Player.rect.y=rect.y-Player.rect.height;
            }
        }
    }
}
