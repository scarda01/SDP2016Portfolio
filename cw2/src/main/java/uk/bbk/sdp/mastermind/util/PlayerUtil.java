package uk.bbk.sdp.mastermind.util;

import org.apache.commons.lang3.StringUtils;
import uk.bbk.sdp.mastermind.model.Colour;

import java.io.InputStream;
import java.util.*;

import static uk.bbk.sdp.mastermind.util.CodeUtil.processColours;

public class PlayerUtil {

    public static final String NO_PEGS = "No Pegs";

    public static String readGuess(InputStream in) {
        System.out.println("What is your next guess?");
        Scanner scan = new Scanner(in);
        return scan.next();
    }

    public static String readPlay(InputStream in) {
        System.out.println("What is your next guess?");
        Scanner scan = new Scanner(in);
        return scan.next();
    }

    public static boolean isValidInput(String guess, List<Colour> colours, int size) {
        if(guess.length() != size){
            return false;
        }
        if(!StringUtils.isAlpha(guess)){
            return false;
        }

        for(Character character : guess.toCharArray()) {
            boolean isValid = false;
            for(Colour colour : colours) {
                if(character == colour.getUPInitial().charAt(0)){
                   isValid = true;
                   break;
                }
            }
            if(!isValid) {
                return false;
            }
        }
        return true;
    }


}
