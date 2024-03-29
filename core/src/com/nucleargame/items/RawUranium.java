package com.nucleargame.items;

import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.nucleargame.entity.Player;
import com.nucleargame.ui.RadiationWarning;

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
        distX=Math.abs((int)rect.x- (int)Player.rect.x);
        distY=Math.abs((int)rect.y- (int)Player.rect.y);
        dist=(int)Math.sqrt(distX+distY);

        if(dist<=20){
            if(Player.geigerCounterDelay%2==0){
                Player.geigerCounterSound.play(1.0f);
                if(Player.geigerCounterDelay%16==0){
                    Player.hp--;
                }
                RadiationWarning.visible=true;
            }
        }
        else if(dist<=30){
            if(Player.geigerCounterDelay%5==0){
                Player.geigerCounterSound.play(1.0f);
                if(Player.geigerCounterDelay%40==0){
                    Player.hp--;
                }
                RadiationWarning.visible=true;
            }
        }
        else if(dist<=40){
            if(Player.geigerCounterDelay%15==0){
                Player.geigerCounterSound.play(1.0f);
                if(Player.geigerCounterDelay%120==0){
                    Player.hp--;
                }
            }
            RadiationWarning.visible=true;
        }
        else{
            RadiationWarning.visible=false;
        }

        if(Player.hp<0){
            Player.hp=0;
        }
        Player.geigerCounterDelay++;
    }
}
