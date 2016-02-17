package uk.bbk.sdp.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class ColourFactory {

    public static Set<Colour> readColours() throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ColourFactory.class.getClassLoader().getResourceAsStream("colours.txt")));
        StringBuilder responseData = new StringBuilder();
        final Set<Colour> colours = new HashSet<Colour>();
        in.lines().forEach(line -> colours.add(new Colour(line)));
        return colours;
    }
}
