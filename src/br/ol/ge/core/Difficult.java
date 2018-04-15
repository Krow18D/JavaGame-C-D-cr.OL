/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ol.ge.core;

/**
 *
 * @author karin
 */
public class Difficult {
    private static double car_velo=7;

    public Difficult(double car_velo) {
        this.car_velo = car_velo;
    }

    public Difficult() {
    }

    
    public double  getCar_velo() {
        return car_velo;
    }

    public void setCar_velo(double car_velo) {
        this.car_velo = car_velo;
    }
    
    
   
    
}
