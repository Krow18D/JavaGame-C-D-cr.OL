/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ol.frogger;
import java.io.Serializable;

/**
 *
 * @author N8NNY
 */
public class Score implements Serializable{
    private int hiscore;

    
    
    public Score(int hiscore) {
        this.hiscore = hiscore;
    }

    public int getHiscore() {
        return hiscore;
    }

    public void setHiscore(int hiscore) {
        this.hiscore = hiscore;
    }
    
    
}
