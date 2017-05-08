package com.rbuxton.dungeoneer.map;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rbuxton.dungeoneer.entity.Entity;
import com.rbuxton.dungeoneer.misc.Constants;

public class RoomMap {
	private Tile[][] tMap;
	private ArrayList<Entity> entities;
	private Random gen;
	
	public RoomMap(){
		gen = new Random();
		tMap = new Tile[Constants.ROOM_HEIGHT][Constants.ROOM_WIDTH];
		entities = new ArrayList<Entity>();
	}
	
	public void generate(boolean u, boolean d, boolean l, boolean r){
		//set all to floor
		for(int i = 0; i < tMap.length; i++){
			for(int j = 0; j < tMap[i].length; j++){
				tMap[i][j] = new Tile(Constants.TILE_TYPE_FLOOR);
			}
		}
		
		//set bounding walls
		for(int i = 0; i < tMap.length; i ++){
			tMap[0][i] = new Tile(Constants.TILE_TYPE_WALL);
			tMap[tMap.length - 1][i] = new Tile(Constants.TILE_TYPE_WALL);
		}
		for(int i = 0; i < tMap[0].length; i++){
			tMap[i][0] = new Tile(Constants.TILE_TYPE_WALL);
			tMap[i][tMap[0].length - 1] = new Tile(Constants.TILE_TYPE_WALL);
		}
		
		//open doors
		if(u){
			tMap[0][(Constants.ROOM_WIDTH/2)] = new Tile(Constants.TILE_TYPE_UP);
			tMap[0][(Constants.ROOM_WIDTH/2) + 1] = new Tile(Constants.TILE_TYPE_UP);
		}
		if(d){
			tMap[Constants.ROOM_HEIGHT - 1][(Constants.ROOM_WIDTH/2)] = new Tile(Constants.TILE_TYPE_DOWN);
			tMap[Constants.ROOM_HEIGHT - 1][(Constants.ROOM_WIDTH/2) + 1] = new Tile(Constants.TILE_TYPE_DOWN);
		}
		if(l){
			tMap[(Constants.ROOM_HEIGHT/2)][0] = new Tile(Constants.TILE_TYPE_LEFT);
			tMap[(Constants.ROOM_HEIGHT/2) + 1][0] = new Tile(Constants.TILE_TYPE_LEFT);
		}
		if(r){
			tMap[(Constants.ROOM_HEIGHT/2)][Constants.ROOM_WIDTH -1] = new Tile(Constants.TILE_TYPE_RIGHT);
			tMap[(Constants.ROOM_HEIGHT/2) + 1][Constants.ROOM_WIDTH -1] = new Tile(Constants.TILE_TYPE_RIGHT);
		}
		
		//debug keystones
		tMap[0][0] = new Tile(-9999);
		
		tMap[2][2] = new Tile(-9999);
	}
	
	public void render(SpriteBatch batch, int offsetX, int offsetY){
		for(int y = tMap.length - 1; y > -1; y--){
			for(int x = 0; x < tMap[y].length; x++){
				if(x > -1 && x < tMap[0].length && y > -1 && y < tMap.length){
					tMap[y][x].render(batch, (x * Constants.TILE_WIDTH) - offsetX,
							(y * Constants.TILE_HEIGHT) - offsetY);
				}
			}
		}
	}

	public Tile getTile(int x, int y){ return tMap[y][x]; }
	
}
