package com.rbuxton.dungeoneer.map;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.rbuxton.dungeoneer.misc.Constants;

public class WorldMap {
	private Map map;
	private Vector2 boss;
	private int width = 8;
	private int height = 8;
	private Vector2 activeRoom;

	public WorldMap(){
		map = new Map(width, height);
	}
	
	public void generate(){
		/*
		 * Steps:
		 *  -select room to be the treasure room (Has to be somewhere inside)
		 *  -Path every room to that room OR choose a couple and path those then path all rooms to other rooms
		 *   somehow
		 */
		map = new Map(width, height);
		Random gen = new Random();
		boss = new Vector2(gen.nextInt(width), gen.nextInt(height));
		map.get(boss.x, boss.y).setBossRoom(true);
		
		int numConnect = 4 + gen.nextInt(10); //Connect 16 random rooms to the magic room
		Gdx.app.log(Constants.debugFlag, "connecters: " + numConnect);
		Vector2 r = new Vector2(0,0);
		for(int i = 0; i < numConnect; i++){
			r.set(gen.nextInt(map.getWidth()), gen.nextInt(map.getHeight()));
			if(activeRoom == null){
				map.get(r.x, r.y).setActiveRoom(true);
				activeRoom = r;
			}
			path(r, boss);
		}
	}
	
	public Vector2 getActiveRoom(){
		Vector2 a = new Vector2(0, 0);
		for(int y = 0; y < map.getHeight(); y++){
			for(int x = 0; x < map.getWidth(); x++){
				if(map.get(x, y).isActive()) a.set(x, y);
			}
		}
		return a;
	}
	
	public void path(Vector2 cur, Vector2 tar){
		
		int count = 0;
		while(cur.x != tar.x || cur.y != tar.y){
			if(cur.x != tar.x){
				if(cur.x > tar.x){
					map.get(cur.x, cur.y).setRightHall(true);
					cur.set(cur.x - 1, cur.y);
					map.get(cur.x, cur.y).setLeftHall(true);
				}
				if(cur.x < tar.x){
					map.get(cur.x, cur.y).setLeftHall(true);
					cur.set(cur.x + 1, cur.y);
					map.get(cur.x, cur.y).setRightHall(true);
				}
			}
			if(cur.y  != tar.y){
				if(cur.y > tar.y){
					map.get(cur.x, cur.y).setDownHall(true);
					cur.set(cur.x, cur.y - 1);
					map.get(cur.x, cur.y).setUpHall(true);
				}
				if(cur.y < tar.y){
					map.get(cur.x, cur.y).setUpHall(true);
					cur.set(cur.x, cur.y + 1);
					map.get(cur.x, cur.y).setDownHall(true);
				}
			}
			count++;
		}
	}

	public void renderMiniMap(int sx, int sy, SpriteBatch batch){
		Texture room = new Texture("minimap/mm-none.png");
		Texture hall = new Texture("minimap/mm-hall.png");
		Texture boss = new Texture("minimap/mm-boss.png");
		Texture bg = new Texture("minimap/mm-bg.png");
		Texture here = new Texture("minimap/mm-activ.png");
		
		batch.draw(bg, sx, sy);
		int cx = sx;
		int cy = sy;
		
		for(int y = 0; y < map.getHeight(); y++){
			for(int x = 0; x < map.getWidth(); x++){
				if(map.get(x, y).isConnected()){
					if(map.get(x, y).isBossRoom()) batch.draw(boss, cx, cy);
					else batch.draw(room, cx, cy);
					
					if(activeRoom != null) if(map.get(x, y).isActive()) batch.draw(here, cx, cy);
				}
				
				
				if(map.get(x, y).isUpHall()) batch.draw(hall, cx + 6, cy + 12);
				if(map.get(x, y).isDownHall()) batch.draw(hall, cx + 6, cy);
				
				/*
				 * TODO: These two are toggeled, find out if this is me being dumb or if theyre just
				 * 		legit swapped and its going to cause major headaches later
				 */
				if(map.get(x, y).isRightHall()) batch.draw(hall, cx, cy + 6);
				if(map.get(x, y).isLeftHall()) batch.draw(hall, cx + 12, cy+6);
				cx = cx + 15;
			}
			cx = sx;
			cy = cy + 15;
		}
	}
}
