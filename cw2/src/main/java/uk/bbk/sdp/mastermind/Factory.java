package uk.bbk.sdp.mastermind;

import com.google.inject.Guice;
import com.google.inject.Injector;
import uk.bbk.sdp.mastermind.config.MastermindModule;
import uk.bbk.sdp.mastermind.model.Code;

public class Factory {

    public static Game getInstance(Class clazz, Boolean easy){
        Injector injector = Guice.createInjector(new MastermindModule());

        Code code = (Code) injector.getInstance(Code.class);
//        Game game = (Game) injector.getInstance(clazz);
        return null;
    }
}
