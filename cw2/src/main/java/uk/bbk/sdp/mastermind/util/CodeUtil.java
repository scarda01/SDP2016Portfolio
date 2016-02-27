package uk.bbk.sdp.mastermind.util;

import org.apache.commons.lang3.StringUtils;
import uk.bbk.sdp.mastermind.model.Colour;

import java.util.List;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;

public class CodeUtil {

    public static List<Colour> processColours(String coloursStr) {
        List<Colour> colours = newArrayList();
        if (StringUtils.isBlank(coloursStr)) {
            return colours;
        }
        String[] coloursNames = coloursStr.split(",");
        for(String colourName : coloursNames) {
            Colour colour = new Colour(colourName.trim().toUpperCase());
            if (!colours.contains(colour)) {
                colours.add(colour);
            }
        }
        return colours;
    }

    public static String generateSecretCode(List<Colour> colours, Integer size) {
        System.out.print("Generating secret code... ");
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (sb.length() < size) {
            sb.append(colours.get(random.nextInt(size)).getUPInitial());
        }
        System.out.println("Done.");
        return sb.toString();
    }
}
