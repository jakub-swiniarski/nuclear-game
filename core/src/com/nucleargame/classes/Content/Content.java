package com.nucleargame.classes.Content;

import com.badlogic.gdx.graphics.Texture;
import com.nucleargame.classes.entity.Player;

import java.awt.*;

public class Content {
    public Rectangle rect;
    public Texture img;
    public int id;

    public Content() {
        id = 0;
        rect = new Rectangle();
        rect.x = 9999;
        rect.y = 9999;
    }

    public void interaction() {

    }

    public void collisionCheck() {
        if (Player.rect.y + Player.rect.height >= rect.y && Player.rect.y <= rect.y + rect.height) {
            if (Player.rect.x <= rect.x + rect.width && Player.rect.x >= rect.x + rect.width / 2) Player.rect.x = rect.x + rect.width;
            if (Player.rect.x + Player.rect.width >= rect.x && Player.rect.x + Player.rect.width <= rect.x + rect.width / 2) Player.rect.x = rect.x - Player.rect.width;
        }
        if (Player.rect.x + Player.rect.width >= rect.x && Player.rect.x <= rect.x + rect.width) {
            if (Player.rect.y <= rect.y + rect.height && Player.rect.y >= rect.y + rect.height / 2) Player.rect.y = rect.y + rect.height;
            if (Player.rect.y + Player.rect.height >= rect.y && Player.rect.y + Player.rect.height <= rect.y + rect.height / 2) Player.rect.y = rect.y - Player.rect.height;
        }
    }
}
