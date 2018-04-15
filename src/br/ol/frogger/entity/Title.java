package br.ol.frogger.entity;


import br.ol.frogger.FroggerEntity;
import br.ol.frogger.FroggerScene;
import br.ol.frogger.FroggerScene.SceneState;
import static br.ol.frogger.FroggerScene.SceneState.*;
import br.ol.ge.core.Keyboard;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import br.ol.ge.core.Difficult;

/**
 * Title class.
 * 
 * @author Leonardo Ono (ono.leo@gmail.com)
 */
public class Title extends FroggerEntity {
    
    private final String textPushSpace = "PUSH SPACE TO START";
    private final String textOriginalBy = "ORIGINAL GAME BY";
    private final String textCredit = "PROGRAMMED BY O.L. (C) 2017";
    private final String easytext = "Easy";
    private final String normaltext = "Normal";
    private final String hardtext = "Hard";
    private static int passdiff; 
    private static int countdiff=1;
    private boolean textPushSpaceVisible;
    Difficult diff ;
    public Title(FroggerScene scene) {
        super(scene);
    }

    public static int getCountdiff() {
        return countdiff;
    }

    public static int getPassdiff() {
        return passdiff;
    }

    
    
    @Override
    public void init() {
        setCollidible(false);
        loadImage("title.png");
    }
    
    @Override
    public void updateTitle() {
        textPushSpaceVisible = ((int) (System.nanoTime() * 0.000000005) % 3) < 2;
        if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) 
        {
            scene.startGame();    
//            if(countdiff==1)diff.setCar_velo(2);
//            if(countdiff==2)diff.setCar_velo(4);
//            if(countdiff==3)diff.setCar_velo(6);
        passdiff=countdiff;

                
        }
        if(Keyboard.isKeyPressed(KeyEvent.VK_DOWN))
        {
            countdiff++;
            if(countdiff>3)countdiff=1;
        }
        else if(Keyboard.isKeyPressed(KeyEvent.VK_UP))
        {
            countdiff--;
            if(countdiff<1)countdiff=3;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        if (textPushSpaceVisible) {
            scene.drawText(g, textPushSpace, 36, 120, Color.WHITE);
        }
        scene.drawText(g, textCredit, 4, 184, Color.WHITE);
        scene.drawText(g, textOriginalBy, 44, 208, Color.WHITE);
        if(countdiff==1)scene.drawText(g, easytext, 36, 130, Color.RED);
        else scene.drawText(g, easytext, 36, 130, Color.WHITE);
        if(countdiff==2)scene.drawText(g, normaltext, 36, 140, Color.RED);
        else scene.drawText(g, normaltext, 36, 140, Color.WHITE);
        if(countdiff==3)scene.drawText(g, hardtext, 36, 150, Color.RED);
        else scene.drawText(g, hardtext, 36, 150, Color.WHITE);
    }
    
    @Override
    public void sceneStateChanged(SceneState newState) {
        setVisible(newState == TITLE);
    }
        
}
