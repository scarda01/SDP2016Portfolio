package uk.bbk.sdp.mastermind.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GameUtil {

    public static String checkGuess(String playerGuess, String secretCode) {
        StringBuilder sb  = new StringBuilder();
        Map<Character, Integer> codeColoursCount = new HashMap();
        Map<Character, Integer> guessColoursCount = new HashMap();
        int blacks = 0;
        int whites = 0;

        // calculate black pegs
        for(int i=0; i < playerGuess.length(); i++) {
            char pegGuess = playerGuess.charAt(i);
            char pegCode = secretCode.charAt(i);

            // if same colour
            if (pegGuess == pegCode) {
                sb.append("Black ");
                blacks++;
            }

            // count the number of colours
            guessColoursCount.put(pegGuess, guessColoursCount.get(pegGuess) == null ? 1 : guessColoursCount.get(pegGuess) + 1);
            codeColoursCount.put(pegCode, codeColoursCount.get(pegCode) == null ? 1 : codeColoursCount.get(pegCode) + 1);
        }

        //calculate white pegs
        calculateWhitePegs(sb, codeColoursCount, guessColoursCount, blacks, whites);

        return sb.length() == 0 ?  "No Pegs" : sb.toString().trim();
    }

    private static void calculateWhitePegs(StringBuilder sb, Map<Character, Integer> codeColoursCount, Map<Character, Integer> guessColoursCount, int blacks, int whites) {
        // calculate white pegs
        Iterator<Character> guessColoursKeys = guessColoursCount.keySet().iterator();
        while(guessColoursKeys.hasNext()) {
            Character peg = guessColoursKeys.next();
            if (codeColoursCount.containsKey(peg)) {
                whites += Math.min(guessColoursCount.get(peg), codeColoursCount.get(peg));
            }
        }

        whites -= blacks;
        while (whites-- > 0) {
            sb.append("White ");
        }
    }
}
