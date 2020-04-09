// Land.java

package com.avatarduel.card;

import com.avatarduel.sprite.CardSprite;
import com.avatarduel.gameManager.*;
import com.avatarduel.player.*;
import com.avatarduel.model.*;

public class Char extends Card {
    private int atk;
    private int def;
    private boolean isDefense;
    private boolean isPoweredUp;

    public Char(String name, Element elmt, String desc, 
        CardSprite spr , int pow, int atk, int def){
        super(name, elmt, desc, spr, pow);
        this.atk = atk;
        this.def = def;
        this.isDefense = false;
        this.isPoweredUp = false;
    }

    // Getter for Character
    public int getAttack(){
        return this.atk;
    }

    public int getAttack(Aura ar){
        return this.atk + ar.getAttack();
    }
    
    public int getDefense(){
        return this.def;
    }   

    public int getDefense(Aura ar){
        if (this.isDefense) {
            return this.def + ar.getDefense();
        }
        else {
            return this.getAttack(ar);
        }
    }

    public boolean getIsDefense() {
        return this.isDefense;
    }

    public boolean getIsPoweredUp() {
        return this.isPoweredUp;
    }


    // Setter for Character;
    public void setAttack(int atk) {
        this.atk=atk;
    }

    public void setDefense(int def) {
        this.def=def;
    }

    public void setIsDefense(boolean isdef) {
        this.isDefense=isdef;
    }

    public void setIsPoweredUp(boolean b) {
        this.isPoweredUp=b;
    }


    // Method Implementation
    public void OnCardPlayed(GameManager gm, int idx, boolean isPlayedonEnemy){
        PlayerArena temp = gm.getCurrentPlayer().getPlayerArena();
        temp.addCharacterCard(idx,this);
        gm.getCurrentPlayer().setPlayerArena(temp);
    }

    public boolean CanBePlayed(PlayerStats ps){
        if (ps.getRemainingPower(this.element) >= this.powerNeeded) {
            //ps.usePower(super.getElmt(), 1);
            return true;
        }
        else {
            return false;
        }
    }
}