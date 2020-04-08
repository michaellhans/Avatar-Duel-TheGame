// Destroy.java

package com.avatarduel.card;
import com.avatarduel.sprite.CardSprite;
import com.avatarduel.gameManager.*;
import com.avatarduel.player.*;
import com.avatarduel.model.*;

public class Destroy extends Skill {
    // CONSTRUCTOR
    public Destroy(String name, Element elmt, String desc, CardSprite sprite, int pn){
        super(name, elmt, desc, sprite, pn);
    }

    // METHODS
    public void OnCardPlayed(GameManager gm, int idx){
        // hapus musuh di sisi berlawanan
        gm.getOppositePlayer().getPlayerArena().removeCharacterCard(idx);
    }

    public boolean CanBePlayed(PlayerStats ps){
        if (ps.getRemainingPower(super.getElmt()) >= this.powerNeeded){
            return true;
        }
        else {
            return false;
        }
    }
}