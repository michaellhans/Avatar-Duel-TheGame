// Card.java

package com.avatarduel.card;

import com.avatarduel.sprite.CardSprite;
import com.avatarduel.gameManager.*;
import com.avatarduel.player.*;
import com.avatarduel.model.*;

public abstract class Card {
    protected String name;
    protected Element element;
    protected String description;
    protected CardSprite sprite;
    protected int powerNeeded;

    public Card(String name, Element elmt, String desc, CardSprite spr, int pow) {
        this.name = name;
        this.element = elmt;
        this.description = desc;
        this.sprite = spr;
        this.powerNeeded = pow;
    }

    // Setter for Card
    public void setName(String name) {
        this.name = name;
    }
    public void setElmt(Element elmt) {
        this.element = elmt;
    }
    public void setDesc(String desc) {
        this.description = desc;
    }
    public void setSprite(CardSprite spr) {
        this.sprite = spr;
    }
    public void setPowerNeeded(int p){
        this.powerNeeded=p;
    }

    // Getter for Card
    public String getName() {
        return this.name;
    }
    
    public Element getElmt() {
        return this.element;
    }

    public String getDesc() {
        return this.description;
    }

    public CardSprite getSprite() {
        return this.sprite;
    }

    public int getPowerNeeded() {
        return this.powerNeeded;
    }


    // Abstract Methods
    public abstract void OnCardPlayed(GameManager gm, int idx);
    public abstract boolean CanBePlayed(PlayerStats ps);

    // Public Methods
    public void DrawCardSimple(float x, float y, boolean isFlipped) {
        // do nothing
    }
    public void DrawCardDetail() {
        // do nothing
    }
    

}