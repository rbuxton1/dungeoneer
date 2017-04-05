package com.rbuxton.dungeoneer.map;

import java.util.Random;

public class WorldMap {
	private Room[][] map;

	public WorldMap(){
		map = new Room[64][64];
		for(int i = 0; 1 < map.length; i++){
			for(int j = 0; j < map[0].length; j++){
				map[i][j] = new Room();
			}
		}
	}
	
	public void generate(){
		/*
		 * Steps:
		 *  -select room to be the treasure room (Has to be somewhere inside)
		 *  -Path every room to that room OR choose a couple and path those then path all rooms to other rooms
		 *   somehow
		 */
		Random gen = new Random();
		map[24 + gen.nextInt(16)][24 + gen.nextInt(16)].setBossRoom(true);
		
		int numConnect = gen.nextInt(16); //Connect 16 random rooms to the magic room
		for(int i = 0; i < numConnect; i ++){
			int x = gen.nextInt(64);
			int y = gen.nextInt(64);
			
		}
		
	}
}
