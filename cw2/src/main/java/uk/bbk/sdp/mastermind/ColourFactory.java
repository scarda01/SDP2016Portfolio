package uk.bbk.sdp.mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class ColourFactory {

    public static List<Colour> readColours() throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ColourFactory.class.getClassLoader().getResourceAsStream("colours.txt")));
        StringBuilder responseData = new StringBuilder();
        final List<Colour> colours = new ArrayList<>();
        in.lines().forEach(line -> {
            if (!colours.contains(new Colour(line)))
                colours.add(new Colour(line)); });
        return colours;
    }
}
