package au.com.kamailio.skillset.backend.component;

import javax.inject.Singleton;

import au.com.kamailio.skillset.backend.module.DummyServiceModule;
import au.com.kamailio.skillset.ui.HomeActivity;
import dagger.Component;

/**
 * Created by FRincon on 6/09/16.
 */
@Singleton
@Component(modules = {DummyServiceModule.class})

public interface DiDummyComponent {
    // to update the fields in your activities
    void inject(HomeActivity activity);
}

