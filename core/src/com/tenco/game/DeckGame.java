package com.tenco.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.tenco.game.ecs.Component;
import com.tenco.game.ecs.Entity;
import com.tenco.game.ecs.Systems;

import java.util.ArrayList;


public class DeckGame extends ApplicationAdapter {
	//shorthand for config.width & config.height
	public static int width = 800, height = 480;

	//camera and sprite batch
	private OrthographicCamera camera;
	private SpriteBatch batch;

	//the systems sort of are the game (in standard ecs)
	Systems systems;

	//for the clicking thing
	Vector3 touchPos;
	ArrayList<Entity> drops;
	private boolean lastClick;

	@Override
	public void create () {
		//load images
		TextureHandler.createAll();

		//set up the camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false, width, height);

		//set up sprite batch
		batch = new SpriteBatch();

		//create the ECS stuff
		Systems.init();
		systems = Systems.get();
		Entity.bootUp();
		Component.bootUp();

		//set up stuff for clicking
		touchPos = new Vector3();
		drops = new ArrayList<>(4);
	}

	@Override
	public void render () {
		systems.draw(batch, camera);

		//move the bucket to wherever you click
		handleClicking();
	}
	void handleClicking(){
		boolean click = Gdx.input.isTouched();
		if(click && !lastClick) {
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			Vector2 dropPos = new Vector2(touchPos.x + 64 / 2, touchPos.y + 64 / 2);
			Entity drop = new Entity();
			Component.images.put(drop, TextureHandler.drop);
			Component.positions.put(drop, dropPos);
			systems.drawable.add(drop);
		}
		lastClick = click;
	}

	@Override
	public void dispose () {
		TextureHandler.disposeAll();
	}
}