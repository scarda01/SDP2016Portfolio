package uk.bbk.sdp.mastermind;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import uk.bbk.sdp.mastermind.model.Code;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class GameImpl extends GameAbstractImpl {

    private Code code;


    @Inject
    public GameImpl(Code code, @Assisted boolean easy) {
        super(easy);
    }

    @Override
    public void runGames() {

    }
}
