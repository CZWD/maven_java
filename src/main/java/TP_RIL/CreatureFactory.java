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
public class CreatureFactory {

    public static Creature create(CreatureList a ){
        Skill A1 = SkillFactory.create(SkillList.A1);
        switch(a){
            case C1:
                Creature Pikachu = new Pikachu("Pikachu", 30, 32, 5);
                Pikachu.learnSkill(A1);
                return Pikachu;
                
            case C2:
                Creature Dragon = new Dragon("Dragon", 40, 20, 8);
                Dragon.learnSkill(A1);
                return Dragon;
            case C3:
                Creature Chat = new Chat("Chat", 45, 12, 3);
                Chat.learnSkill(A1);
                return Chat;
            default:
                return null;
        }
    }
    

}
