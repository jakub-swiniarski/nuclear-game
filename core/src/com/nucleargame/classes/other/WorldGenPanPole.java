package com.nucleargame.classes.other;

public class WorldGenPanPole {
    public int width,height;
    public int[][] tile;
    public int[][] content;

    public WorldGenPanPole(){
        width=16;
        height=9;
    }
    /*public void playerInput(){
        //world gen settings
    }*/
    public void generate(){
        tile=new int[width][height];
        content=new int[width][height];
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                tile[i][j]=1;
                if((int)(Math.random() * 20)==0){
                    content[i][j]=1;
                }
            }
        }
        //2d array of tile ids
        //the actual tiles will be generated in the main game class using the previously generated array
        //trees and ores will be generated in the main game class
        //each grass tile will have a chance to generate a tree (stone tiles will generate ores)

        //2d array of objects such as trees and ores
    }
}
