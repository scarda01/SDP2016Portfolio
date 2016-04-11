package uk.bbk.sdp.mastermind.model;

import com.google.inject.Inject;
import lombok.Getter;

public class Mastermind {

    @Inject
    private @Getter GameFactory gameFactory;
}
