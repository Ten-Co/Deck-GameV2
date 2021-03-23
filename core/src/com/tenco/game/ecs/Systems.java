package com.tenco.game.ecs;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class Systems {
    public static Systems systems; //singleton

    //put all of the lists here
    public ArrayList<Entity> drawable;
    public ArrayList<Entity> moving;

    private Systems(){ //singleton
        drawable = new ArrayList<>();
    }
    public static void init(){
        systems = new Systems();
    }
    public static Systems get(){
        return systems;
    }

    public void draw(SpriteBatch batch, OrthographicCamera camera){
        //wipe the screen every frame
        ScreenUtils.clear(0, 0, 0.2f, 1);

        //update the camera every frame
        camera.update();

        //start actually drawing sprites
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        Texture texture;
        Vector2 position;
        for (Entity e: drawable){
            texture = Component.images.get(e);
            position = Component.positions.get(e);
            batch.draw(texture, position.x, position.y);
        }
        batch.end();
    }
}
