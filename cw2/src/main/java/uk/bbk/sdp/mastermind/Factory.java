package uk.bbk.sdp.mastermind;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Factory {

    public static Game getInstance(Class c, Boolean b){
        Injector injector = Guice.createInjector(new AppInjector());

        Game game = (Game) injector.getInstance(c);
        return game;
    }
}
