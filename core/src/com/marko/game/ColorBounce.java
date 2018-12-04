package com.marko.game;

import com.marko.handlers.Loader;
import com.marko.screens.GameScreen;
import com.badlogic.gdx.Game;

public class ColorBounce extends Game {

	public void create(){
		Loader.load();
        setScreen(new GameScreen(this));
    }

	public void dispose(){Loader.dispose();

	}

}

