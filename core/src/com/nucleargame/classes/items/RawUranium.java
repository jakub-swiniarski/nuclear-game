package com.nucleargame.classes.items;

import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.nucleargame.classes.entity.Player;

public class RawUranium extends Item {
    public PointLight light;
    public int distX,distY,dist;
    public RawUranium(){
        rect.width=160;
        rect.height=160;
        img=new Texture(Gdx.files.internal("items/raw-uranium.png"));
    }
    public void checkForProximity(){
        //calculate distance
        distX=Math.abs(rect.x- Player.rect.x);
        distY=Math.abs(rect.y- Player.rect.y);
        dist=(int)Math.sqrt(distX+distY);

        if(dist<=20){
            if(Player.geigerCounterDelay%2==0){
                Player.geigerCounterSound.play(1.0f);
            }
        }
        else if(dist<=30){
            if(Player.geigerCounterDelay%5==0){
                Player.geigerCounterSound.play(1.0f);
            }
        }
        else if(dist<=40){
            if(Player.geigerCounterDelay%15==0){
                Player.geigerCounterSound.play(1.0f);
            }
        }

        Player.geigerCounterDelay++;
    }
}
