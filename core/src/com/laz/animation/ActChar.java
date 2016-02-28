package com.laz.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

//http://stackoverflow.com/questions/13780742/libgdx-difference-between-sprite-and-actor
//http://stackoverflow.com/questions/21495258/how-can-i-change-the-texture-in-a-scene2d-image-using-libgdx
//https://github.com/dinnatruong/BombermanMovement/blob/master/core/src/com/mygdx/game/Character.java
//http://stackoverflow.com/questions/22121467/remove-actors-from-stage
// having troubles drawing an image - switching the image to a Sprite - nope - using a Texture Region

public class ActChar extends Actor {

    Image imgKnight;
    Sprite sprKnight;
    TextureAtlas taKnight;
    TextureRegion trCurrentFrame, trLeft[], trRight[];
    Texture txCurrentFrame;
    Animation aniLeft, aniRight;

    float fStateTime, fX, fY, fH, fW;
    boolean bLeft, bRight, bStop;
    int nDir, nDx, nDy;

    public ActChar() {
        fX = 20; fY = 200;
        nDir = -1;
        imgKnight = new Image();
        sprKnight = new Sprite();
        System.out.println("Actor made************************************************************************");
        taKnight = new TextureAtlas("knightpacked.pack");
        trCurrentFrame = new TextureRegion();

        trLeft = new TextureRegion[3];
        trRight = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            trLeft[i] = taKnight.findRegion("knightleft" + (i + 1));
            trRight[i] = taKnight.findRegion("knightright" + (i + 1));
        }

        aniLeft = new Animation(0.15f, trLeft);
        aniRight = new Animation(0.15f, trRight);
        trCurrentFrame = trRight[0];
        fStateTime = 0f;
        bRight = true;

    }

    public void setDir(int _nDir){
        System.out.println("**************");
        nDir = _nDir;
        System.out.println(nDir);
        nDx = 0;
        nDy = 0;
        if(nDir == 0){
            nDy  = 1;
        }
        else if(nDir == 1){
            nDx = 1;
        }
        else if(nDir == 2){
            nDy = -1;
        }
        else if (nDir ==3){
            nDx = -1;
        }
        else{
            nDx = 0;
            nDy = 0;
        }

    }

    public void act(float fDelta) {
        fX+= nDx;
        fY+=nDy;
        System.out.println("x is "+ fX + " y is "+ fY);
        txCurrentFrame = trRight[0].getTexture();
        if (nDir == 1) {
            if (bStop) {
                trCurrentFrame = trRight[0];
            } else {
                trCurrentFrame = aniRight.getKeyFrame(fStateTime, true);
            }
        } else if (nDir ==3) {
            if (bStop) {
                trCurrentFrame = trLeft[0];
            } else {
                trCurrentFrame = aniLeft.getKeyFrame(fStateTime, true);
            }
        }
        fH = trCurrentFrame.getRegionHeight();
        fW = trCurrentFrame.getRegionWidth();
    }



    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(trCurrentFrame, fX, fY, fW, fH);
        fStateTime += Gdx.graphics.getDeltaTime();

    }
}
