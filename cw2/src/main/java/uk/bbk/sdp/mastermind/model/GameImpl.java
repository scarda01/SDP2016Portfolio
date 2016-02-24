package uk.bbk.sdp.mastermind.model;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import uk.bbk.sdp.mastermind.util.PlayerUtil;

import static uk.bbk.sdp.mastermind.util.PlayerUtil.checkGuess;
import static uk.bbk.sdp.mastermind.util.PlayerUtil.readGuess;

public class GameImpl extends GameAbstractImpl {

    private static final String MSG_CODE_PREFIX = "The secret code is ";

    @Inject
    private @Getter Code code;
    @Inject @Named("guesses") @Getter private Integer guesses;

    @Inject
    public GameImpl(@Assisted("easy") boolean easy) {
        super(easy);
    }

    @Override
    public void runGames() {
        while(guesses > 0) {
            System.out.println(displaySecretCode());
            String playerGuess = readGuess(System.in);
            while (!PlayerUtil.isValidInput(playerGuess, this.getCode().getColours(), this.getCode().getSize()))
            {
                System.out.println("Invalid Input. Please guess again");
                playerGuess = readGuess(System.in);
            }

            checkGuess(playerGuess, code.getSecretCode());
            guesses--;
        }
        System.out.println("You could not solved the puzzle. Try again later.");
    }



    private String displaySecretCode() {
        StringBuilder sb = new StringBuilder(MSG_CODE_PREFIX);
        if (showCode) {
            sb.append(code.getSecretCode());
        } else {
            sb.append("hidden");
        }
        return sb.toString();
    }
}
