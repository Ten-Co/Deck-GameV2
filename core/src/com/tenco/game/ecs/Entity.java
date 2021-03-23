package com.tenco.game.ecs;

import java.util.ArrayList;
import java.util.HashMap;

public class Entity {
    static ArrayList<Entity> masterList; //one list with all of the entities on it
    //not needed, for demo / historic purposes

    ArrayList<ArrayList> systems; //a list of all the systems this entity is in

    ArrayList<HashMap> components;//list of all the components this has/lists it's in

    //the entity needs to know which systems/components it's in/has so the delete method can work
    //what if you don't want to have an easy delete method? Then it'll take a HUGE amount of time
    //anytime you want to delete anything. And this will happen every time you delete something

    public Entity(){
        masterList.add(this);
    }
    public void delete(){ //used when you want to get rid of entity
        masterList.remove(this);
        for (ArrayList system : systems) {
            system.remove(this);
        }
        for (HashMap map : components){
            components.remove(this);
        }
    }
    public static void bootUp(){
        masterList = new ArrayList<>();
    }
}
