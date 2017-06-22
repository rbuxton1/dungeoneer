package com.rbuxton.dungeoneer.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.rbuxton.dungeoneer.map.RoomMap;
import com.rbuxton.dungeoneer.misc.Constants;

public class Player implements Entity{
	private RoomMap rm;
	private Texture img;
	private Vector2 pos;
	private int xOff, yOff;
	private int moveSpeed = 8;
	
	public Player(RoomMap r, int x, int y){
		rm = r;
		pos = new Vector2(x * Constants.TILE_WIDTH, y * Constants.TILE_HEIGHT);
		img = new Texture("entity/play_test.png");
		xOff = 4;
		yOff = 3;
	}
	
	public void render(SpriteBatch b){
		if(Gdx.input.isKeyPressed(Keys.W)){
			if(rm.getTile((int)((pos.x) / Constants.TILE_WIDTH), (int)((pos.y + moveSpeed) / Constants.TILE_HEIGHT)).getType() != Constants.TILE_TYPE_WALL){
				pos.y += moveSpeed;
			}
		}
		if(Gdx.input.isKeyPressed(Keys.S)){
			if(rm.getTile((int)((pos.x) / Constants.TILE_WIDTH), (int)((pos.y - moveSpeed) / Constants.TILE_HEIGHT)).getType() != Constants.TILE_TYPE_WALL){
				pos.y -= moveSpeed;
			}
		}
		if(Gdx.input.isKeyPressed(Keys.A)){
			if(rm.getTile((int)((pos.x - moveSpeed) / Constants.TILE_WIDTH), (int)((pos.y) / Constants.TILE_HEIGHT)).getType() != Constants.TILE_TYPE_WALL){
				pos.x -= moveSpeed;
			}
		}
		if(Gdx.input.isKeyPressed(Keys.D)){
			if(rm.getTile((int)((pos.x + moveSpeed) / Constants.TILE_WIDTH), (int)((pos.y) / Constants.TILE_HEIGHT)).getType() != Constants.TILE_TYPE_WALL){
				pos.x += moveSpeed;
			}
		}
		
		b.draw(img, Constants.SCREEN_WIDTH/2 - img.getWidth()/2, Constants.SCREEN_HEIGHT/2 - img.getHeight()/2);
		
	}

	public int getX(){ return (int)pos.x; }
	public int getY(){ return (int)pos.y; }
}
