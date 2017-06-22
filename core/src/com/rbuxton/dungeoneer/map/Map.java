package com.rbuxton.dungeoneer.map;

public class Map {
	private Room[][] map;
	
	public Map(int width, int height){
		map = new Room[width][height];
		
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				map[i][j] = new Room();
			}
		}
	}
	
	public void removeNonConnect(){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[1].length; j++){
				if(!map[i][j].isDownHall() && !map[i][j].isUpHall() && !map[i][j].isLeftHall() && !map[i][j].isRightHall()){
					map[i][j] = null;
				}
			}
		}
	}
	
	public Room get(int x, int y){ return map[y][x]; }
	public Room get(float x, float y){ return map[(int)y][(int)x]; }
	public int getWidth(){ return map[0].length; }
	public int getHeight(){ return map.length; }
}
