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

    public static String checkGuess(String playerGuess, String secretCode) {
        Map<String,String> codeMap = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();

        for(int index = 0; index < playerGuess.length(); index++) {
            codeMap.put(secretCode.substring(index, index+1) + index,"");
        }

        char [] guessArray = playerGuess.toCharArray();
        for(int i = 0; i < guessArray.length; i++) {
            boolean isWhite = false;
            char [] codeArray = secretCode.toCharArray();
            for(int j = 0; j < codeArray.length; j++) {
                if (guessArray[i] == codeArray[j]) {
                    if (i == j) {
                        codeMap.put(secretCode.substring(j, j+1) + i, "Black ");
                        break;
                    } else {
                        if(!isWhite && codeMap.get(secretCode.substring(j, j+1) + i) == "") {
                            codeMap.put(secretCode.substring(j, j+1) + i, "White ");
                            isWhite = true;
                        }
                    }
                }
            }
        }
        for(String finalString : codeMap.values()) {
            result.append(finalString);
        }
        return (codeMap.values().stream().filter(x -> x != "").count() == 0) ? NO_PEGS : result.toString().trim();
    }
}
