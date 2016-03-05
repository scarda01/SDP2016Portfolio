package uk.bbk.sdp.mastermind;

import uk.bbk.sdp.mastermind.model.Factory;
import uk.bbk.sdp.mastermind.model.Game;

public class MastermindDriver {

    public static void main(String[] args) {
        Game g1 = Factory.getInstance(Game.class, true);
        g1.runGames();
    }
}