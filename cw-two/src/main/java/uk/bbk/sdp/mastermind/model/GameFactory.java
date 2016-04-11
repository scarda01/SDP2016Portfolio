package uk.bbk.sdp.mastermind.model;

import com.google.inject.assistedinject.Assisted;

public interface GameFactory {
    Game create(@Assisted("easy") boolean easy);
}
