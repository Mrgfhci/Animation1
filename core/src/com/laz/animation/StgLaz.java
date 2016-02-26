package com.laz.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;


public class StgLaz extends Stage {

    //GamLaz gamLaz;
    DPad dpad;
    ActChar actChar;
    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;


    public StgLaz() {

       super(new ScalingViewport(Scaling.stretch, APP_WIDTH, APP_HEIGHT, new OrthographicCamera(APP_WIDTH, APP_HEIGHT)));
        actChar = new ActChar();
        dpad = new DPad(actChar);
        this.addActor(actChar);
        this.addActor(dpad.imgOutline);
        for (int i = 0; i < 4; i++) {
            this.addActor(dpad.ibDir[i]);
        }
        Gdx.input.setInputProcessor(this);
    }
}
