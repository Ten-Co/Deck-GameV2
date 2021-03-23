package com.tenco.game;

import com.badlogic.gdx.graphics.Texture;

public class TextureHandler {
    static Texture goblin, wizard, checkerboard, spell, drop;
    public static void createAll(){
        goblin = new Texture("goblin.png");
        wizard = new Texture("wizard.jpg");
        checkerboard = new Texture("checkerboard.png");
        spell = new Texture("spell.png");
        drop = new Texture("drop.png");
    }
    public static void disposeAll(){
        goblin.dispose();
        wizard.dispose();
        checkerboard.dispose();
        spell.dispose();
        drop.dispose();
    }
}
