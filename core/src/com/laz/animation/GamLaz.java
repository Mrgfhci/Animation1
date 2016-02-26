package com.laz.animation;
// getting some ugly crash from Animation, so I created Animation1 to isolate the issue.
// going to try to load everything but the stage.
// yup it works - now time to load a stage that does nothing
// the original is in 000 Android Stuff folder.
// going to model this off of scene2dWorks file and add animation and dPad

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GamLaz extends Game {


    @Override
    public void create() {
        // you must pass a new instance of a screen when you set it. Don't create it then pass the instance later.
        setScreen(new ScrLaz(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
