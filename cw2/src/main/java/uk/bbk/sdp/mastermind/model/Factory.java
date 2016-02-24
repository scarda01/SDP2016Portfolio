package uk.bbk.sdp.mastermind.model;

import com.google.inject.Guice;
import com.google.inject.Injector;
import uk.bbk.sdp.mastermind.config.MastermindModule;

public class Factory {

    public static Game getInstance(Class clazz, Boolean easy){
        if (clazz.isAssignableFrom(Game.class)) {
            Injector injector = Guice.createInjector(new MastermindModule());
            Mastermind mastermind = injector.getInstance(Mastermind.class);
            return mastermind.getGameFactory().create(easy);
        }
        return null;
    }
}
