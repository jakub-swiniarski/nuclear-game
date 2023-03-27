package com.nucleargame.other;

public class WorldGenAttempt2 {
    public int width,height;
    public int[][] tile;

    public WorldGenAttempt2(){
        width=50;
        height=50;
        tile=new int[width][height];
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                tile[i][j]=0;
            }
        }
    }
    public void generate(){
        for(int i=height; i>=height/2; i++){
            for(int j=0; j<width; j++){
                
            }
        }
    }
}
