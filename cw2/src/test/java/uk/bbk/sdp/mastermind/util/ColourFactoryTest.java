package uk.bbk.sdp.mastermind.util;

import org.junit.Test;
import uk.bbk.sdp.mastermind.model.Colour;
import uk.bbk.sdp.mastermind.ColourFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class ColourFactoryTest {

    @Test
    public void readColoursTest () throws IOException {
        List<Colour> colours = ColourFactory.readColours();
        assertEquals(6, colours.size());
    }
}
