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
public enum SkillList {
    A1, A2, A3, A4, A5, H1, W1, X1, Y1, Z1;
    
    public static SkillList randomValue(){
        SkillList[] tab = SkillList.values();
        Random generator = new Random();
        return tab[generator.nextInt(tab.length)];
    }


}