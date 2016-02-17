package uk.bbk.sdp.mastermind;

import uk.bbk.sdp.mastermind.model.Colour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class ColourFactory {

    public static List<Colour> readColours() throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ColourFactory.class.getClassLoader().getResourceAsStream("colours.txt")));
        StringBuilder responseData = new StringBuilder();
        final List<Colour> colours = new ArrayList<>();
        String[] coloursNames = in.lines().toArray()[1].toString().split(",");
        for(String colourName : coloursNames) {
            Colour colour = new Colour(colourName);
            if (!colours.contains(colour))
                colours.add(colour);
        }
        return colours;
    }
}
