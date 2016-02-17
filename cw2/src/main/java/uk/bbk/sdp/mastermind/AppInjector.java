package uk.bbk.sdp.mastermind;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryProvider;

/**
 * Created by scarda01 on 17/02/2016.
 */
public class AppInjector  extends AbstractModule {

    @Override
    protected void configure() {
        bind(Factory.class).toProvider(
                FactoryProvider.newFactory(Factory.class, GameImpl.class));
    }
}
