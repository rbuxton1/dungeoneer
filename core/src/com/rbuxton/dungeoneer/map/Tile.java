package com.rbuxton.dungeoneer.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.rbuxton.dungeoneer.misc.Constants;

public class Tile {
	private Texture img;
	private int type;
	
	public Tile(int type){
		this.type = type;
		if(type == Constants.TILE_TYPE_FLOOR){
			img = new Texture("map/floor.png");
		} else if(type == Constants.TILE_TYPE_WALL){
			img = new Texture("map/wall.png");
		} else if(type == Constants.TILE_TYPE_LEFT){
			img = new Texture("map/left.png");
		} else if(type == Constants.TILE_TYPE_RIGHT){
			img = new Texture("map/right.png");
		} else if(type == Constants.TILE_TYPE_UP){
			img = new Texture("map/up.png");
		} else if(type == Constants.TILE_TYPE_DOWN){
			img = new Texture("map/down.png");
		} 
		
		else {
			img = new Texture("map/missing.png");
		}
	}
	
	public void render(SpriteBatch batch, int x, int y){
		batch.draw(img, x, y);
	}
	
	public int getType(){ return type; }
}
