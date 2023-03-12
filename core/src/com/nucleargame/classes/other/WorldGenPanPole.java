package com.nucleargame.classes.other;

public class WorldGenPanPole {
    public int width,height;
    public int[][] world;

    public void playerInput(){
        //world gen settings
    }
    public void generate(){
        world=new int[width][height];
        //2d array of tile ids
        //the actual tiles will be generated in the main game class using the previously generated array
        //trees and ores will be generated in the main game class
        //each grass tile will have a chance to generate a tree (stone tiles will generate ores)
    }
}
