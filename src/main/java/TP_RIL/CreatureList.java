/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_RIL;

import java.util.Random;




/**
 *
 * @author Alex
 */
public enum CreatureList {
    C1, C2, C3;
    
    
    
    public static CreatureList randomValue(){
        CreatureList[] tab = CreatureList.values();
        Random generator = new Random();
        return tab[generator.nextInt(tab.length)];
    }
}

