package uk.bbk.sdp.mastermind.util;

import org.junit.Before;
import org.junit.Test;
import uk.bbk.sdp.mastermind.model.Colour;

import java.io.IOException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.junit.Assert.*;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class CodeUtilTest {

    private List<Colour> colours;

    @Before
    public void setup() {
        colours = newArrayList(
                new Colour("blue"),
                new Colour("green"),
                new Colour("orange"),
                new Colour("purple"),
                new Colour("red"),
                new Colour("yellow"));
    }

    @Test
    public void processColoursTest() {
        String colours = "blue,green,orange,purple,red,yellow";
        assertNotNull(CodeUtil.processColours(colours).size());
        assertEquals(6, CodeUtil.processColours(colours).size());
    }

    @Test
    public void repeatedColours_shouldNoBeProcessed() {
        String colours = "blue,green,orange,purple,red,yellow,orange,green";
        assertNotNull(CodeUtil.processColours(colours).size());
        assertEquals(6, CodeUtil.processColours(colours).size());
    }

    @Test
    public void generateSecretCodeTest() {
        String secretCode = CodeUtil.generateSecretCode(colours, 4);
        assertNotNull(secretCode);
        assertTrue(isAlpha(secretCode));
        assertEquals(4, secretCode.length());

        String secretCode2 = CodeUtil.generateSecretCode(colours, 5);
        assertNotNull(secretCode2);
        assertTrue(isAlpha(secretCode));
        assertEquals(5, secretCode2.length());
    }

    @Test
    public void testCodeGeneration() throws IOException {
        // Test that a generated code is 4 characters long
        assertEquals(CodeUtil.generateSecretCode(colours, 4).length(), 4);
        // // Test that a generated code is 5 characters long
        assertEquals(CodeUtil.generateSecretCode(colours, 5).length(), 5);
        // // Test that a generated code is 5 characters long
        assertNotEquals(CodeUtil.generateSecretCode(colours, 5).length(), 6);
    }
}
