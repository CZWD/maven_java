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

public class ArtificialIntelligence {
    
    
 
  public static Creature randomCreature()  {
      CreatureList id = CreatureList.randomValue();
      Creature rand = CreatureFactory.create(id);
      return rand;
  }
 

  public static Skill randomSkill()  {
      SkillList id = SkillList.randomValue();
      Skill rand = SkillFactory.create(id);
      return rand;
  }


  
}