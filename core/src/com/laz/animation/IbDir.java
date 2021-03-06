package com.laz.animation;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Scott on 2016-02-23.
 */
public class IbDir extends ImageButton {
    int nDir;// 0-3: up, right, down, left
    ActChar actChar;

    public IbDir(ImageButtonStyle ibs) {
        super(ibs);

        this.addListener(new ClickListener() {
            //@Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                actChar.setDir(nDir);
                return true;
            }

            //@Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //actKnight.sAction = "";
                actChar.setDir(-1);
            }
        });
    }

    void setIndex(int _nDir, ActChar _actChar){
        nDir = _nDir;
        actChar = _actChar;
    }






}
