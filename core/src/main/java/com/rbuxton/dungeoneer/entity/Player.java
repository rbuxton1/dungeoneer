package com.rbuxton.dungeoneer.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.rbuxton.dungeoneer.map.RoomMap;
import com.rbuxton.dungeoneer.misc.Constants;

public class Player {
	private RoomMap rm;
	private Texture img;
	private Vector2 pos;
	private int xOff, yOff;
	
	public Player(RoomMap r, int x, int y){
		rm = r;
		pos = new Vector2(x,y);
		img = new Texture("entity/play_test.png");
		xOff = 4;
		yOff = 3;
	}
	
	public void render(SpriteBatch batch){
		if(Gdx.input.isKeyJustPressed(Keys.D) && (pos.x + xOff + 1) < Constants.ROOM_WIDTH){
			if(rm.getTile((int)pos.x + 1 + xOff, (int)pos.y + yOff).getType() != Constants.TILE_TYPE_WALL){
				if(xOff == 5)pos.x++;
				xOff = 5;
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.A) && (pos.x + xOff - 1) > -1){
			if(rm.getTile((int)pos.x - 1 + xOff, (int)pos.y + yOff).getType() != Constants.TILE_TYPE_WALL){
				if(xOff == 4) pos.x--;
				xOff = 4;
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.W)  && (pos.y + yOff + 1) < Constants.ROOM_HEIGHT){
			if(rm.getTile((int)pos.x + xOff, (int)pos.y + yOff + 1).getType() != Constants.TILE_TYPE_WALL){
				if(yOff == 3) pos.y++;
				yOff = 3;
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.S) && (pos.y + yOff - 1) > -1){
			if(rm.getTile((int)pos.x + xOff, (int)pos.y + yOff - 1).getType() != Constants.TILE_TYPE_WALL){
				if(yOff == 2) pos.y--;
				yOff = 2;
			}
		}
		
		batch.draw(img, (xOff * Constants.TILE_WIDTH), (yOff * Constants.TILE_HEIGHT));
		
	}

	public int getX(){ return (int)pos.x; }
	public int getY(){ return (int)pos.y; }
}
