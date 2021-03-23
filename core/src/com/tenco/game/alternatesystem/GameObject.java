package com.tenco.game.alternatesystem;

import com.badlogic.gdx.graphics.Texture;

public abstract class GameObject {
    float x, y; //position
    Texture texture;

    abstract void update();
    abstract void onCollision();
}
