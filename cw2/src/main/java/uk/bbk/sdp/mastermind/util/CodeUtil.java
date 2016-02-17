package uk.bbk.sdp.mastermind.util;

import uk.bbk.sdp.mastermind.model.Colour;

import java.util.List;
import java.util.Random;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class CodeUtil {

    public static String generateCode(List<Colour> colours, int size) {

        StringBuilder code = new StringBuilder();
        for(int i = 0; i<size; i++) {
            int index = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
            code.append(colours.get(index).getUPInitial());
        }
        return code.toString();
    }
}
