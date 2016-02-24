package uk.bbk.sdp.mastermind.util;

import org.junit.Before;
import org.junit.Test;
import uk.bbk.sdp.mastermind.model.Colour;

import java.io.ByteArrayInputStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static uk.bbk.sdp.mastermind.util.PlayerUtil.isValidInput;

public class PlayerUtilTest {
    private List<Colour> colours;
    private int size;

    @Before
    public void setup() {
        colours = newArrayList(
                new Colour("blue"),
                new Colour("green"),
                new Colour("orange"),
                new Colour("purple"),
                new Colour("red"),
                new Colour("yellow"));
        size = 4;
    }


    @Test
    public void readGuessTest() {
        String data = "OBGO";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        assertEquals(data, PlayerUtil.readGuess(System.in));
    }

    @Test
    public void isGuessValidTest(){
        String data = "OBGO";
        assertTrue(isValidInput(data, colours, size));
    }

    @Test
    public void isGuessNotValidInSizeTest(){
        String data = "OOOOOO";
        assertFalse(isValidInput(data, colours, size));
    }

    @Test
    public void isGuessNotValidInColoursTest(){
        String data = "OOXO";
        assertFalse(isValidInput(data, colours, size));
    }

    @Test
    public void isGuessNotValidAtAllTest(){
        String data = "OOXOXB";
        assertFalse(isValidInput(data, colours, size));
    }
}
