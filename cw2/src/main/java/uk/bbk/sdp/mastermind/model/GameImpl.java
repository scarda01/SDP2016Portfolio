package uk.bbk.sdp.mastermind.model;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import uk.bbk.sdp.mastermind.util.CodeUtil;
import uk.bbk.sdp.mastermind.util.PlayerUtil;

import java.util.Scanner;

import static java.lang.String.format;
import static uk.bbk.sdp.mastermind.util.GameUtil.checkGuess;
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
        int gameGuesses = this.guesses;

        while(gameGuesses > 0) {
            System.out.println(format(REMAINING_GUESSES_MSG, gameGuesses));
            System.out.println(displaySecretCode());

            String playerGuess = readPlayerGuess();

            if (isGuessCorrect(playerGuess)) {
                System.out.println(SUCCESS_MSG);
                gameGuesses = this.guesses;
                if (!playAgain()) break;
            }
            gameGuesses--;
            if (gameGuesses == 0) {
                System.out.println(INSUCCESS_MSG);
                gameGuesses = this.guesses;
                if (!playAgain()) break;
            }
        }
    }

    private boolean playAgain() {
        System.out.println(PLAY_AGAIN_MSG);
        if ("Y".equalsIgnoreCase(new Scanner(System.in).next())) {
            code.setSecretCode(CodeUtil.generateSecretCode(code.getColours(), code.getSize()));
            return true;
        } else {
            return false;
        }
    }

    private String readPlayerGuess() {
        String playerGuess = readGuess(System.in);
        while (!PlayerUtil.isValidInput(playerGuess, code.getColours(), code.getSize())) {
            System.out.println(INVALID_INPUT_MSG);
            playerGuess = readGuess(System.in);
        }
        return playerGuess;
    }


    private boolean isGuessCorrect(String playerGuess) {
        String result = checkGuess(playerGuess, code.getSecretCode());
        if (StringUtils.countMatches(result, Colour.BLACK) == code.getSize()) {
            return true;
        }
        return false;
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
