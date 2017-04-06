package com.rbuxton.dugeoneer.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
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
import com.rbuxton.dungeoneer.rooms.RoomGeneric;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private SpriteBatch batch;
    private Texture image;
    private WorldMap wm;
    private OrthographicCamera cam;
    private Viewport port;

    @Override
    public void create() {
    	cam = new OrthographicCamera();
		port = new FillViewport(640, 360, cam);
		cam.setToOrtho(true);
		port.apply();
		cam.position.set(cam.viewportWidth/2.0f, cam.viewportHeight/2.0f, 0f);
    	
        batch = new SpriteBatch();
        wm = new WorldMap();
        wm.generate();
        setScreen(new RoomGeneric(this));
    }

    @Override
    public void render() {
    	cam.update();
        
        batch.setProjectionMatrix(cam.combined);
        super.render();
        
        if(Gdx.input.isKeyJustPressed(Keys.F5) || Gdx.input.justTouched()){
        	wm.generate();
        }
    }

    public OrthographicCamera getCam(){ return cam; }
    public WorldMap getWorldMap(){ return wm; }
    public SpriteBatch getBatch(){ return batch; }
    
    @Override
    public void dispose() {
        batch.dispose();
    }
}