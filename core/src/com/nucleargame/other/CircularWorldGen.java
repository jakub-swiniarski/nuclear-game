package com.nucleargame.other;

public class CircularWorldGen {
    public int radius;
    public int[][] tile;
    public int row;

    public CircularWorldGen(){
        row=2;
        radius=10;
        tile=new int[radius][radius];
        for(int i=0; i<radius; i++){
            for(int j=0; j<radius; j++){
                tile[i][j]=0;
            }
        }
    }
    public void generate(){
        //💀💀💀
    }
}
