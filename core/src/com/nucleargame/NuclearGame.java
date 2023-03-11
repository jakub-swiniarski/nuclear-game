package com.nucleargame;

import box2dLight.RayHandler;
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
	Grass[][] grass = new Grass[20][20];
	OrthographicCamera worldCam;
	World world;
	Stage stage;
	RayHandler rayHandler;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		worldCam = new OrthographicCamera(1600,900);
		worldCam.position.set(0,0, 0);
		player=new Player();
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				grass[i][j]=new Grass();
				grass[i][j].rect.x=i*grass[i][j].rect.width-1420;
				grass[i][j].rect.y=j*grass[i][j].rect.height-1300;
			}
		}

		stage = new Stage();
		world = new World(new Vector2(0,0),false);

		//font
		generator = new FreeTypeFontGenerator(Gdx.files.internal("com-hel.otf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 24;
		font24 = generator.generateFont(parameter);

		//lightning
		rayHandler = new RayHandler(world);
		rayHandler.setCombinedMatrix(player.cam.combined);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.setProjectionMatrix(player.cam.combined);
		player.cam.position.set(player.rect.x+player.rect.width/2,player.rect.y+player.rect.height/2,0);
		player.cam.update();

		//affected by light
		batch.setProjectionMatrix(player.cam.combined);
		batch.begin();
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				batch.draw(grass[i][j].img,grass[i][j].rect.x,grass[i][j].rect.y);
			}
		}
		batch.draw(player.img, player.rect.x, player.rect.y);
		batch.end();

		//rayHandler.updateAndRender();

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
		generator.dispose();
		font24.dispose();
		world.dispose();
		stage.dispose();
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				grass[i][j].img.dispose();
			}
		}
		rayHandler.dispose();
	}
}
