package com.nucleargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nucleargame.classes.entity.Player;

public class NuclearGame extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player=new Player();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(player.img, player.rect.x, player.rect.y);
		batch.end();
		player.checkForInput();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.img.dispose();
	}
}
