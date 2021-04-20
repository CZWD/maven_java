/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_RIL;

/**
 *
 * @author Alex
 */
public class SkillFactory {
    public static Skill create(SkillList a ){
        switch(a){
            case A1:
                return new Attaque("Lutte", 5);
            case A2:
                return new Attaque("Eclair", 8);
            case A3:
                return new Attaque("Boule de feu", 10);
            case A4:
                return new Attaque("Tonnerre", 12);
            case A5:
                return new Attaque("Griffe", 7);
                
            case H1:
                return new Soin("Soin", 10);
                
            case W1:
                return new AttaquePlus("Concentration", 6);   
                
            case X1:
                return new AttaqueMoins("Rugissement", 4);  
                
            case Y1:
                return new ResistePlus("Protection", 3);  
                
            case Z1:
                return new ResisteMoins("Mimi queue", 2);  
                
            default:
                return new Attaque("Lutte", 5);
        }
    }
}
