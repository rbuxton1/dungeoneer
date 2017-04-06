package com.rbuxton.dugeoneer.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.rbuxton.dungeoneer.map.WorldMap;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private WorldMap wm;
    private OrthographicCamera cam;
    private Viewport port;

    @Override
    public void create() {
    	cam = new OrthographicCamera();
		port = new FillViewport(12 * 5, 12 * 5, cam);
		cam.setToOrtho(true);
		port.apply();
		cam.position.set(cam.viewportWidth/2.0f, cam.viewportHeight/2.0f, 0f);
    	
        batch = new SpriteBatch();
        
        image = new Texture("ks.png");
        wm = new WorldMap();
        wm.generate();
    }

    @Override
    public void render() {
    	cam.update();
    	
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        //batch.draw(image, 0, 0);
        wm.renderMap(0,0, batch);
        batch.end();
        
        if(Gdx.input.isKeyJustPressed(Keys.F5)){
        	wm.generate();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}