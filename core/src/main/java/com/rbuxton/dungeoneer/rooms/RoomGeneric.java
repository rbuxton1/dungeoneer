package com.rbuxton.dungeoneer.rooms;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.rbuxton.dugeoneer.main.Main;

public class RoomGeneric implements Screen{
	private Main main;
	
	public RoomGeneric(Main main){
		this.main = main;
	}
	
	@Override
	public void render(float delta) {
		main.getCam().update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        main.getBatch().setProjectionMatrix(main.getCam().combined);
        
		main.getBatch().begin();
		main.getWorldMap().renderMiniMap((int)(main.getCam().viewportWidth - (15 * 8)), 0, main.getBatch());
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
