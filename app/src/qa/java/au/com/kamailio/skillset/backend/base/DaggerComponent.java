package au.com.kamailio.skillset.backend.base;


import javax.inject.Singleton;

import au.com.kamailio.skillset.backend.module.MainModule;
import au.com.kamailio.skillset.backend.module.QAApiModule;
import au.com.kamailio.skillset.backend.module.QADataModule;
import au.com.kamailio.skillset.base.DaggerApplication;
import au.com.kamailio.skillset.base.DaggerInjectGraph;
import dagger.Component;

@Singleton
@Component(modules = { MainModule.class, QADataModule.class, QAApiModule.class })
public interface DaggerComponent extends DaggerInjectGraph {
    static final class Initializer {
        private Initializer() {
        } // No instances.

        public static DaggerComponent init(DaggerApplication app) {
            return DaggerDaggerComponent.builder()
                                             .mainModule(new MainModule(app))
                                             .build();
        }
    }
}