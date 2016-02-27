package uk.bbk.sdp.mastermind.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static uk.bbk.sdp.mastermind.util.GameUtil.checkGuess;
import static uk.bbk.sdp.mastermind.util.PlayerUtil.NO_PEGS;

public class GameTest {

    @Test
    public void checkGuessTest() {
        assertEquals("Black", checkGuess("YRRR", "YGGG"));
        assertEquals(NO_PEGS, checkGuess("OOOO", "YRBY"));
        assertEquals("Black", checkGuess("GRGG", "YRBY"));
        assertEquals("White", checkGuess("GGRG", "YRBY"));
        assertEquals("White", checkGuess("RGRG", "YRBY"));
        assertEquals("Black", checkGuess("RRRR", "YRBY"));
        assertEquals("Black Black Black Black", checkGuess("YRBY", "YRBY"));
        assertEquals("Black", checkGuess("GGGG", "PRGP"));
        assertEquals("Black Black", checkGuess("PPPP", "PRGP"));
        assertEquals(NO_PEGS, checkGuess("RRRR", "BBBP"));
        assertEquals(NO_PEGS, checkGuess("RRRR", "BBBP"));
        assertEquals(NO_PEGS, checkGuess("RRRR", "BBBP"));
        assertEquals(NO_PEGS, checkGuess("RRRR", "BBBP"));
        assertEquals(NO_PEGS, checkGuess("RRRR", "BBBP"));
        assertEquals("Black Black Black", checkGuess("BBBB", "BBBP"));
        assertEquals("Black Black", checkGuess("BOOB", "BBPB"));
        assertEquals("Black Black Black", checkGuess("BBOB", "BBPB"));
        assertEquals("Black Black White", checkGuess("BOBB", "BBBP"));
        assertEquals("Black Black White White", checkGuess("BBPB", "BBBP"));
        assertEquals("Black Black White White", checkGuess("PBBB", "BBBP"));
        assertEquals("Black Black Black Black", checkGuess("BBBP", "BBBP"));
    }
}
