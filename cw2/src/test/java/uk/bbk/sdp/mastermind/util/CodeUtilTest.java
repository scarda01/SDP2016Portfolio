package uk.bbk.sdp.mastermind.util;

import org.junit.Test;
import uk.bbk.sdp.mastermind.model.Colour;
import uk.bbk.sdp.mastermind.ColourFactory;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class CodeUtilTest {

    @Test
    public void testCodeGeneration() throws IOException {
        List<Colour> colours = ColourFactory.readColours();

        // Test that a generated code is 4 characters long
        assertEquals(CodeUtil.generateCode(colours, 4).length(), 4);
        // // Test that a generated code is 5 characters long
        assertEquals(CodeUtil.generateCode(colours, 5).length(), 5);
        // // Test that a generated code is 5 characters long
        assertNotEquals(CodeUtil.generateCode(colours, 5).length(), 6);


    }
}
