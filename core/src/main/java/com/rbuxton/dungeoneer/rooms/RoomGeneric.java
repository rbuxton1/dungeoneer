package com.rbuxton.dungeoneer.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.rbuxton.dungeoneer.entity.Player;
import com.rbuxton.dungeoneer.main.Main;
import com.rbuxton.dungeoneer.map.RoomMap;
import com.rbuxton.dungeoneer.misc.Constants;

public class RoomGeneric implements Screen{
	private Main main;
	private RoomMap rm;
	private Player player;
	
	public RoomGeneric(Main main){
		this.main = main;
		rm = new RoomMap();
		rm.generate(true, true, true, true);
		player = new Player(rm, 0, 0);
	}
	
	@Override
	public void render(float delta) {
		main.getCam().update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        main.getBatch().begin();
		//rm.render(main.getBatch(), 0, 0);
        
		
		
        main.getBatch().setProjectionMatrix(main.getCam().combined);
		
        rm.render(main.getBatch(), player.getX(), player.getY());
        player.render(main.getBatch());
        
        
		main.getWorldMap().renderMiniMap((int)(main.getCam().viewportWidth - (15 * 8)), Constants.SCREEN_HEIGHT - (15*8), main.getBatch());
		main.getBatch().end();
	}

	@Override
	public void resize(int width, int height) {}
	@Override
	public void show() {}
	@Override
	public void pause() {}
	@Override
	public void resume() {}
	@Override
	public void hide() {}
	@Override
	public void dispose() {}
}
