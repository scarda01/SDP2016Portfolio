package uk.bbk.sdp.mastermind.model;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import lombok.Getter;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class GameImpl extends GameAbstractImpl {

    @Inject
    private @Getter Code code;

    @Inject
    public GameImpl(@Assisted("easy") boolean easy) {
        super(easy);
    }

    @Override
    public void runGames() {

    }
}
