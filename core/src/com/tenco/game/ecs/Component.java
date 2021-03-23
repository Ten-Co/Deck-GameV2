package com.tenco.game.ecs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public abstract class Component {
    public static HashMap<Entity, Texture> images;
    public static HashMap<Entity, Vector2> positions;

    public static void bootUp(){
        images = new HashMap<>();
        positions = new HashMap<>();
    }
}
