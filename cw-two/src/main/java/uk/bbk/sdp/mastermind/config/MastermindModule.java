package uk.bbk.sdp.mastermind.config;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import uk.bbk.sdp.mastermind.model.*;

import java.io.IOException;
import java.util.Properties;

public class MastermindModule extends AbstractModule {

    private final String MASTERMIND_PROPERTIES_FILE = "mastermind.properties";

    @Override
    protected void configure() {
        Properties props = null;
        try {
            props = loadProperties();
            Names.bindProperties(binder(), props);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bind(Mastermind.class).in(Singleton.class);
        install(new FactoryModuleBuilder()
                .implement(Game.class, GameImpl.class)
                .build(GameFactory.class));
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(MastermindModule.class.getClassLoader().getResource(MASTERMIND_PROPERTIES_FILE).openStream());
        return properties;
    }
}
