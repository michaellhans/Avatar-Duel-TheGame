package com.avatarduel.gameState;

import com.avatarduel.card.*;
import com.avatarduel.gameManager.*;
import com.avatarduel.player.*;

public class Main1Phase extends GameState implements IMouseClickSub{
    private Card selectedCard;
    private RoundInfo roundInfo;

    public Main1Phase(GameManager gameManager){
        super(gameManager);
    }

    public void StartTurn(){
        // Subscribe to mouse click subs
        RegisterMouseClick(this);
        RegisterMouseMove(this);
    }

    public void EndTurn(){
        // Unsubscribe to mouse click subs
        List<IMouseClickSub> mc = getMouseClickSubs();
        List<IMouseMoveSub> mm = getMouseMoveSubs();
        mc.remove(this);
        mm.remove(this);
        setMouseClickSubs(mc);
        setMouseMoveSubs(mm);
        // Pindah ke main 2 phase, dan kirim round infonya
        GameManager gm = getGameManager();
        GameState gs = new BattlePhase(gm);
        gm.setGameState(gs);
        super.gameState(gm);
    }

    public void OnMouseClick (MouseEvent event){
        // Kalau klik di kartu di hand, simpan kartu ke SelectedCard
        // Kalau engga, SelectedCard set null
        Card cardClicked = getChosenCard();
        List<Character> pc = getPlayedCards();
        boolean adaKartu = pc.contains(cardClicked);
        if (!adaKartu) {
            this.selectedCard = cardClicked;
        }
        else {
            this.selectedCard = null;
        }
        // Kalau ada kartu yang selected, dan klik di arena di area yang valid, pindahin kartu ke arena
        // (Cek dulu cardCanBePlayed), simpan kartu ke playedCards di RoundInfo.
		// Kalau engga dan klik di arena, putar kartu Karakter atau buang kartu skill
        boolean cek = CanBePlayed(getPlayerStats());
        if ((this.selectedCard != null) && (cek)) {
            if (cardClicked == charCard) {
                if (isCharacter && !characterSlotOccupied) {
                    addCharacterCard(event, cardClicked);
                }
            }
            else if (cardClicked == skills) {
                if (!isCharacter && !skillSlotOccupied) {
                    addSkillCard(event, cardClicked);
                }
            }
            addPlayedCards(cardClicked);
        }
        else {
            Card c = getChosenCard();
            if (c == charCard) {
                if (getIsDefense() == true) {
                    setIsDefense(false);
                }
                else {
                    setIsDefense(true);
                }
            }
            else if (c == skills) {
                removeSkillCard(event);
            }
        }
    }
}