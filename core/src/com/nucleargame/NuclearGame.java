package com.nucleargame;

import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.nucleargame.entity.Player;
import com.nucleargame.items.RawUranium;
import com.nucleargame.other.WorldGenPanPole;
import com.nucleargame.tiles.Grass;
import com.nucleargame.tiles.Sand;
import com.nucleargame.tiles.Stone;
import com.nucleargame.tiles.Water;
import com.nucleargame.ui.Heart;
import com.nucleargame.ui.RadiationWarning;

public class NuclearGame extends ApplicationAdapter {
	SpriteBatch batch;
	FreeTypeFontGenerator generator;
	FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	BitmapFont font24;
	Player player;
	World world;
	Stage stage;
	RayHandler rayHandler;
	//Grass[][] grass;
	//Tree[][] tree;
	WorldGenPanPole worldgen;
	RawUranium uran;
	Heart heart;
	RadiationWarning radWar;
	int tile[][]={
			{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
			{0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},
			{0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
			{0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},

			{2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3},
			{0,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,0},
			{0,0,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,0,0},
			{0,0,0,2,2,2,2,2,2,2,3,3,3,3,3,3,3,0,0,0},
			{0,0,0,0,2,2,2,2,2,2,3,3,3,3,3,3,0,0,0,0},
			{0,0,0,0,0,2,2,2,2,2,3,3,3,3,3,0,0,0,0,0},
			{0,0,0,0,0,0,2,2,2,2,3,3,3,3,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,2,2,2,3,3,3,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,2,2,3,3,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,2,3,0,0,0,0,0,0,0,0,0}
	};
	int waterCount=0,
	grassCount=0,
	sandCount=0,
	stoneCount=0;

	Water[] water;
	Grass[] grass;
	Sand[] sand;
	Stone[] stone;

	@Override
	public void create () {
		batch = new SpriteBatch();
		player=new Player();

		stage = new Stage();
		world = new World(new Vector2(0,0),false);

		//font
		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/com-hel.otf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 24;
		font24 = generator.generateFont(parameter);

		//lightning
		rayHandler = new RayHandler(world);
		rayHandler.setCombinedMatrix(player.cam.combined);
		player.light = new PointLight(rayHandler,50, Color.DARK_GRAY,5000,0,0	); //during night lower to 1000

		//world generation
		/*worldgen=new WorldGenPanPole();
		worldgen.generate();
		grass=new Grass[worldgen.width][worldgen.height];
		tree=new Tree[worldgen.width][worldgen.height];
		for(int i=0; i<worldgen.width; i++) {
			for(int j=0; j<worldgen.height; j++) {
				grass[i][j]=new Grass();
				grass[i][j].rect.x=i*grass[i][j].rect.width-(worldgen.width/2)*160;
				grass[i][j].rect.y=j*grass[i][j].rect.height-(worldgen.height/2)*160;

				if(worldgen.content[i][j]==1){
					tree[i][j]=new Tree();
					tree[i][j].rect.x=grass[i][j].rect.x;
					tree[i][j].rect.y=grass[i][j].rect.y;
				}
			}
		}*/

		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				if(tile[i][j]==0){
					waterCount++;
				}
				if(tile[i][j]==1){
					grassCount++;
				}
				if(tile[i][j]==2){
					sandCount++;
				}
				if(tile[i][j]==3){
					stoneCount++;
				}
			}
		}
		water=new Water[waterCount];
		grass=new Grass[grassCount];
		sand=new Sand[sandCount];
		stone=new Stone[stoneCount];
		//reuse the variables for initializing
		waterCount=0;
		grassCount=0;
		sandCount=0;
		stoneCount=0;
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				if(tile[j][i]==0){
					water[waterCount]=new Water();
					water[waterCount].rect.x=i*160;
					water[waterCount].rect.y=3200-j*160;
					waterCount++;
				}
				if(tile[j][i]==1){
					grass[grassCount]=new Grass();
					grass[grassCount].rect.x=i*160;
					grass[grassCount].rect.y=3200-j*160;
					grassCount++;
				}
				if(tile[j][i]==2){
					sand[sandCount]=new Sand();
					sand[sandCount].rect.x=i*160;
					sand[sandCount].rect.y=3200-j*160;
					sandCount++;
				}
				if(tile[j][i]==3){
					stone[stoneCount]=new Stone();
					stone[stoneCount].rect.x=i*160;
					stone[stoneCount].rect.y=3200-j*160;
					stoneCount++;
				}
			}
		}

		//put the player in the middle
		player.rect.x=1600;
		player.rect.y=1600;

		//items
		uran=new RawUranium();
		uran.rect.x=player.rect.x+800;
		uran.rect.y=player.rect.y+800;
		uran.light = new PointLight(rayHandler,50, Color.GREEN,250,9999,9999);

		//ui
		heart=new Heart();
		radWar=new RadiationWarning();
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
		/*for(int i=0; i<worldgen.width; i++) {
			for(int j=0; j<worldgen.height; j++) {
				if(grass[i][j].rect.x+grass[i][j].rect.width>=player.cam.position.x-(player.cam.viewportWidth/2) &&
						grass[i][j].rect.x<=player.cam.position.x+(player.cam.viewportWidth/2) &&
						grass[i][j].rect.y+grass[i][j].rect.height>=player.cam.position.y-(player.cam.viewportHeight/2) &&
						grass[i][j].rect.y<=player.cam.position.y+(player.cam.viewportHeight/2))
					batch.draw(grass[i][j].img,grass[i][j].rect.x,grass[i][j].rect.y);
			}
		}
		for(int i=0; i<worldgen.width; i++) {
			for(int j=worldgen.height-1; j>0; j--) {
				if(worldgen.content[i][j]==1){
					if(tree[i][j].rect.x+tree[i][j].rect.width>=player.cam.position.x-(player.cam.viewportWidth/2) &&
							tree[i][j].rect.x<=player.cam.position.x+(player.cam.viewportWidth/2) &&
							tree[i][j].rect.y+tree[i][j].rect.height>=player.cam.position.y-(player.cam.viewportHeight/2) &&
							tree[i][j].rect.y<=player.cam.position.y+(player.cam.viewportHeight/2))
						batch.draw(tree[i][j].imgTrunk,tree[i][j].rect.x,tree[i][j].rect.y);
					tree[i][j].collisionCheck();
				}
			}
		}*/

		for(int i=0; i<waterCount; i++) {
				batch.draw(water[i].img,water[i].rect.x,water[i].rect.y);
		}
		for(int i=0; i<sandCount; i++) {
				batch.draw(sand[i].img,sand[i].rect.x,sand[i].rect.y);
		}
		for(int i=0; i<grassCount; i++) {
				batch.draw(grass[i].img,grass[i].rect.x,grass[i].rect.y);
		}
		for(int i=0; i<stoneCount; i++) {
				batch.draw(stone[i].img,stone[i].rect.x,stone[i].rect.y);
		}

		batch.draw(uran.img,uran.rect.x,uran.rect.y);
		rayHandler.setCombinedMatrix(player.cam.combined);
		uran.light.setPosition(uran.rect.x+uran.rect.width/2,uran.rect.y+uran.rect.height/2);
		batch.draw(player.img, player.rect.x, player.rect.y);

		/*for(int i=0; i<worldgen.width; i++) {
			for(int j=worldgen.height-1; j>0; j--) {
				if(worldgen.content[i][j]==1){
					if(tree[i][j].rect.x+tree[i][j].rect.width>=player.cam.position.x-(player.cam.viewportWidth/2) &&
							tree[i][j].rect.x<=player.cam.position.x+(player.cam.viewportWidth/2) &&
							tree[i][j].rect.y+tree[i][j].rect.height>=player.cam.position.y-(player.cam.viewportHeight/2) &&
							tree[i][j].rect.y<=player.cam.position.y+(player.cam.viewportHeight/2))
						batch.draw(tree[i][j].imgCrown,tree[i][j].rect.x,tree[i][j].rect.y+200);
				}
			}
		}*/
		batch.end();

		rayHandler.updateAndRender();

		//not affected by light, ui
		batch.setProjectionMatrix(stage.getBatch().getProjectionMatrix());
		batch.begin();
		batch.draw(heart.img, heart.rect.x,heart.rect.y);
		if(radWar.visible) batch.draw(radWar.img,radWar.rect.x,radWar.rect.y);
		font24.draw(batch, "FPS: "+Gdx.graphics.getFramesPerSecond(), 5, 20);
		font24.draw(batch, "HP: "+player.hp,80,880);
		batch.end();

		player.checkForInput();
		uran.checkForProximity();
	}

	@Override
	public void dispose () {
		batch.dispose();

		//world
		for(int i=0; i<waterCount; i++) {
			water[i].img.dispose();
		}
		for(int i=0; i<grassCount; i++) {
			grass[i].img.dispose();
		}
		for(int i=0; i<sandCount; i++) {
			sand[i].img.dispose();
		}
		for(int i=0; i<stoneCount; i++) {
			stone[i].img.dispose();
		}
		/*for(int i=0; i<worldgen.width; i++) {
			for(int j=0; j<worldgen.height; j++) {
				grass[i][j].img.dispose();
				if(worldgen.content[i][j]==1){
					tree[i][j].img.dispose();
					tree[i][j].imgTrunk.dispose();
					tree[i][j].imgCrown.dispose();
				}
			}
		}*/
		uran.img.dispose();
		world.dispose();
		stage.dispose();

		//entities
		player.img.dispose();

		//fonts
		generator.dispose();
		font24.dispose();

		//light
		rayHandler.dispose();
		player.light.dispose();
		uran.light.dispose();

		//ui
		heart.img.dispose();
		radWar.img.dispose();
	}
}
