package uk.bbk.sdp.mastermind.model;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;
import lombok.Getter;
import uk.bbk.sdp.mastermind.util.PlayerUtil;

import static java.lang.String.format;
import static uk.bbk.sdp.mastermind.util.GameUtil.*;
import static uk.bbk.sdp.mastermind.util.PlayerUtil.readGuess;

public class GameImpl extends GameAbstractImpl {

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
            System.out.println(format(REMAINING_GUESSES_MSG, guesses));
            System.out.println(displaySecretCode());
            String playerGuess = readGuess(System.in);
            while (!PlayerUtil.isValidInput(playerGuess, this.getCode().getColours(), this.getCode().getSize()))
            {
                System.out.println(INVALID_INPUT_MSG);
                playerGuess = readGuess(System.in);
            }

            checkGuess(playerGuess, code.getSecretCode());
            guesses--;
        }
        System.out.println(INSUCCESS_MSG);
    }



    private String displaySecretCode() {
        StringBuilder sb = new StringBuilder(SECRET_CODE_PREFIX_MSG);
        if (showCode) {
            sb.append(code.getSecretCode());
        } else {
            sb.append("hidden");
        }
        return sb.toString();
    }
}
