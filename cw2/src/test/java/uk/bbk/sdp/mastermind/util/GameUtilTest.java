package uk.bbk.sdp.mastermind.util;

import org.junit.Test;
import uk.bbk.sdp.mastermind.Colour;
import uk.bbk.sdp.mastermind.ColourFactory;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class GameUtilTest {

    @Test
    public void testCodeGeneration() throws IOException {
        // Generate a code that is 4 characters long
        Set<Colour> colours = ColourFactory.readColours();
        assertEquals(GameUtil.generateCode(colours, 4), "BBBB");
        assertEquals(GameUtil.generateCode(colours, 4).length(), 4);
    }
}
