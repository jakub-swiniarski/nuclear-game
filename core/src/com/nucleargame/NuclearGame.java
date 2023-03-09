package com.nucleargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
		batch.setProjectionMatrix(player.cam.combined);
		player.cam.position.set(player.rect.x+player.rect.width/2,player.rect.y+player.rect.height/2,0);
		player.cam.update();

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
