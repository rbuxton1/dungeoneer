package com.rbuxton.dungeoneer.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.rbuxton.dungeoneer.map.WorldMap;
import com.rbuxton.dungeoneer.misc.Constants;

public class GameScreen implements Screen{
	private WorldMap wm;
	private Main main;
	
	public GameScreen(Main main){
		this.main = main;
		wm = new WorldMap();
		wm.generate();
	}



	@Override
	public void render(float delta) {
		main.getCam().update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        main.getBatch().begin();
        main.getBatch().setProjectionMatrix(main.getCam().combined);
        
        wm.renderMiniMap((int)(main.getCam().viewportWidth - (15 * 8)), Constants.SCREEN_HEIGHT - (15*8), main.getBatch());
        
        main.getBatch().end();
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
