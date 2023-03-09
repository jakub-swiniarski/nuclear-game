package com.nucleargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nucleargame.classes.entity.Player;
import com.nucleargame.classes.floor.Grass;

public class NuclearGame extends ApplicationAdapter {
	SpriteBatch batch;
	FreeTypeFontGenerator generator;
	FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	BitmapFont font24;
	Player player;
	Grass grass;
	OrthographicCamera worldCam;
	World world;
	Stage stage;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		worldCam = new OrthographicCamera(1600,900);
		worldCam.position.set(0,0, 0);
		player=new Player();
		grass=new Grass();

		stage = new Stage();
		world = new World(new Vector2(0,0),false);

		//font
		generator = new FreeTypeFontGenerator(Gdx.files.internal("font.otf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 24;
		font24 = generator.generateFont(parameter);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.setProjectionMatrix(player.cam.combined);
		player.cam.position.set(player.rect.x+player.rect.width/2,player.rect.y+player.rect.height/2,0);
		player.cam.update();

		//affected by light
		batch.begin();
		batch.draw(grass.img, grass.rect.x, grass.rect.y);
		batch.draw(player.img, player.rect.x, player.rect.y);
		batch.end();

		//not affected by light, hud
		batch.setProjectionMatrix(stage.getBatch().getProjectionMatrix());
		batch.begin();
		font24.draw(batch, "FPS: "+Gdx.graphics.getFramesPerSecond(), 5, 20);
		batch.end();

		player.checkForInput();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.img.dispose();
		grass.img.dispose();
		generator.dispose();
		font24.dispose();
		world.dispose();
		stage.dispose();
	}
}
