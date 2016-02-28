package uk.bbk.sdp.mastermind.model;

public interface Game {

    String SECRET_CODE_PREFIX_MSG = "The secret code is ";
    String SUCCESS_MSG    = "You solved the puzzle! Good job.";
    String INSUCCESS_MSG  = "You did not solve the puzzle. Too bad.";
    String PLAY_AGAIN_MSG = "Enter Y for another game or anything else to quit:";
    String REMAINING_GUESSES_MSG = "You have %d guesses left.";
    String INVALID_INPUT_MSG     = "Invalid Input. Please guess again";
    /**
     * Run a one or more game sof mastermind, until the player
     * quits.
     */
    void runGames();
}